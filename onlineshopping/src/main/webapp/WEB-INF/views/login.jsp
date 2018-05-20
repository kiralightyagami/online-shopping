<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping -${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<!-- Bootstrap  CSS for datatble -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- --Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
            </div>
            </div>
            </nav>
		<!-- -Page Content -->
		<div class="content">
			<div class="container">
	<div class="row">

		<div class=" col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Login</h4>
				</div>

				<div class="panel-body">

					<!-- Form elements -->
					<form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">

						<div class="form-group">

							<label class="control-label col-md-4" for="username">Email:</label>

							<div class="col-md-8">

								<input type="text" name="username" id="username" class="form-control" />
							</div>
                    </div>

						<div class="form-group">

							<label class="control-label col-md-4" for="password">Password:</label>

							<div class="col-md-8">

								<input type="password" name="password" id="password" class="form-control" />
							</div>
                    </div>

						
						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">

								<input type="submit" value="Login" 
									class="btn btn-primary" />
									

							</div>

						</div>

					</form>
					</div>
					
					<div class="panel-footer">
					<div class="text-right">
					New User -<a hre="${contextRoot}/register">Register Here</a>
					
					</div>
					
					
					</div>
			</div>

		</div>

	</div>
	</div>
	
			<!-- /.container -->
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- Jquery -->
		<script src="${js}/jquery.js"></script>
		<!-- Jquery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!--Bootstrap core javascript  -->
		<script src="${js}/bootstrap.js"></script>



		<!-- My own coded javaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
