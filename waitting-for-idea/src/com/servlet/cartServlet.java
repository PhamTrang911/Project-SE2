package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.cartDao;
import com.dao.userDao;
import com.model.Cart;

@WebServlet("/cart/*")
public class cartServlet extends HttpServlet{
	private cartDao cd;
	private userDao ud;
	String email;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cd = new cartDao();
		ud = new userDao();
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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		email = (String) request.getSession().getAttribute("user_email");
		if(email==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		String action = request.getPathInfo();
		switch (action) {
		case "/add":
			addItem(request,response);
			break;
		case "/delete":
			delete(request,response);
			break;
		default:
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		cd.delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/user/cart");
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int user_id = ud.getUserByEmail(email).getUser_id();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		ArrayList<Integer> cart= (ArrayList<Integer>) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new ArrayList<Integer>();
		}
		if(cart.contains(product_id)) {
			request.getSession().setAttribute("addToCart", "Product already in your cart, please check again!");
			response.sendRedirect(request.getContextPath()+"/product");
			return;
		}
		cart.add(product_id);
		request.getSession().setAttribute("cart", cart);
		
		String pName = request.getParameter("p_name");
		float pPrice = Float.parseFloat(request.getParameter("p_price"));
		String pImage = request.getParameter("p_image");
		int amount = Integer.parseInt(request.getParameter("quantity"));
		Cart c = new Cart(user_id, product_id, pName,pPrice, pImage, amount);
		cd.insert(c);
		request.getSession().setAttribute("addToCart", "Product added!");
		response.sendRedirect(request.getContextPath()+"/product");
	}
}
