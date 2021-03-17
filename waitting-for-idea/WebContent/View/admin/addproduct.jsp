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
						<div class="card-title">Add Product</div>
						<hr>
						<form method="post"
							action="${pageContext.request.contextPath}/adminitration/addProduct">

							<div class="form-group">
								<label for="input-1">Name</label> <input type="text"
									class="form-control" id="input-1" placeholder="Name"
									name="product-name" required="required">
							</div>
							<div class="form-group">
								<label for="input-2">Catalog</label>
								<div>
									<select class="form-control valid" id="input-6"
										name="product-cate" aria-invalid="false">
										<c:forEach items="${catalogs}" var="catalog">
											<option value="${catalog.catalog_id}">${catalog.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="input-1">Price</label> <input type="text"
									class="form-control" id="input-1" placeholder="Price" value="0"
									name="product-price" required="required">
							</div>
							<div class="form-group">
								<label for="input-2">Status</label>
								<div>
									<select class="form-control valid" id="input-6"
										name="product-status" required aria-invalid="false">
										<option value="Available">Available</option>
										<option value="Not Available">Not Available</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="input-2" class="col-form-label">Description</label>
								<div>
									<textarea class="form-control" rows="4" id="input-17"
										name="product-desc" required="required"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="input-1">Discount (%)</label> <input type="number"
									class="form-control" id="input-1" placeholder="Discount" value="0"
									name="product-dis" required="required">
							</div>
							<div class="form-group">
								<label for="input-2" class="col-form-label">Image link</label>
								<div>
									<textarea class="form-control" rows="4" id="input-17"
										name="image_link" required="required"></textarea>
								</div>
							</div>

							<div class="form-footer"><a class="btn btn-danger" href="${pageContext.request.contextPath}/adminitration/listProduct">Cancel</a>
								<button type="submit" class="btn btn-success">
									<i class="fa fa-check-square-o"></i>Add
								</button>
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