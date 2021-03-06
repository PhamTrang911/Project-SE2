package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.adminDao;
import com.dao.userDao;
@WebServlet("/loginUser/*")
public class loginServlet extends HttpServlet{

	/**
	 * 
	 */
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
			showLoginUser(req, resp);
		}else{
			switch (action) {
			case "/login":
				loginUser(req, resp);
			default:
				break;
			}
		}
		return;
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
	
	private void showLoginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("View/user/login.jsp").forward(request, response);;
		return;
	}
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session;
		boolean isSuccess = ud.login(email, password);
		if(isSuccess) {
			session = request.getSession();
			session.setAttribute("user_email", email);
			response.sendRedirect(request.getContextPath()+"/Home");
		}else {
			response.sendRedirect(request.getContextPath()+"/loginUser");
		}
		return;
	}

}
