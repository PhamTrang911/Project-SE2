<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3"><div class="col-lg-12">
				<button class="add-catalog">
					<a
						href="${pageContext.request.contextPath}/adminitration/addDiscountForm">Add
						Discount</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">List Discount</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										
										<th scope="col">Name</th>
										<th scope="col">Description</th>
										<th scope="col">Min Payment</th>
										<th scope="col">Percentage</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${discount}" var="dis">
										<tr>
											
											<td>${dis.name}</td>
											<td>${dis.description}</td>
											<td>${dis.minPayment}$</td>
											<td>${dis.percentage}%</td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/discountdelete?id=${dis.discount_id}">Remove</a>
												</button>

												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/adminitration/discounteditForm?id=${dis.discount_id}">Edit</a>
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