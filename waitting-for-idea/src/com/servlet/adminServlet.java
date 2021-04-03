package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.Admin;
import com.model.BroadNew;
import com.model.Catalog;
import com.model.Discount;
import com.model.Product;
import com.model.User;

@WebServlet("/adminitration/*")
public class adminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private adminDao ad;
	private productDao pd;
	private catalogDao cd;
	private discountDao dd;
	private broadnewDao bd;
	private userDao ud;
	private reviewDao rd;
	private orderedDao od;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ad = new adminDao();
		pd = new productDao();
		cd = new catalogDao();
		dd = new discountDao();
		bd = new broadnewDao();
		ud = new userDao();
		rd = new reviewDao();
		od = new orderedDao();
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
		
		if(request.getSession().getAttribute("admin-username")==null) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
				
		String action = request.getPathInfo();
		
		if(action == null) {
			index(request, response);
		}else{
			switch (action) {
			case "/homepage":
				index(request, response);/////////////////////////
				break;
			case "/listAdmin":
				showListAdmin(request, response);
				break;
			case "/addAdmin":
				addAdmin(request, response);
				break;
			case "/updateAdmin":
				updateAdmin(request, response);
				break;
			case "/admindelete":
				deleteAdmin(request, response);
				break;
			case "/addAdminForm":
				showAddAdminForm(request, response);
				break;
			case "/editAdminForm":
				showEditAdminForm(request, response);
				break;/////////////////////////////////////////////////////
			case "/addBroadnew":
				addBroadnew(request, response);
				break;
			case "/addBroadnewForm":
				showAddBroadnewForm(request, response);
				break;
			case "/editBroadnewForm":
				showEditBroadnewForm(request, response);
				break;
			case "/listBoardnew":
				showListNews(request, response);
				break;
			case "/updateNew":
				updateNew(request, response);
				break;
			case "/deleteNew":
				deleteNew(request, response);
				break;////////////////////////////////////////////////////
			case "/listProduct":
				showListProduct(request, response);
				break;
			case "/addProductForm":
				showAddProductForm(request, response);
				break;
			case "/addProduct":
				addProduct(request, response);
				break;
			case "/editProductForm":
				showEditProductForm(request, response);
				break;
			case "/editProduct":
				updateProduct(request, response);
				break;
			case "/deleteProduct":
				deleteProduct(request, response);
				break;///////////////////////////////////////////////////////
			case "/addCatalog":
				addCatalog(request, response);
				break;
			case "/addCateForm":
				showAddCatalogForm(request, response);
				break;
			case "/updateCatalog":
				updateCatalog(request, response);
				break;
			case "/editCateForm":
				showEditCatalogForm(request, response);
				break;
			case "/catedelete":
				deleteCatalog(request, response);
				break;
			case "/listCate":
				showListCatalog(request, response);
				break;/////////////////////////////////////////////////////////
			case "/addDiscount":
				addDiscount(request, response);
				break;
			case "/addDiscountForm":
				showAddDisForm(request, response);
				break;
			case "/discounteditForm":
				showEditDisForm(request, response);
				break;
			case "/discountdelete":
				deleteDis(request, response);
				break;
			case "/discountedit":
				updateDis(request, response);
				break;
			case "/listDiscount":
				showListDis(request, response);
				break;////////////////////////////////////////////////////////
			case "/listUser":
				listUser(request, response);
				break;
			case "/userediting":
				userEdit(request, response);
				break;
			case "/userdelete":
				deleteUser(request, response);
				break;
			case "/usereditForm":
				userEditForm(request, response);
				break;
			case "/listReview":
				showListReview(request,response);
				break;
			case "/reviewdelete":
				deleteReview(request,response);
				break;/////////////////////////////
			case "/listOrder":
				listOrdered(request,response);
				break;
			case "/orderdelete":
				deleteOrder(request,response);
				break;
			case "/list-ordereddetail":
				showDetailOrder(request,response);
				break;
			case "/orderreject":
				rejectOrder(request,response);
				break;
			case "/orderapprove":
				approveOrder(request,response);
				break;
			default:
				break;
			}
		}
		return;
	}
	
	private void listOrdered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listOrdered", od.listOrder());
		request.getRequestDispatcher("/View/admin/show-order.jsp").forward(request, response);;
	}

	private void approveOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		od.approveReject(Integer.parseInt(request.getParameter("id")), "approved");
		response.sendRedirect(request.getContextPath()+"/adminitration/listOrder");
	}

	private void rejectOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		od.approveReject(Integer.parseInt(request.getParameter("id")), "rejected");
		response.sendRedirect(request.getContextPath()+"/adminitration/listOrder");
	}

	private void showDetailOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ordered", od.getOneById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/View/adminitration/show-orderdetail.jsp").forward(request, response);;
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		od.delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listOrder");
	}

	private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		rd.delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listReview");
	}

	private void showListReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("reviewlist", rd.listReview());
		request.getRequestDispatcher("/View/admin/show-review.jsp").forward(request, response);	
	}

	private void addDiscount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		dd.add(new Discount(request.getParameter("name"), request.getParameter("des"), Float.parseFloat(request.getParameter("min")), Float.parseFloat(request.getParameter("percent"))));
		response.sendRedirect(request.getContextPath()+"/adminitration/listDiscount");
	}

	private void showEditDisForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Discount d = dd.getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("dis", d);		
		request.getRequestDispatcher("/View/admin/editDiscount.jsp").forward(request, response);;
	}

	private void showAddDisForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/addDiscount.jsp");
		rs.forward(request, response);
	}
	
	private void showListDis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("discount", dd.listDiscount());
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/show-discount.jsp");
		rs.forward(request, response);
	}
	
	private void updateDis(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Discount d = new Discount(request.getParameter("name"), request.getParameter("des"), Float.parseFloat(request.getParameter("min")), Float.parseFloat(request.getParameter("percent")));
		dd.update(Integer.parseInt(request.getParameter("id")),d);
		response.sendRedirect(request.getContextPath()+"/adminitration/listDiscount");
	}
	
	private void deleteDis(HttpServletRequest request, HttpServletResponse response) throws IOException {
		dd.delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listDiscount");
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> lstUser = ud.listUser();
		request.setAttribute("listUser", lstUser);
		request.getRequestDispatcher("/View/admin/user.jsp").forward(request, response);
	}
	
	private void userEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", ud.getUserByEmail(request.getParameter("user-email")));
		request.getRequestDispatcher("/View/admin/edituser.jsp").forward(request, response);
	}
	
	private void userEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ud.updateUser(new User(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("user-email"),request.getParameter("user-phone"),request.getParameter("user-dob"),request.getParameter("user-password")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listUser");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ud.deleteUser(request.getParameter("user-email"));
		response.sendRedirect(request.getContextPath()+"/adminitration/listUser");
	}

	private void addCatalog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		cd.insert(request.getParameter("cate-name"));
		response.sendRedirect(request.getContextPath()+"/adminitration/listBroadnew");
	}

	private void showEditCatalogForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Catalog c = cd.getNameById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("broadnew", c);		
		request.getRequestDispatcher("/View/admin/editcate.jsp").forward(request, response);
	}

	private void showAddCatalogForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/addcate.jsp");
		rs.forward(request, response);
	}
	
	private void showListCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("catelist", cd.listCatalog());
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/show-cate.jsp");
		rs.forward(request, response);
	}
	
	private void updateCatalog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		cd.update(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		response.sendRedirect(request.getContextPath()+"/adminitration/listCatalog");
	}
	
	private void deleteCatalog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		cd.delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listCatalog");
	}

	private void addBroadnew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BroadNew bn = new BroadNew(request.getParameter("new-title"), request.getParameter("new-content"), request.getParameter("new-link"), request.getParameter("new-author"));
		bd.insert(bn);
		response.sendRedirect(request.getContextPath()+"/adminitration/listBoardnew");
	}

	private void showEditBroadnewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BroadNew bn = bd.getOneById(Integer.parseInt(request.getParameter("boardnew-id")));
		request.setAttribute("broadnew", bn);		
		request.getRequestDispatcher("/View/admin/editboardnew.jsp").forward(request, response);
	}

	private void showAddBroadnewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/addboardnew.jsp");
		rs.forward(request, response);
	}
	
	private void showListNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("broadnewList", bd.listBroadnew());
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/show-new.jsp");
		rs.forward(request, response);
	}
	
	private void updateNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BroadNew bn = new BroadNew(request.getParameter("new-title"), request.getParameter("new-content"),request.getParameter("new-link"),request.getParameter("new-author"));
		bd.update(bn);
		response.sendRedirect(request.getContextPath()+"/adminitration/listBoardnew");
	}
	
	private void deleteNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
		bd.delete(Integer.parseInt(request.getParameter("boardnew-id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listBoardnew");
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/index.jsp");
		rs.forward(request, response);
	}
	
	private void showListAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Admin> ads = ad.listAdmin();
		request.setAttribute("adminList", ads.subList(1,ads.size()));
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/admin.jsp");
		rs.forward(request, response);
	}

	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("admin-username");
		String password = request.getParameter("admin-password");
		ad.insert(username, password);
		response.sendRedirect(request.getContextPath()+"/adminitration/listAdmin");
	}
	
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Admin a = new Admin(Integer.parseInt(request.getParameter("id")), request.getParameter("username"), request.getParameter("password"));
		ad.update(a);
		response.sendRedirect(request.getContextPath()+"/adminitration/listAdmin");
	}
	
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ad.delete(request.getParameter("admin-username"));
		response.sendRedirect(request.getContextPath()+"/adminitration/listAdmin");
	}
	
	private void showAddAdminForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/addadmin.jsp");
		rs.forward(request, response);
	}
	
	private void showEditAdminForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Catalog> catalogs = cd.listCatalog();
		request.setAttribute("catalogs", catalogs);
		Admin a = ad.getAdmin(request.getParameter("admin-username"));
		request.setAttribute("admin", a);
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/editadmin.jsp");
		rs.forward(request, response);
	}

	private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productlist", pd.lstProduct());
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/show-product.jsp");
		rs.forward(request, response);
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		pd.insertProduct(new Product(Integer.parseInt(request.getParameter("product-cate")), request.getParameter("product-name"), Float.parseFloat(request.getParameter("product-price")), request.getParameter("product-status"), request.getParameter("product-desc"),Float.parseFloat(request.getParameter("product-dis")), request.getParameter("image_link")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listProduct");
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Product p = new Product(Integer.parseInt(request.getParameter("product-id")),Integer.parseInt(request.getParameter("product-cate")), request.getParameter("product-name"), Float.parseFloat(request.getParameter("product-price")), request.getParameter("product-status"), request.getParameter("product-desc"),Float.parseFloat(request.getParameter("product-dis")), request.getParameter("product-image"), null);
		pd.updateProduct(p);
		response.sendRedirect(request.getContextPath()+"/adminitration/listProduct");
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		pd.deleteProduct(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath()+"/adminitration/listProduct");
	}
	
	private void showAddProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Catalog> catalogs = cd.listCatalog();
		request.setAttribute("catalogs", catalogs);
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/addproduct.jsp");
		rs.forward(request, response);
	}
	
	private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Catalog> catalogs = cd.listCatalog();
		request.setAttribute("catalogs", catalogs);
		Product product = pd.getProductById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("product", product);
		RequestDispatcher rs = request.getRequestDispatcher("/View/admin/editproduct.jsp");
		rs.forward(request, response);
	}

}
