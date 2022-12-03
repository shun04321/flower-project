<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function addProduct(){
	if(form.name.value == ""){
		alert("상품 이름을 입력하세요.");
		form.name.focus();
		return false;
	}
	if(form.price.value == ""){
		alert("상품 가격을 입력하세요.");
		form.price.focus();
		return false;
	}
	form.submit();
}
</script>
<head>

<title>상품 추가</title>
</head>
<body>
<h2>상품 추가</h2>
<div>
	<form name="form" method="POST" action="<c:url value='/product/add'/>">
		<div>
			<label for="name">상품 이름</label>
			<input type="text" name="name" placeholder="상품 이름">
		</div>
		<div>
			<label for="price">상품 가격</label>
			<input type="text" name="price" placeholder="상품 가격">
		</div>
		<div>
			<label for="description">상품 설명</label>
			<input type="text" name="description" placeholder="상품 설명">
		</div>
		<div>
			<label for="type">종류 선택</label>
			<select name="type">
				<option value="food">음식</option>
				<option value="flower">꽃</option>
			</select>
		</div>
		<div>
			<!-- 이후 select 등으로 변경 -->
			<label for="category">카테고리</label>
			<input type="text" name="category" placeholder="카테고리"> 
		</div>
		<br>
		<div>
			<input type="button" value="추가" onClick="addProduct()">
			<a href="<c:url value='/product/list' />">상품 목록</a>
		</div>
	</form>
</div>
</body>
</html>