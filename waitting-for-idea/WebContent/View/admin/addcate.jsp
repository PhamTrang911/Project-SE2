<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Add Topic</div>
						<hr>
						<form action="${pageContext.request.contextPath}/adminitration/addCatalog"
							method="post">
							
								<div class="form-group">
									<label for="input-1">Name</label> <input type="text"
										class="form-control" id="input-1" placeholder="Name"
										name="cate-name"  required>
								</div>
								<div class="form-footer"><a class="btn btn-danger" href="${pageContext.request.contextPath}/adminitration/listCatalog">Cancel</a>
									<button type="submit" class="btn btn-success">
										<i class="fa fa-check-square-o"></i> Add
									</button>
							</form>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />