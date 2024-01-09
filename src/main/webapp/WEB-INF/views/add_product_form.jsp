<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-md-3">Fill the product details</h1>

				<form action="handle-product" method="post">

					<div class="form-group">
						<label for="name"></label>Product Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emaiLHeLp"
							name="productname" placeholder="Enter the product name here">
					</div>
					<div class="form-group">

						<label for="descrption">Product Description </label>
						<textarea class="form-control" name="description" rows="5"
							placeholder="Enter the product description"></textarea>
					</div>
					<div class="form-group">

						<label for="price">Product price </label> <input type="text"
							placeholder="Enter the Prduct Price" name="price"
							class="form-control" id="price">
					</div>

					<div class="container text-center">

						<a href=" ${pageContext.request.contextPath }/open-login"
							class="btn btn-outline-danger"> Back</a>
						<button type="submit" class="btn btn-primary">Add</button>

					</div>

				</form>
			</div>

		</div>
	</div>
</body>
</html>