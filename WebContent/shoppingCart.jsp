<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-COMPATIBLE" content="IE-edge,chrome=1">
<title></title>
<link rel="stylesheet" href="css/cartStyle.css">
</head>
<body>
<%!Collection<PhoneVO> phonesCol=null; %>
<div class="header">
    <div class="top_content">
        <ul>
            <li><span><%if(session.getAttribute("SHOPPING_USER")!=null){
            UserVO vo=(UserVO)session.getAttribute("SHOPPING_USER");%>
            <%= vo.getUser()%>
            <% }else{ %>
            	请登录
            <%}%></span></li>
            <li><a href="index.jsp">返回首页</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <table id="cartTable">
        <thead>
        <tr>
            <th><label><input type="checkbox" class="check-all check"></label></th>
            <th>商品</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
        	<%if(session.getAttribute("SHOPPING_CART")!=null){ 
        		Map<Integer,PhoneVO> phoneMap=(Map<Integer,PhoneVO>)session.getAttribute("SHOPPING_CART");
        	 	phonesCol=phoneMap.values();
        	 %>
        	<%if(phonesCol!=null){
        	 for(PhoneVO vo:phonesCol) {
        		PhoneVO p=vo;%>
			<tr>
                <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
                <td class="goods"><img src="imgInCart/<%=p.getImg()%>" alt=""/><span><%=p.getName()%></span><span class="cartPhoneId" style="display:none;"><%=String.valueOf(p.getId()) %></span></td>
                <td class="price"><%=p.getPrice()%></td>
                <td class="count">
                    <span class="reduceNum">-</span>
                    <input class="count-input" type="text" value="<%=String.valueOf(p.getNum())%>"/>
                    <span class="addNum">+</span></td>
                <td class="subtotal">11</td>
                <td class="operation"><span class="delete">删除</span></td>
            </tr>        	
        	<%} 
        	 }
        	}%>
        </tbody>
    </table>
</div>
<footer class="footer" id="footer">
    <label class="floatLeft select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
    <a class="floatLeft delete" id="deleteAll" href="javascript:void(0);">清空购物车</a>
    <div class="floatRight closing">结 算</div>
    <div class="floatRight total">合计：￥<span id="priceTotal">0.00</span></div>
    <div class="floatRight selected" id="selected">已选商品
        <span id="selectedTotal">0</span>件
        <span class="arrow up">︽</span>
        <span class="arrow down">︾</span>
    </div>
    <div class="selected-view">
        <div id="selectedViewList" class="clearfix">
        </div>
    </div>
</footer>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/script.js"></script>
<script src="js/cartAjax.js"></script>
</body>
</html>