package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.websocket.AsyncChannelWrapperNonSecure;

import com.dao.cartDao;
import com.dao.productDao;
import com.dao.reviewDao;
import com.dao.userDao;
import com.model.Product;
import com.model.Review;

@WebServlet("/product/*")
public class productServlet extends HttpServlet{
	private productDao pd;
	private userDao ud;
	private reviewDao rd;
	private cartDao cd;
	private ArrayList<Product> listProduct;
	private ArrayList<Product> temp;
	private String index;
	private int current_id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		pd = new productDao();
		ud = new userDao();
		rd = new reviewDao();
		cd = new cartDao();
		this.listProduct = pd.lstProduct();
		temp = (ArrayList<Product>) listProduct.clone();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if(request.getSession().getAttribute("user_email")!=null) {
			request.setAttribute("cart", cd.allInCartOfUser(ud.getUserByEmail(request.getSession().getAttribute("user_email")).getUser_id()).size());
		}
		String action = request.getPathInfo();
		if(action == null) {
			listProduct(request, response);
		}else {
			switch (action) {
			case "/1":
				index = "1";
				toName();
				resetShop(request, response);
				break;
			case "/2":
				index = "2";
				HtoL();
				resetShop(request, response);
				break;
			case "/3":
				index = "3";
				LtoH();
				resetShop(request, response);
				break;
			case "/decoration":
				cate(4);
				resetShop(request, response);
				break;
			case "/accessories":
				cate(3);
				resetShop(request, response);
				break;
			case "/plants":
				cate(1);
				resetShop(request, response);
				break;
			case "/pots":
				cate(2);
				resetShop(request, response);
				break;
			case "/search":
				search(request);
				resetShop(request, response);
				break;
			case "/single":
				showSingleProduct(request,response);
				break;
			case "/review":
				addReview(request,response);
				break;
			default:
				break;
			}
		}
		return;
	}
	
	private void addReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_email = (String) request.getSession().getAttribute("user_email");
		System.out.print(user_email);
		String user_name = ud.getUserByEmail(user_email).getLastName();
		String comment = request.getParameter("comment");
		rd.insert(new Review(current_id, user_name, user_email, comment));
		response.sendRedirect(request.getContextPath()+"/product/single?id="+current_id);
	}

	private void showSingleProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		current_id = id;
		Product p = pd.getProductById(id);
		ArrayList<Product> ps = pd.getProductByCatalog(p.getCatalog_id());
		ArrayList<Review> rs = rd.listReview(id);
		request.setAttribute("comments", rs);
		request.setAttribute("lstProduct", ps);
		request.setAttribute("product", p);
		request.getRequestDispatcher("/View/user/shop-detail.jsp").forward(request, response);;
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
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("index", index);
		request.setAttribute("size", temp.size());
		request.setAttribute("listProduct", temp);
		RequestDispatcher rd = request.getRequestDispatcher("View/user/shop.jsp");
		rd.forward(request, response);
	}
	
	private void resetShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect(request.getContextPath()+"/product");
	}
	
	private void HtoL() {
		for(int j = 0; j < listProduct.size()-1;j++) {
			for(int i = 1; i < listProduct.size();i++) {
				if(temp.get(j).getPrice()<temp.get(i).getPrice()) {
					Collections.swap(temp, j, i);
				}
			}
		}
	}
	
	private void LtoH() {
		for(int j = 0; j < listProduct.size()-1;j++) {
			for(int i = 1; i < listProduct.size();i++) {
				if(temp.get(j).getPrice()>temp.get(i).getPrice()) {
					Collections.swap(temp, j, i);
				}
			}
		}
	}
	
	private void toName() {
		for(int j = 0; j < listProduct.size()-1;j++) {
			for(int i = 1; i < listProduct.size();i++) {
				if(temp.get(j).compareTo(temp.get(i))>0) {
					Collections.swap(temp, j, i);
				}
			}
		}
	}
	
	private void normal(){
		temp = (ArrayList<Product>) listProduct.clone();
	}
	
	private void cate(int i) {
		temp = pd.getProductByCatalog(i);
	}
	
	private void search(HttpServletRequest request) {
		ArrayList<Product> temp2 = new ArrayList<Product>();
		String text = request.getParameter("search-box");
		for(int i = 0; i< listProduct.size();i++) {
			String a = listProduct.get(i).getName().toLowerCase();
			if(a.contains(text.toLowerCase())) {
				temp2.add(listProduct.get(i));
			}
		}
		if(!temp2.isEmpty()) {
			temp = temp2;
		}
	}
}
