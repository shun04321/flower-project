<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function searchProduct(){
	if(form.name.value == ""){
		alert("이름을 입력하세요");
		form.name.focus();
		return false;
	}
	form.submit();
}
</script>
<head>

<title>상품 검색</title>
</head>
<body>
<div>
	<h2>상품 검색</h2>
</div>
<form name="form" method="POST" action="<c:url value='/product/search'/>">
	<div>
		<p>상품 이름을 입력하세요</p>
		<input type="text" name="name">
	</div>
	<input type="button" value="검색" onClick="searchProduct()"/>
</form>
</body>
</html>