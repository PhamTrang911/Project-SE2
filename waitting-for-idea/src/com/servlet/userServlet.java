package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.cartDao;
import com.dao.userDao;
import com.model.Cart;
import com.model.User;

@WebServlet("/user/*")
public class userServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private cartDao cd;
	private userDao ud;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cd = new cartDao();
		ud = new userDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String action = req.getPathInfo();
		if(action == null) {
			showShop(req, resp);
		}else{
			switch (action) {
			case "/cart":
				showCart(req, resp);
				break;
			case "/profile":
				accountInfo(req, resp);
				break;
			case "/history":
				purchaseInfo(req, resp);
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
	
	public void showShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("View/user/index.jsp");
		rd.forward(req, resp);
		return;
	}
	
	public void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = ud.getUserByEmail(req.getSession().getAttribute("user_email"));
		if(u != null) {
			ArrayList<Cart> cart = cd.allInCartOfUser(u.getUser_id());
			req.setAttribute("cart", cart);
			RequestDispatcher rd = req.getRequestDispatcher("/View/user/cart.jsp");
			rd.forward(req, resp);
			return;
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}
	
	public void accountInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", ud.getUserByEmail(req.getSession().getAttribute("user_email")));
		RequestDispatcher rd = req.getRequestDispatcher("/View/user/my-account.jsp");
		rd.forward(req, resp);
		return;
	}

	
	private void purchaseInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/View/user/checkout.jsp");
		rd.forward(req, resp);
		return;
	}
}
