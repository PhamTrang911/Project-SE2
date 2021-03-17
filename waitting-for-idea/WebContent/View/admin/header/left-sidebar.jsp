<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/View/admin/assets" var="url" />

<div id="sidebar-wrapper" data-simplebar=""
	data-simplebar-auto-hide="true">
	<div class="brand-logo">
		<a href="${pageContext.request.contextPath}/adminitration/homepage"> 
		<img
			src="${url}/images/bookstore_book_store_shop.png" class="logo-icon" alt="logo icon">
			<h5 class="logo-text">Online Shop</h5>
		</a>
	</div>
	<ul class="sidebar-menu do-nicescrol">
		<li class="sidebar-header">MENU</li>
		<li><a href="${pageContext.request.contextPath}/adminitration/homepage">
				<i class="zmdi zmdi-view-dashboard"></i> <span>Overall</span>
		</a></li>

		<li><a href="${pageContext.request.contextPath}/adminitration/listAdmin">
				<i class="zmdi zmdi-account-box"></i> <span>Manage Admin</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/adminitration/listUser">
				<i class="zmdi zmdi-accounts"></i> <span>Manage User</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/adminitration/listCate">
				<i class="zmdi zmdi-grid"></i> <span>Topic</span>
		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/adminitration/listProduct"> <i
				class="zmdi zmdi-widgets"></i> <span>List Products</span>
		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/adminitration/listDiscount"> <i
				class="zmdi zmdi-widgets"></i> <span>List Discount</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/adminitration/listOrder">
				<i class="zmdi zmdi-shopping-cart"></i> <span>Orders</span>
		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/adminitration/listBoardnew"> <i
				class="icon-envelope-open"></i> <span>News</span>
		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/adminitration/listReview"> <i
				class="zmdi zmdi-comment"></i> <span>Review</span>
		</a></li>
	</ul>
</div>