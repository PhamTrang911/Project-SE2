package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDao;

public class userServlet extends HttpServlet{
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
			showHomePage(req, resp);
		}else{
			switch (action) {
			case "/shop":
				
				break;
			case "/myAccount":
				
				break;
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
	
	public void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("View/user/shop.jsp");
		rd.forward(req, resp);
	}
	
	public void accountInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", ud.getUserByEmail(req.getSession().getAttribute("user_email")));
		RequestDispatcher rd = req.getRequestDispatcher("View/user/my-account.jsp");
		rd.forward(req, resp);
	}
}
