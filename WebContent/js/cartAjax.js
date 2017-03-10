$(document).ready(function() {

    //修改物品的数量
    $(".count-input").on("change", function () {
        var id =$(this).parents("tr").find(".cartPhoneId").text();
        var num = $(this).val();
        $.ajax({
            url: "updatePhoneNum.do",
            type: "post",
            async: true,
            data: {
                "id": id,
                "num": num
            },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            },
            error: function (xhr, textStatus) {
                console.log("ajax fail");
            }
        });
    });

    $(".addNum").on("click", function () {
        var id =$(this).parents("tr").find(".cartPhoneId").text();
        var num = $(this).parents("tr").find(".count-input").val();
        var n=(parseInt(num)+1).toString();
        $.ajax({
            url: "updatePhoneNum.do",
            type: "post",
            async: true,
            data: {
                "id": id,
                "num": n
            },
            timeout: 5000,
            success: function (data, textStatus, jqXHR) {
            },
            error: function (xhr, textStatus) {
                console.log("ajax fail");
            }
        });
    });
    
    //减少商品
    $(".reduceNum").on("click", function () {
        var id =$(this).parents("tr").find(".cartPhoneId").text();
        var num = $(this).parents("tr").find(".count-input").val();
        if(parseInt(num)>1){
        	var n=(parseInt(num)-1).toString();       
	        $.ajax({
	            url: "updatePhoneNum.do",
	            type: "post",
	            async: true,
	            data: {
	                "id": id,
	                "num": n
	            },
	            timeout: 5000,
	            success: function (data, textStatus, jqXHR) {
	            },
	            error: function (xhr, textStatus) {
	                console.log("ajax fail");
	            }
	        });
        }
    });
    
    //删除商品
	$(".delete").on("click", function() {
		var id = $(this).parents("tr").find(".cartPhoneId").text();
		$.ajax({
			url : "deletePhone.do",
			type : "post",
			async : true,
			data : {
				"id" : id
			},
			timeout : 5000,
			success : function(data, textStatus, jqXHR) {
			},
			error : function(xhr, textStatus) {
				console.log("ajax fail");
			}
		});
	});
    
    // 清空购物车
    $("#deleteAll").on("click", function () {
        var conf = confirm('确定清空购物车吗？');
        if (conf) {
            $("#tbody").children().remove();
            $("#selectedViewList").children().remove();
            $("#priceTotal").text("0.00");
            $("#selectedTotal").text("0");
            $.ajax({
                url: "clearCart.do",
                type: "post",
                async: true,
                data: {
                },
                timeout: 5000,
                success: function (data, textStatus, jqXHR) {
                },
                error: function (xhr, textStatus) {
                    console.log("ajax fail");
                }
            });
        }
    });
});