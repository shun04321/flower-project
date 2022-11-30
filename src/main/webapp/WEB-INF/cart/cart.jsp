<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<link rel=stylesheet href="<c:url value='/css/cart.css' />" type="text/css">
</head>
<body>
<div>
<table class="text">
	<tr>
		<th>CART</th>
	</tr>
</table>
</div>
<br/>
<!-- 장바구니 리스트 -->
<div>
    <table class="table1">
    <tr>
	    <th class="t1"></th>
	    <th class="t1">이미지</th>
	    <th class="t1">상품정보</th>
	    <th class="t1">가격</th>
	    <th class="t1">수량</th>
	    <th class="t1">수령방법</th>
	    <th class="t1">배송비</th>
	    <th class="t1">합계</th>
	    <th class="t1"></th>
	</tr>
	
	<!-- 리스트가 비어있는 경우 -->
	<tr>
		<td colspan="9" class="t0">장바구니가 비어있습니다.</td>
	</tr>
	
	<!-- 리스트가 비어있지 않은 경우 -->
	<tr>
	    <td class="t1">v</td>	<!-- 체크박스 -->
		<td class="t1"></td>
		<td class="t1">원</td>
		<td class="t1">개</td>
		<td class="t1">원</td>
		<td class="t1">원</td>
		<td class="t1">원</td>
		<td class="t1">원</td>
		<td class="t1">x</td>	<!-- 삭제버튼 -->
	</tr>
    </table>
</div>
<br/><br/>
<!-- 총 금액 -->
<div>
	<table class="table2">
		<tr>
			<th id="tColor" class="t2">총 상품 금액</th>
			<th id="tColor" class="t2">총 배송비</th>
			<th id="tColor" class="t2">결제 예정 금액</th>
		</tr>
		<tr>
			<td class="t2">원</td>
			<td class="t2">원</td>
			<td class="t2">원</td>
		</tr>
	</table>
</div>
<br/></br>
<div class="btn">
	<button class="btn1" type="button">선택 상품 주문</button>
	<button class="btn2" type="button">전체 상품 주문</button>
</div>
</body>
</html>