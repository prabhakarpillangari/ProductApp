<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">

</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-mid-12">
				<h1 class="text-center mb-3">Add TO Your Cart</h1>
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">TECHONLY${p.id}</th>
								<td>${p.productname}</td>
								<td>${p.description}</td>
								<td class="font-weight-bold" style="font-weight: bold;">&#x20B9;
									${p.price}</td>
								<td><a href="open-login/delete/${p.id }"> <i
										class="fas fa-trash text-danger" style="font-size: 23px"></i></a>
									<a href="open-login/update/${p.id }"> <i
										class="fas fa-pen-nib  text-primary" style="font-size: 23px"></i></a>

								</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>

				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-primary">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>