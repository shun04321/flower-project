<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function addClass(){
	if(form.name.value == ""){
		alert("이름을 입력하세요.");
		form.name.focus();
		return false;
	}
	form.submit();
}
</script>
<head>

<title>클래스 추가</title>
</head>
<body>
<h2>클래스 추가</h2>
<div>
	<form name="form" method="POST" action="<c:url value='/class/add'/>">
		<div>
			<label for="name">클래스 이름</label>
			<input type="text" name="name" placeholder="상품 이름">
		</div>
		<div>
			<label for="date">날짜</label>
			<input type="date" name="date">
		</div>
		<div>
			<label for="maxNum">최대인원</label>
			<input type="number" name="maxNum">
		</div>
		<br>
		<div>
			<input type="button" value="추가" onClick="addClass()">
			<a href="<c:url value='/class/list' />">클래스 목록</a>
		</div>
	</form>
</div>
</body>
</html>