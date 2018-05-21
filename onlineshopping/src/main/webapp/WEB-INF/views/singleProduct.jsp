<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="container">
	<!--  Breadcrumb-->
	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">
		<!--  Display product image-->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>
		<!--  Display product description-->
		<div class="col-xs-12 col-sm-8"></div>
		<h3>${product.name}</h3>
		<hr />

		<p>${product.description}</p>
		<hr />
		<h4>
			Price:<strong>&#8377;${product.unitPrice}/-</strong>
		</h4>

		

<!-- Display out of stock if product is not there -->
		<c:choose>
			<c:when test="${product.quantity<1}">
				<h6>
					Qty. Available:<span style="color:red">Out Of Stock!!</span>
				</h6>
			</c:when>
			<c:otherwise>
			
			<h6>Qty. Available:${product.quantity}</h6>
			</c:otherwise>
		</c:choose>
		<!-- dsiable the cart if product is not there -->
		<security:authorize access="hasAuthority('USER')">
		<c:choose>
			<c:when test="${product.quantity<1}">
				<a href="javascript:void(0)"
			class="btn btn-success disabled"><strike><span
			class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a></strike>
			</c:when>
			<c:otherwise>
			
			<a href="${contextRoot}/cart/add/${product.id}/product"
			class="btn btn-success"><span
			class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
			</c:otherwise>
		</c:choose>
		</security:authorize>
		<security:authorize access="hasAuthority('ADMIN')">
		
		<a href="${contextRoot}/manage/${product.id}/product"
			class="btn btn-warning"><span
			class="glyphicon glyphicon-pencil"></span>Edit</a>
		</security:authorize>

		
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

	</div>



</div>