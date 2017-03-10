<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@ page import="dao.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>手机商城</title>
    <meta http-equiv="X-UA-COMPATIBLE" content="IE-edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <div id="banner" class="clearfix">
        <div id="logo">手机商城</div>
        <ul id="log" class="clearfix">
        <li><input type="text" id="searchText"><span id="search"></span></li>
        <%if(session.getAttribute("SHOPPING_USER")!=null){
        	UserVO vo=(UserVO)session.getAttribute("SHOPPING_USER");
        	%>
        
            <li><span id="showUser">welcome,<%= vo.getUser()%>></span></li>
            <li><a id="updateA" href="javascript:void(0)">修改密码 </a></li>
            <li><a id="logoutA" href="javascript:void(0)">注销</a></li>
            <li><a id="loginA" href="javascript:void(0)" style="display:none;">登录</a></li>
            <li><a id="registerA" href="javascript:void(0)" style="display:none;">注册</a></li>
         <%}else{ %>
         	<li><span id="showUser" style="display:none;">welcome,></span></li>
         	<li><a id="updateA" href="javascript:void(0)" style="display:none;">修改密码 </a></li>
         	<li><a id="logoutA" href="javascript:void(0)" style="display:none;">注销</a></li>
            <li><a id="loginA" href="javascript:void(0)" >登录</a></li>
            <li><a id="registerA" href="javascript:void(0)">注册</a></li>
        <%} %>
            <li><a href="shoppingCart.jsp">查看购物车</a></li>
        </ul>
    </div>
</header>
<!--nav begin-->
<div class="container">
    <div class="st-container">
        <input type="radio" name="radio-set" checked="checked" id="st-control-m">
        <a href="#st-panel-m">小米</a>
        <input type="radio" name="radio-set" id="st-control-h">
        <a href="#st-panel-h">华为</a>
        <input type="radio" name="radio-set" id="st-control-v">
        <a href="#st-panel-v">vivo</a>
        <input type="radio" name="radio-set" id="st-control-o">
        <a href="#st-panel-o">OPPO</a>
        <input type="radio" name="radio-set" id="st-control-z">
        <a href="#st-panel-z">魅族</a>
        
        <%
        PhonesDAO dao=new PhonesDAO();
        List<PhoneVO> list=new ArrayList<PhoneVO>();
        %>
        <!--nav end | content begin-->
        <div class="st-scroll">
            <section class="st-panel" id="st-panel-m">
                <div class="phonelist">
                    <ul>
                    <%
		            list=dao.getPhonesByBrand("xiaomi");
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
                     <%} %>
                    </ul>
                </div>
              
                <div class="logo">
                    <div class="pic">
                        <img src="img/logo/mi.jpg" height="60" width="60"/>
                    </div>
                    <div class="tri">
                    </div>
                </div>
            </section>

            <section class="st-panel" id="st-panel-h">
                <div class="phonelist">
                    <ul>
                    <%
		            list=dao.getPhonesByBrand("huawei");
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
                     <%} %>
                    </ul>
                </div>

                <div class="logo">
                    <div class="pic">
                        <img src="img/logo/huawei.jpg" height="60" width="60"/>
                    </div>
                    <div class="tri">
                    </div>
                </div>

            </section>
            <section class="st-panel" id="st-panel-v">

                <div class="phonelist">
                    <ul>
                        <%
		            list=dao.getPhonesByBrand("vivo");
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
                     <%} %>
                    </ul>
                </div>

                <div class="logo">
                    <div class="pic">
                        <img src="img/logo/vivo.jpg" height="30" width="100"/></div>
                    <div class="tri">
                    </div>
                </div>

            </section>

            <section class="st-panel" id="st-panel-o">

                <div class="phonelist">
                    <ul>
                        <%
		            list=dao.getPhonesByBrand("oppo");
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
                     <%} %>
                    </ul>
                </div>

                <div class="logo">
                    <div class="pic">
                        <img src="img/logo/oppo.jpg" height="21" width="135"/></div>
                    <div class="tri">
                    </div>
                </div>

            </section>

            <section class="st-panel" id="st-panel-z">

                <div class="phonelist">
                    <ul>
                        <%
		            list=dao.getPhonesByBrand("meizu");
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
                     <%} %>
                    </ul>
                </div>

                <div class="logo">
                    <div class="pic">
                        <img src="img/logo/meizu.jpg" height="30" width="120"/></div>
                    <div class="tri">
                    </div>
                </div>

            </section>


        </div>

    </div>
</div>


<footer>
    COPYRIGHT © 1997-2017<br/>
    ALL RIGHTS RESERVED. 京ICP备12345678号
</footer>

<!--遮罩层-->
<div id="mask"></div>

<!--登录-->
<div class="box" id="loginBox">
    <div class="x" id="loginX">x</div>
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" id="loginUser" name="user" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" id="loginPwd" name="pwd" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="loginMes" class="mes"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2"><a href="#" id="login" class="aToBtn">登录</a></td>
        </tr>
    </table>
</div>

<!--注册-->
<div class="box" id="registerBox">
    <table>
        <div class="x" id="registerX">x</div>
        <tr>
            <td>用户名</td>
            <td><input type="text" id="registerUser" name="user" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" id="registerPwd" name="pwd" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="registerMes" class="mes"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2"><a href="#" id="register" class="aToBtn">注册</a></td>
        </tr>
    </table>
</div>

<!--修改密码-->
<div class="box" id="updateBox">
    <div class="x" id="updateX">x</div>
    <table>
        <tr>
            <td>原密码</td>
            <td><input type="password" id="updatePwd" name="pwd" placeholder="请输入原密码"></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" id="updateNewPwd" name="newPwd" placeholder="请输入新密码"></td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="updateMes" class="mes"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2"><a href="javascript:void(0)" id="update" class="aToBtn">修改</a></td>
        </tr>
    </table>
</div>

<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/nav.js"></script>
<script src="js/ajax.js"></script>
</body>
</html>