<div class="container">
	<div class="row">


		<!--Display sidebar  -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!--Display the actual products  -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-12">

					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId ='';
						</script>
						<!--Adding breadcrumb  -->
						<ol class="breadcrumb">


							<li><a href=${contextRoot}>Home</a></li>
							<li class="active">All products</li>
						</ol>

					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryId ='${category.id}';
						</script>
						<!--Adding breadcrumb  -->
						<ol class="breadcrumb">


							<li><a href=${contextRoot}>Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>

				</div>



			</div>
			<div class="row">

				<div class="col=xs-12">

					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>

							<tr>
							    <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						</thead>
                       <tfoot>

							<tr>
							    <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						</tfoot>
                       


					</table>


				</div>

			</div>

		</div>








	</div>






</div>
