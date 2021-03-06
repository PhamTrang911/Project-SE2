package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.dao.userDao;

public class profileServlet extends HttpServlet{

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
	
}
