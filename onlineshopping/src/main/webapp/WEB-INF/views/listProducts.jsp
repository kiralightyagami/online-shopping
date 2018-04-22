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
						<!--Adding breadcrumb  -->
						<ol class="breadcrumb">


							<li><a href=${contextRoot}>Home</a></li>
							<li class="active">All products</li>
						</ol>

					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
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
            
            <table id="productListTable" class="table table-striped table-bordered">
            <thead>
            
            <tr>
            <th>ID</th>
            <th>Name</th>
            </tr>
            </thead>
            
            
            
            </table> 
            
            
            </div>
            
            </div>

		</div>








	</div>






</div>
