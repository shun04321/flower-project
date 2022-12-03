<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function classDelete() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
<head>

<title>클래스 목록</title>
</head>
<body>
<div>
	<h2>클래스 목록</h2>
</div>
<div>
	<a href="<c:url value='/class/add'></c:url>">추가</a>
</div>
<div class="classList">
	<table>
		<thead>
			<tr>
				<td>클래스 이름</td>
				<td>날짜</td>
				<td>현재인원</td>
				<td>전체인원</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="classInfo" items="${classList}">
				<tr>
					<td>
					  	${classInfo.name}
					</td>
					<td>
						${classInfo.date }
					</td>
					<td>
						${classInfo.currentNum }
					</td>
					<td>
						${classInfo.maxNum }
					<td>
					<a href="<c:url value='/class/update'>
							<c:param name='classId' value='${classInfo.classId}'/>
							</c:url>">
					  	수정</a>
					</td>
					<td>
					<a href="<c:url value='/class/delete'>
							<c:param name='classId' value='${classInfo.classId}'/>
							</c:url>" onclick="return classDelete();">
					  	삭제</a>
					</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>