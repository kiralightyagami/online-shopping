<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
			<div class="container">
			
	<div class="row">

		<div class=" col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>SignUp-Address</h4>
				</div>

				<div class="panel-body">

					<!-- Form elements -->
					<sf:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="billing">

						<div class="form-group">

							<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>

							<div class="col-md-8">

								<sf:input type="text" path="addressLineOne" placeholder="Enter Address Line One"
									class="form-control" />
								<%-- <sf:errors path="name" cssClass="help-block" element="em" /> --%>
								<!-- <em
								class="help-block">Please enter Product name!</em> -->


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="addressLineTwo">Address Two</label>

							<div class="col-md-8">

								<sf:input type="text" path="addressLineTwo" placeholder="Enter Address Line Two"
									class="form-control" />
								<%-- <sf:errors path="brand" cssClass="help-block" element="em" /> --%>
								<!-- <em
								class="help-block">Please enter Brand Name!</em> -->


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="city"> City</label>

							<div class="col-md-8">
								<sf:input type="text" path="city" placeholder="Enter City Name"
									class="form-control" />
								<%-- <sf:errors path="description" cssClass="help-block" element="em" /> --%>


							</div>

						</div>
						
						<div class="form-group">

							<label class="control-label col-md-4" for="postalCode">Postal Code</label>

							<div class="col-md-8">

								<sf:input type="text" path="postalCode" placeholder="XXXXXX"
									class="form-control" />


							</div>

						</div>
						

						<div class="form-group">

							<label class="control-label col-md-4" for="state">State</label>

							<div class="col-md-8">

								<sf:input type="text" path="state"
									placeholder="Enter State Name"  class="form-control" />
								<%-- <sf:errors path="unitPrice" cssClass="help-block" element="em" /> --%>


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="country">Country</label>

							<div class="col-md-8">

								<sf:input type="text" path="country" placeholder="Enter Country Name"
									class="form-control" />


							</div>

						</div>
						
						
												
						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">
								<!-- Submit button for mobing to personal -->
								<button type="submit" name="_eventId_personal" id="submit" value="Submit"
									class="btn btn-primary" >
									<span class="glyphicon glyphicon-chevron-left"></span>Previous-Personal
									</button>
									<!-- Submit button to move to confirm -->
                             <button type="submit" name="_eventId_confirm" id="submit" value="Submit"
									class="btn btn-primary" >
									Next-Confirm<span class="glyphicon glyphicon-chevron-right"></span>
									</button>
							</div>

						</div>

						

						



					</sf:form>

				</div>








			</div>



		</div>

			
			
			
			</div>
<%@include file="../shared/flows-footer.jsp" %>		