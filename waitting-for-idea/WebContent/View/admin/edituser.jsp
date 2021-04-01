<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />

<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Edit User</div>
						<hr>
						<form action="${pageContext.request.contextPath}/adminitration/userediting"
							method="post">

							<div class="form-group">
								<label for="input-1">Name</label> <input type="text"
									class="form-control" id="input-2" value="${user.firstName}"
									name="firstName" required>
							</div>
							<div class="form-group">
								<label for="input-1">Name</label> <input type="text"
									class="form-control" id="input-2" value="${user.lastName}"
									name=lastName required>
							</div>
							<div class="form-group">
								<label for="input-2">Email</label> <input type="text"
									class="form-control" id="input-3" readonly="readonly" value="${user.email}" name="user-email">
							</div>
							<div class="form-group">
								<label for="input-3">Phone</label> <input type="text"
									class="form-control" id="input-4" value="${user.phone}" name="user-phone" required>
							</div>
							<div class="form-group">
								<label for="input-3">Date of Birth</label> <input type="text"
									class="form-control" id="input-5" value="${user.dob}" name="user-dob" required>
							</div>
							<div class="form-group">
								<label for="input-4">Password</label> <input type="password"
									class="form-control" id="myinput" value="${user.password}" name="user-password"> <input
									type="checkbox" onclick="myFunction1()">Show password
								<script>
									function myFunction1() {
										var x = document
												.getElementById("myinput");
										if (x.type === "password") {
											x.type = "text";
										} else {
											x.type = "password";
										}
									}
								</script>
							</div>

							<div class="form-group">
									<a class="btn btn-danger" href="${pageContext.request.contextPath}/adminitration/listUser">Cancel</a>
								<button type="submit" class="btn btn-success">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />