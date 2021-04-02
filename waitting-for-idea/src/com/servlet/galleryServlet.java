package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.cartDao;
import com.dao.productDao;
import com.dao.userDao;
import com.model.Cart;
import com.model.Product;

@WebServlet("/gallery")
public class galleryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private productDao pd;
	private String email;
	private cartDao cd;
	private ArrayList<Cart> cs;
	private userDao ud;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		pd = new productDao();
		cd = new cartDao();
		cs = new ArrayList<Cart>();
		ud = new userDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		email = (String) request.getSession().getAttribute("user_email");
		if(email!=null&&email!="") {
			cs = cd.allInCartOfUser(ud.getUserByEmail(email).getUser_id());
		}
		request.setAttribute("cart", cs.size());
		listProduct(request, response);
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> p = pd.lstProduct();
		request.setAttribute("listProduct", p);
		request.getRequestDispatcher("/View/user/gallery.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
