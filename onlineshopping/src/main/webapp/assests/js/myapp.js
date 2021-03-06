$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listOfProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProduct').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;

	default:
		if (menu == 'Home')
			break;
		$('#listOfProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	//to tackle the csrf token
	var token=$('meta[name="_csrf"]').attr('content');
	var header=$('meta[name="_csrf_header"]').attr('content');
	
	if(token.length>0 && header.length>0)
		{
		//set the token header for ajax request
       $(document).ajaxSend(function(e,xhr,options){
    	   xhr.setRequestHeader(header,token);
    	   
       });		
		
		}
	
	

	// code for jquery datatable
	var $table = $('#productListTable');

	// execute only if the table is availabe

	if ($table.length) {
		// console.log('in table');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 records', '5 records', '10 records',
									'all records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out Of Stock!!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';

									if(userRole=='ADMIN'){
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';

									}else{
									
									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}                                    	  
                                      else{
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									}
									return str;
								}
							}

					]

				});
	}

	// dismiss alert after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	

	//-----------------------------------
	//Datatable for admin
	//------------------------------
	var $adminProductsTable = $('#adminProductsTable');

	// execute only if the table is availabe

	if ($adminProductsTable.length) {
		// console.log('in table');

		var jsonUrl = window.contextRoot+'/json/data/all/admin/products';

		$adminProductsTable.DataTable({

					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 records', '30 records', '50 records',
									'all records' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
						    {
						    	data:'id'
						    },
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out Of Stock!!</span>';
									}
									return data;
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							
							{
								data : 'active',
								bSortable:false,
								mRender:function(data,type,row){
									var str='';
									str+='<label class="switch">';
									if(data){
										str+='<input type="checkbox" checked="checked" value="'+row.id+'"/>';
									}
									else
										{
										str+='<input type="checkbox" value="'+row.id+'"/>';
										}
									
									str+='<div class="slider"></div></label>';
									return str;
									
								}
								
							},
							{
								data : 'id',
								bSortable:false,
								mRender:function(data,type,row){
									var str='';
									str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">' ;
									str+='<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;
									
								}
								
							}
							

					],
					//on complete fetching data then we apply bootbox
					initComplete:function(){
						var api=this.api();
						api.$('.switch input[type="checkbox"]').on('change',function() {
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked) ? 'You want to activate the product?'
									: 'you want to deactivate the product?';
							var value = checkbox.prop('value');
							bootbox.confirm({
										size : 'medium',
										title : 'Product Activation and Deactivation',
										message : dMsg,
										callback : function(confirmed) {
											if (confirmed) {
												console.log(value);
												//Ajax query for actiavtion n deactivation
												var activationUrl = window.contextRoot +'/manage/product/' +value+'/activation';
												
												$.post(activationUrl,function(data){
													bootbox.alert({
														size : 'medium',
														title : 'Information',
														message : data
													});
												});
												
											} else {
												checkbox.prop('checked', !checked);
											}
										}

									});
	});
					}

				});
	}
	
	
	
	
	//------------------------------
	
	//validation code for category
	 var $loginForm=$('#loginForm');
	 if($loginForm.length)
		 {
		 
		 $loginForm.validate({
			 
			 rules:{
				 
				 username:{
					 
					 required:true,
					 email:true
				 },
				 
				 password:{
					 required:true
				 }
			 },
			 
			 messages:{
				 username:{
					 required:'Please enter the User Name!',
					 email:'Please enter valid email address!'
				 },
				 description:{
					 required:'Please enter password!'
				 }
			 },
			 errorElement:'em',
			 errorPlacement:function(error,element){
				 //add class for help-block
				 error.addClass('help-block');
				 //place the error after the input elememnt
				 error.insertAfter(element);
			 }
			 
		 });
		 }
//-------------------------------------------------------
	 
		//validation code for login
	 var $categoryForm=$('#');
	 if($categoryForm.length)
		 {
		 
		 $categoryForm.validate({
			 
			 rules:{
				 
				 name:{
					 
					 required:true,
					 minlength:2
				 },
				 
				 description:{
					 required:true
				 }
			 },
			 
			 messages:{
				 name:{
					 required:'Please add category name!',
					 minlength:'The category length should not be less than 2 character'
				 },
				 description:{
					 required:'Please enter a description for this category!'
				 }
			 },
			 errorElement:'em',
			 errorPlacement:function(error,element){
				 //add class for help-block
				 error.addClass('help-block');
				 //place the error after the input elememnt
				 error.insertAfter(element);
			 }
			 
		 });
		 }
	 //----------------------------------------------------
	 //handling the click event of refresh cart button
	 $('button[name="refreshCart"]').click(function(){
		 //fetch cartLine id
		 var cartLineId=$(this).attr('value');
		 var countElement=$('#count_'+cartLineId);
		 var originalCount=countElement.attr('value');
		 var currentCount=countElement.val();
		 //only when count has chnaged
		 if(currentCount!==originalCount)
			 {
			 if(currentCount < 1 || currentCount>3)
				 { //reverting back to original count
				 countElement.val(originalCount);
				 bootbox.alert({
					 size:'medium',
					 title:'Error',
					 message:'Product count should be between 1 and 3'
					 
				 });
				 
				 }
			 else{
				 var updateUrl=window.contextRoot +'/cart/'+cartLineId+'/update?count='+currentCount;
				 //forward it to a controller
				 window.location.href=updateUrl;
			 }
			
			 
			 }
		 
		 
		 
	 });
	 
	 
	 
	 //---------------------------------------------
	
});