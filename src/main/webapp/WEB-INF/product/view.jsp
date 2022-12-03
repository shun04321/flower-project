<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>상품 상세 정보</title>
</head>
<body>
<!-- 장바구니 담기 버튼 -->
<div>
	<table>
		<tr>
			<td>상품명</td>
			<td>${product.name}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${product.price }</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${product.description }</td>
		</tr>
	</table>
</div>
<!-- 리뷰 게시판 보이도록 -->
</body>
</html>