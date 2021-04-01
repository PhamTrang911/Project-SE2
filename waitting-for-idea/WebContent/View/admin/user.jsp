<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">List User</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">First Name</th>
										<th scope="col">Last Name</th>
										<th scope="col">Email</th>
										<th scope="col">Phone</th>
										<th scope="col">Date of Birth</th>
										<th scope="col">Created Day</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listUser}" var="user">
										<tr>
											
											<td>${user.firstName }</td>
											<td>${user.lastName }</td>
											<td>${user.email }</td>
											<td>${user.phone }</td>
											<td>${user.dob}</td>
											<td>${user.created }</td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/adminitration/userdelete?user-email=${user.email}">Remove</a>
												</button>

												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/adminitration/usereditForm?user-email=${user.email}">Edit</a>
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