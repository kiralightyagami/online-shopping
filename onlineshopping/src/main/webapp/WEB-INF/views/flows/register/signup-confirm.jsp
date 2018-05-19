<%@include file="../shared/flows-header.jsp" %>
			<div class="row">
			<!--Column to display personal details  -->
			<div class=" col-md-6 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
				<div class="panel-body">
					<!-- Display personal data -->
				</div>
				<div class="panel-footer">
					<!--Anchor tag to edit the personal details  -->
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
				</div>
				
				</div>
				</div>
			
			
			<!--Display billing  -->
			<div class=" col-md-6 ">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Billing Details</h4>
				</div>
				<div class="panel-body">
					<!-- Display billing data -->
				</div>
				<div class="panel-footer">
					<!--Anchor tag to edit the billing details  -->
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				</div>
				
				</div>
				</div>
			
			</div>
			
			
			<!-- Provide confirm button after display  -->
			<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
			<div class="text-center">
			<!-- Anchor to move to success page -->
			<a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Confirm</a>
			
			</div>
			
			</div>
			
			
			</div>
<%@include file="../shared/flows-footer.jsp" %>		