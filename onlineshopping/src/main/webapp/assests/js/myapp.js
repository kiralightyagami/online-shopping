$(function(){
	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listOfProducts').addClass('active');
		break;
		
	default:
		if(menu=='Home') break;
		$('#listOfProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	}
})


// code for jquery datatable

var products=[
	          ['1','ABC'],
	          ['2','MNO'],
	          ['3','ABe'],
	          ['4','lBC'],
	          ['5','AGC'],
	          ['6','ABH'],
	          ['7','KBC'],
	          ['8','JBC'],
	];

var $table=$('#productListTable');

//execute only if the table is availabe

if($table.length)
	{
	//console.log('in table');
	$table.DataTable({
		
		lengthMenu:[[3,5,10,-1],['3 records','5 records','10 records','all records']],
		pageLength:5,
		data:products
		
	});
	}









