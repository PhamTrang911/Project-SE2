package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.adminDao;

@WebServlet("/loginAdmin/*")
public class loginAdminServlet extends HttpServlet{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private adminDao ad;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ad = new adminDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String action = req.getPathInfo();
		
		if(action == null) {
			showLoginAdmin(req, resp);
		}else{
			switch (action) {
			case "/login":
				loginAdmin(req, resp);
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
	
	private void showLoginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("View/admin/login.jsp").forward(request, response);
		return;
	}
	
	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isSuccess = ad.login(username, password);
		if(isSuccess) {
			response.sendRedirect(request.getContextPath()+"/admins");
		}else {
			request.setAttribute("isFalse", isSuccess);
			response.sendRedirect(request.getContextPath()+"/loginAdmin");
		}
		return;
	}
}
