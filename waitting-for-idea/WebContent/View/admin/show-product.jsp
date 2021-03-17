<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

if (session.getAttribute("admin-username") == null) {
	response.sendRedirect(request.getContextPath() + "/admin/login");
}
%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/adminitration/addProductForm">Add
						Products</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">List Products</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Name</th>
										<th scope="col">Image Link</th>
										<th scope="col">Catalog</th>
										<th scope="col">Prices</th>
										<th scope="col">Status</th>
										<th scope="col">Description</th>
										<th scope="col">Discount</th>
										<th scope="col">Created Day</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productlist}" var="product">
										<tr>
											<th scope="row">${product.product_id }</th>
											<td>${product.name }</td>
											<td>${product.image_link }</td>
											<td>${product.catalog_id }</td>
											<td>${product.price }</td>
											<td>${product.status }</td>
											<td>${product.discount}%</td>
											<td>${product.description }</td>
											<td>${product.created }</td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/deleteProduct?id=${product.product_id}">Remove</a>
												</button>

												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/adminitration/editProductForm?id=${product.product_id}">Edit</a>
												</button>
											</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>


<jsp:include page="./footer/footer.jsp" flush="true" />