$(document).ready(function(){

    //登录
    $("#login").on("click",function(){
        var user=$("#loginUser").val();
        var pwd=$("#loginPwd").val();
        $.ajax({
            url: "login.do",
            type: "post",
            async: true,
            data:{
                   "user":user,
                   "pwd":pwd
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            	if(data.result==true){
                    $("#loginA").hide();
                    $("#registerA").hide();
                    $("#updateA").show();
                    $("#logoutA").show();
                    $("#loginBox").hide();
                    $("#mask").hide();
                    $("#showUser").text("welcome,"+user).show();
            	}else {
                    $("#loginMes").text("用户名或密码不正确").show();
                }
            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
    
    //检查有没有同名
    $("#registerUser").on("blur",function(){
    	var user=$("#registerUser").val();
    	$.ajax({
            url: "existName.do",
            type: "post",
            async: true,
            data:{
                   "user":user,
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            	if(data.result==true){
                    $("#registerMes").text("用户名已存在").show();
            	}else{
            		 $("#registerMes").text("");
            	}
            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
    
    //注册
    $("#register").on("click",function(){
        var user=$("#registerUser").val();
        var pwd=$("#registerPwd").val();
        $.ajax({
            url: "register.do",
            type: "post",
            async: true,
            data:{
                   "user":user,
                   "pwd":pwd
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            	if(data.result==true){
                    $("#registerBox").hide();
                    $("#mask").hide();
                    $("#registerMes").text("").hide();
                    alert("注册成功！");
            	}
            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
    
  //修改密码
    $("#update").on("click",function(){
        var pwd=$("#updatePwd").val();
        var newPwd=$("#updateNewPwd").val();
        $.ajax({
            url: "updatePwd.do",
            type: "post",
            async: true,
            data:{
                   "pwd":pwd,
                   "newPwd":newPwd
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            	if(data.result==true){
                    $("#updateBox").hide();
                    $("#mask").hide();
                    $("#updateMes").text("").hide();
                    alert("修改成功！");
            	}else{
            		$("#updateMes").text("原密码错误").show();
            	}
            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
    
  //注销
    $("#logoutA").on("click",function(){
    	var conf = confirm('确定注销吗？');
        	if (conf) {
		    	$.ajax({
		            url: "logout.do",
		            type: "post",
		            async: true,
		            data:{},
		            timeout: 5000,
		            success: function (data, textStatus, jqXHR) {
		            	if(data.result==true){
		            		$("#loginA").show();
		                    $("#registerA").show();
		                    $("#updateA").hide();
		                    $("#logoutA").hide();
		                    $("#showUser").text("").hide();
		            	}
		            },
		            error: function (xhr, textStatus) {
		                    console.log("ajax fail");
		            }
		        });
        	}
    });
    
    //加入商品到购物车
    $(".ADD").on("click",function(){
    	
    	if($("#showUser").is(":visible")){
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
    
    //查询
    $("#search").on("click",function(){
        var text=$("#searchText").val();
        $.ajax({
            url: "search.do",
            type: "post",
            async: true,
            data:{
                   "text":text
                },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            	if(data.result==true){
            		window.location.href="search.jsp";
            	}
            },
            error: function (xhr, textStatus) {
                    console.log("ajax fail");
            }
        });
    });
});