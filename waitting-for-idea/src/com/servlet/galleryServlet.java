package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.productDao;
import com.model.Product;

@WebServlet("/gallery/*")
public class galleryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private productDao pd;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		pd = new productDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getPathInfo();
		if(action == null) {
			listProduct(request, response);
		}
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
