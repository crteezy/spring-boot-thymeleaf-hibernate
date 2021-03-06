$( document ).ready(function() {
	getAllProcucts();
});

function getAllProcucts(){
	
	$.ajax({
		
		url:"/getAllProducts",
		type:"GET",
		data:null,
		dataType:"json",
		async:true,
		success:function(response){
			products = response.products;
			
			var str = ""
				+'<table border="1">'
				+'<thead>'
				+'<tr>'
				+'<td>Product ID</td>'
				+'<td>Name</td>'
				+'<td>Brand</td>'
				+'<td>Made In</td>'
				+'<td>Price</td>'
				+'</tr>'
				+'</thead>';
			str+=""
				+'<tbody>';
			for(var i=0; i<products.length; i++){
				str+=""
					+'<tr>'
					+'<td>'+products[i].id+'</td>'
					+'<td>'+products[i].name+'</td>'
					+'<td>'+products[i].brand+'</td>'
					+'<td>'+products[i].madeIn+'</td>'
					+'<td>'+products[i].price+'</td>'
					+'</tr>';
					
			}
			str+=""
			+'</tbody>'
			+'</table>';
			$('#productsListDiv').append(str);
			
		},
		error:function(response){
			alert(response.message);
		}
	});
}

function saveWithAjaxPost(){
	
	var name = $("#name").val();
	var brand = $("#brand").val();
	var madeIn = $("#madeIn").val();
	var price = $("#price").val();

	var params = "name="+name+"&brand="+brand+"&madeIn="+madeIn+"&price="+price;
	
//	var params = $("#productForm").serialize();
	
	$.ajax({
		
		url:"/saveWithAjaxPost",
		type:"POST",
		data:params,
		async:true,
		dataType:"json",
		success:function(response){
			$('#productsListDiv').empty();
			getAllProcucts();
		},
		error:function(response){
			alert(response.message);
		}
	});
}