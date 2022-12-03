<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script>
function productDelete() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
<head>
<title>상품 목록</title>
</head>

<body>
<div>
	<a href="<c:url value='/product/add'></c:url>">추가</a>
</div>
<div class="productList">
	<table>
		<thead>
			<tr>
				<td>상품명</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>
					<a href="<c:url value='/product/view'>
							<c:param name='productId' value='${product.productId}'/>
							</c:url>">
					  	${product.name}</a>
					</td>
					<td>
						${product.price}
					</td>
					<td>
					<a href="<c:url value='/product/update'>
							<c:param name='productId' value='${product.productId}'/>
							</c:url>">
					  	수정</a>
					</td>
					<td>
					<a href="<c:url value='/product/delete'>
							<c:param name='productId' value='${product.productId}'/>
							</c:url>" onclick="return productDelete();">
					  	삭제</a>
					</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>