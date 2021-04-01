package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.broadnewDao;

/**
 * Servlet implementation class index
 */
@WebServlet("/home")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private broadnewDao bd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        bd = new broadnewDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showShop(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	public void showShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("blogs", bd.listBroadnew().subList(1, 4));
		RequestDispatcher rd = req.getRequestDispatcher("View/user/index.jsp");
		rd.forward(req, resp);
		return;
	}
	

}
