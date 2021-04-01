package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.broadnewDao;
import com.model.BroadNew;

/**
 * Servlet implementation class blogServlet
 */
@WebServlet("/blog/*")
public class blogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private broadnewDao bd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public blogServlet() {
        super();
        bd = new broadnewDao();
        // TODO Auto-generated constructor stub
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
		
		String action = request.getPathInfo();
		if(action == null) {
			response.sendRedirect(request.getContextPath()+"/user");;
		}else { 
			switch (action) {
			case "/view":
				blog(request,response);
				break;
			case "/all":
				blogs(request,response);
				break;
			default:
				break;
			}
		}
	}


	private void blogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BroadNew> bns = bd.listBroadnew();
		request.setAttribute("bns", bns);
		request.getRequestDispatcher("/View/user/news-view.jsp").forward(request, response);;
	}


	private void blog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BroadNew bn = bd.getOneById(id);
		request.setAttribute("blog", bn);
		request.getRequestDispatcher("/View/user/blog.jsp").forward(request, response);;
	}
}
