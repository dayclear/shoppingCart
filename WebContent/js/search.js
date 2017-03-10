$(document).ready(function(){
    
    //加入商品到购物车
    $(".ADD").on("click",function(){
    	
    	if($("#isUser").attr("data-u")=="yes"){
	    	var id=$(this).parents(".info").find(".phoneId").text();
	    	$.ajax({
	            url: "addInCart.do",
	            type: "post",
	            async: true,
	            data:{
	                   "id":id,
	                },
	            timeout: 5000,
	            success: function (data, textStatus, jqXHR) {
	            	if(data.result==true){
	                    alert("加入成功！");
	            	}
	            },
	            error: function (xhr, textStatus) {
	                    console.log("ajax fail");
	            }
	        });
    	}else{
    		alert("请先登录")
    	}
    });
    
  //搜索
    $("#search").on("click",function(){
        var text=$("#searchText").val();
        $.ajax({
            url: "search.do",
            type: "post",
            async: true,
            data:{
                   "text":text,
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {

            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
});