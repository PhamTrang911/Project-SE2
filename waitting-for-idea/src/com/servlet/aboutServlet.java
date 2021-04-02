package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.cartDao;
import com.dao.orderedDao;
import com.dao.userDao;
import com.model.Cart;

@WebServlet("/about")
public class aboutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private cartDao cd;
	private ArrayList<Cart> cs;
	private userDao ud;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cd = new cartDao();
		cs = new ArrayList<Cart>();
		ud = new userDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		email = (String) req.getSession().getAttribute("user_email");
		if(email!=null&&email!="") {
			cs = cd.allInCartOfUser(ud.getUserByEmail(email).getUser_id());
		}
		req.setAttribute("cart", cs.size());
		showAbout(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		// TODO Auto-generated method stub
		try {
			doGet(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showAbout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/View/user/about.jsp").forward(req, resp);
	}
}
