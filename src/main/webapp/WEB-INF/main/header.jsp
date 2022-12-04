<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
</head>
<body style="overflow-x: hidden">
<div class=page>
	<div class=header>
	    <div class=headerFrame>
	      <span class="logo"><a href="#">Flo:be</a></span>
	      <div class=menuFrame>
	        <div class=topMenu>
		        <span class="login"><a href="#">로그인</a></span>
		        <span class="join"><a href="#">회원가입</a></span>
		        <span class="mypage"><a href="#">마이페이지</a></span>
		        <span class="cart"><a href="#">장바구니</a></span>
	        </div>
	        <div class=menu id="menu">
	        <ul>
		        <li class="store"><a href="#">STORE</a></li> 
		        <li class="food"><a href="#">FOOD</a></li>        
		        <li class="flower"><a href="#">FLOWER</a>
		        </li>  
		        <li class="class"><a href="#">CLASS</a></li>
		        <li class="commu"><a href="#">COMMUNITY</a>
		        	<ul>
		        		<li><a href="#">Q&A</a></li>
		        		<li><a href="#">후기</a></li>
		        	</ul>
		        </li>
		        <li class="search">SEARCH</li>
	        </ul>
	        </div>
	      </div>
	    </div>
	</div>
</div>
</body>
</html>