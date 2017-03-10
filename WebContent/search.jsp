<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@ page import="dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索结果</title>
<link rel="stylesheet" href="css/search.css">
</head>
<body>
<div class="header">
    <div class="top_content">
        <ul>
        	<li><%if(session.getAttribute("SHOPPING_USER")!=null){
            UserVO vo=(UserVO)session.getAttribute("SHOPPING_USER");%>
            <span style='display:none' id="isUser" data-u="yes">
            <% }else{ %>
            <span style='display:none' id="isUser" data-u="no">
            <%}%></span></li>
            <li><a href="shoppingCart.jsp">查看购物车</a></li>
            <li><a href="index.jsp">返回首页</a></li>
        </ul>
    </div>
</div>
<div class="phonelist">
    <ul>
      <%
		List<PhoneVO> list=new ArrayList<PhoneVO>();
        if(session.getAttribute("list")!=null){
		list=(List<PhoneVO>)session.getAttribute("list");
		
		for(int i=0;i<list.size();i++){
		 PhoneVO vo=list.get(i);
	 %>
        <li>
	        <img src="img/phones/<%=vo.getImg()%>">
	        <div class="info">
	          <p><span class="phoneId"><%=String.valueOf(vo.getId())%></span><span><%=vo.getName()%></span></p>
	          <p><span class="price">￥<%=String.valueOf(vo.getPrice())%></span><a href="#" class="ADD">加入购物车</a></p>
	        </div>
        </li>
       <%} }else{%>
	        查询不到您要的信息
        <%}%>
      </ul>
     </div>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/search.js"></script>
</body>
</html>