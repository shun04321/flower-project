<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function updateClass(){
	if(form.name.value == ""){
		alert("이름을 입력하세요.");
		form.name.focus();
		return false;
	}
	form.submit();
}
</script>
<head>

<title>클래스 정보 수정</title>
</head>
<body>
<h2>클래스 수정</h2>
<div>
	<form name="form" method="POST" action="<c:url value='/class/update'/>">
		<input type="hidden" name="classId" value="${classInfo.classId}">
		<input type="hidden" name="sellerId" value="${classInfo.sellerId}">
		<div>
			<label for="name">클래스 이름</label>
			<input type="text" name="name" value="${classInfo.name}">
		</div>
		<div>
			<label for="date">날짜</label>
			<input type="date" name="date" value="${classInfo.date}">
		</div>
		<div>
			<label for="maxNum">최대인원</label>
			<input type="number" name="maxNum" value="${classInfo.maxNum}">
		</div>
		<div>
			<label for="currentNum">현재인원</label>
			<input type="number" name="currentNum" value="${classInfo.currentNum}">
		</div>
		<br>
		<div>
			<input type="button" value="수정" onClick="updateClass()">
			<a href="<c:url value='/class/list' />">클래스 목록</a>
		</div>
	</form>
</div>
</body>
</html>