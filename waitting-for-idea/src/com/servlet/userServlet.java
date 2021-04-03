package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.broadnewDao;
import com.dao.cartDao;
import com.dao.discountDao;
import com.dao.orderedDao;
import com.dao.userDao;
import com.model.Cart;
import com.model.Order;
import com.model.User;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/user/*")
public class userServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private cartDao cd;
	private userDao ud;
	private discountDao dd;
	private broadnewDao bd;
	private String email;
	private orderedDao od;
	private ArrayList<Cart> cs;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cd = new cartDao();
		ud = new userDao();
		dd = new discountDao();
		bd = new broadnewDao();
		od = new orderedDao();
		cs = new ArrayList<Cart>();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
			email = (String) req.getSession().getAttribute("user_email");
			if(email!=null&&email!="") {
				cs = cd.allInCartOfUser(ud.getUserByEmail(email).getUser_id());
			}
			req.setAttribute("cart", cs.size());
			String action = req.getPathInfo();
			if(action == null) {
				showShop(req, resp);
			}else{
				switch (action) {
				case "/cart":
					if(email==null||email=="") {
						resp.sendRedirect(req.getContextPath()+"/login");
						return;
					}
					showCart(req, resp);
					break;
				case "/profile":
					if(email==null||email=="") {
						resp.sendRedirect(req.getContextPath()+"/login");
						return;
					}
					accountInfo(req, resp);
					break;
				case "/history":
					if(email==null||email=="") {
						resp.sendRedirect(req.getContextPath()+"/login");
						return;
					}
					purchaseInfo(req, resp);
					break;
				case "/logout":
					logout(req, resp);
					break;
				case "/checkout":
					checkout(req,resp);
					break;
				case "/update":
					update(req,resp);
					break;
				default:
					break;
				}
			}
			return;
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fN = req.getParameter("first-name");
		String lN = req.getParameter("last-name");
		String e = req.getParameter("email");
		String pass = req.getParameter("pass");
		String p = req.getParameter("phone");
		String dob = req.getParameter("dob");
		ud.updateUser(new User(fN, lN, e, pass, p, dob));
		resp.sendRedirect(req.getContextPath()+"/user/profile");
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
	private void checkout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = ud.getUserByEmail(email);
		req.setAttribute("firstName", u.getFirstName());
		req.setAttribute("lastName", u.getLastName());
		req.setAttribute("email", u.getEmail());
		req.setAttribute("sub", req.getParameter("sub"));
		req.setAttribute("disc", req.getParameter("disc"));
		req.setAttribute("tax", req.getParameter("tax"));
		req.setAttribute("ship", req.getParameter("ship"));
		req.setAttribute("total", req.getParameter("total"));
		req.getRequestDispatcher("/View/user/checkout.jsp").forward(req, resp);
	}
	
	public void showShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("blogs", bd.listBroadnew().subList(1, 4));
		RequestDispatcher rd = req.getRequestDispatcher("View/user/index.jsp");
		rd.forward(req, resp);
		return;
	}
	
	public void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = ud.getUserByEmail(email).getUser_id();
			ArrayList<Cart> cart = cd.allInCartOfUser(user_id);
			String cart_ids = "";
			for(Cart c:cart) {
				cart_ids += c.getCart_id()+",";
			}
			req.setAttribute("discount", dd.listDiscount());
			req.setAttribute("carts", cart);
			req.setAttribute("cart_ids", cart_ids);
			RequestDispatcher rd = req.getRequestDispatcher("/View/user/cart.jsp");
			rd.forward(req, resp);
	}
	
	public void accountInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", ud.getUserByEmail(email));
		RequestDispatcher rd = req.getRequestDispatcher("/View/user/my-account.jsp");
		rd.forward(req, resp);
	}

	
	private void purchaseInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Order> orders = od.listOrderByUser(ud.getUserByEmail(email).getUser_id());
		req.setAttribute("ordered", orders);
		RequestDispatcher rd = req.getRequestDispatcher("/View/user/history.jsp");
		rd.forward(req, resp);
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().removeAttribute("user_email");
		resp.sendRedirect(req.getContextPath()+"/product");
	}
}
