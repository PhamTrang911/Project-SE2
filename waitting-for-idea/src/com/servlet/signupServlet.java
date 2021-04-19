package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userDao;
import com.model.User;

@WebServlet("/login/*")
public class signupServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private userDao ud;
	private static String failed;
	@Override
	public void init() throws ServletException {
		super.init();
		ud = new userDao();
		failed = "none";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String action = req.getPathInfo();
		if(action == null) {
			showSignin(req, resp);
		}else{
			switch (action) {
			case "/signup":
				submitInfo(req, resp);
				break;
			case "/signin":
				signIn(req, resp);
			default:
				break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doGet(req, resp);
		} catch (Exception e) {
		}
	}
	
	private void showSignin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("failed", failed);
		failed = "none";
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
		return;
	}
	
	private void submitInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User(request.getParameter("first_name"),request.getParameter("last_name"),email,request.getParameter("phone"),request.getParameter("dob"),password);
		ud.insertUser(u);
		response.sendRedirect(request.getContextPath()+"/login/signin?email="+email+"&password="+password);
		return;
	}
	
	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email = req.getParameter("email");
		boolean login = ud.login(email, req.getParameter("password"));
		if(login) {
			HttpSession s = req.getSession();
			s.setAttribute("user_email", email);
			resp.sendRedirect(req.getContextPath()+"/user");
			return;
		}else {
			failed = "block";
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}
}
