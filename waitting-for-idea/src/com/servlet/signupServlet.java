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
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ud = new userDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		try {
			doGet(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void showSignin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
		return;
	}
	
	private void submitInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("dob"),request.getParameter("password"));
		ud.insertUser(u);
		response.sendRedirect(request.getContextPath()+"/login");
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
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}
}
