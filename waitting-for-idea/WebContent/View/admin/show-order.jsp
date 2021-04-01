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
		<!--End Row-->


		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">List Orders</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">Inspection</th>
										<th scope="col">User ID</th>
										<th scope="col">Products</th>
										<th scope="col">Total Payment</th>
										<th scope="col">Status</th>
										<th scope="col">Created Day</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listOrdered}" var="order">
									<c:choose>
										<c:when test="${order.status=='pending'}">
										<tr>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/orderreject?id=${order.ordered_id}">Reject</a>
												</button>
												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/adminitration/orderapprove?id=${order.ordered_id}">Approve</a>
												</button>
											</td>
											<td>${order.user_id}</td>
											<td>${order.carts}</td>
											<td>${order.totalPayment}$</td>
											<td>${order.status}</td>
											<td>${order.created}</td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/orderdelete?id=${order.ordered_id}">Remove</a>
												</button>

											</td>
										</tr>
									
										</c:when>
										<c:otherwise>
											<tr>
											<td></td>
											<td>${order.user_id}</td>
											<td>${order.carts}</td>
											<td>${order.totalPayment}$</td>
											<td>${order.status}</td>
											<td>${order.created}</td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/orderdelete?id=${order.ordered_id}">Remove</a>
												</button>
											</td>
										</tr>
										</c:otherwise>
										</c:choose>
										</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />