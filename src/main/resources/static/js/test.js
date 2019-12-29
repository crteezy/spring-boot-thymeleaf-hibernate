//alert();

function getAllProcucts(){
	
	$.ajax({
		
		url:"/getAllProducts",
		type:"GET",
		data:null
		dataType:"json",
		async:true,
		success:function(response){
			
		}
	});
}