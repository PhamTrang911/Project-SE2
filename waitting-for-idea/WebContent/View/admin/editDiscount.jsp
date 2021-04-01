<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Edit Discount</div>
						<hr>

						<form action="${pageContext.request.contextPath}/adminitration/discountedit"
							method="post">
							<input hidden name="id" value="${dis.discount_id}">
							<div class="form-group">
								<label for="input-1">Name </label> <input type="text"
									class="form-control" id="input-1" name="name"
									value="${dis.name}" required>
							</div>
							<div class="form-group">
								<label for="input-1">Description </label> <input type="text"
									class="form-control" id="input-1" name="des"
									value="${dis.description}" required>
							</div>
							<div class="form-group">
								<label for="input-1">Min Payment </label> <input type="number"
									class="form-control" id="input-1" name="min"
									value="${dis.minPayment}" required>
							</div>
							<div class="form-group">
								<label for="input-1">Percentage </label> <input type="number"
									class="form-control" id="input-1" name="percent"
									value="${dis.percentage}" required>
							</div>
							<div class="form-footer">
									<a class="btn btn-danger" href="${pageContext.request.contextPath}/adminitration/listDiscount">Cancel</a>

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