<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>검색 결과</title>
</head>
<body>
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
				<tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>