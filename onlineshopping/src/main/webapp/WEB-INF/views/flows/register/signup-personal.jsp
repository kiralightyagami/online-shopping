<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">

		<div class=" col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>SignUp-Personal</h4>
				</div>

				<div class="panel-body">

					<!-- Form elements -->
					<sf:form method="POST" class="form-horizontal" id="registerForm"
						modelAttribute="user">

						<div class="form-group">

							<label class="control-label col-md-4"> First Name</label>

							<div class="col-md-8">

								<sf:input type="text" path="firstName" placeholder="First Name"
									class="form-control" />
								<%-- <sf:errors path="name" cssClass="help-block" element="em" /> --%>
								<!-- <em
								class="help-block">Please enter Product name!</em> -->


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4"> Last Name</label>

							<div class="col-md-8">

								<sf:input type="text" path="lastName" placeholder="Last Name"
									class="form-control" />
								<%-- <sf:errors path="brand" cssClass="help-block" element="em" /> --%>
								<!-- <em
								class="help-block">Please enter Brand Name!</em> -->


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4"> Email</label>

							<div class="col-md-8">
								<sf:input type="text" path="email" placeholder="abc@xys.com"
									class="form-control" />
								<%-- <sf:errors path="description" cssClass="help-block" element="em" /> --%>


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4">Contact Number</label>

							<div class="col-md-8">

								<sf:input type="text" path="contactNumber"
									placeholder="XXXXXXXXX" maxlength="10" class="form-control" />
								<%-- <sf:errors path="unitPrice" cssClass="help-block" element="em" /> --%>


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4">Password</label>

							<div class="col-md-8">

								<sf:input type="password" path="password" placeholder="Password"
									class="form-control" />


							</div>

						</div>

						<!-- radio button using bootstrap class of radio-inline -->
						<div class="form-group">

							<label class="control-label col-md-4">Select Role</label>

							<div class="col-md-8">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" />User
								</label>
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="SUPPLIER" />Supplier
								</label>
							</div>
							
							

						</div>
						
						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">

								<button type="submit" name="_eventId_billing" id="submit" value="Submit"
									class="btn btn-primary" >
									Next-Billing<span class="glyphicon glyphicon-chevron-right"></span>
									</button>

							</div>

						</div>

						

						



					</sf:form>

				</div>








			</div>



		</div>


	</div>
	<%@include file="../shared/flows-footer.jsp"%>