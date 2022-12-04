<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>주문 정보</title>
<style>
  div{
    margin : 20px;
    padding: 10px;
  }
  table{
    width: 500px;
    height: 200px;
    border-style: solid;
    border-width: thin;
    padding: 10px;
  }
</style>
 <script type="text/javascript">
  function copy() {
    if(document.getElementById("cb1").checked)
    {
      document.getElementById("name2").value = ${order.productId};
      document.getElementById("deliverphone2").value = ${customer.phone}.value;
      document.getElementById("deliverphone3").value = document.getElementById("phone3").value;
    }
  }
</script>
</head>
<body>
  <div class="radio">
    <form>
      <label><input type="radio" name="recieve" value="direct" onclick="check()" checked>직접 수령</label><br>
      <label><input type="radio" name="recieve  " value="deliver" onclick="check()">배송</label>
    </form>
  </div>
  <div class="orderList">
    <table width="60%">
      <caption>주문 상품</caption>
      <tr>
        <th> </th>
        <th>상품 정보</th>
        <th>수량</th>
        <th>상품 금액</th>
        <th>결제 금액</th>
      </tr>
      <c:forEach var="order" items="${CartList}">
      <tr>
        <td></td>
        <td>${order.productId}</td>
        <td><input type="number" min="1" name="quantity"></td>
        <td>${order.productId}</td>
        <td></td>
      </tr>
      </c:forEach>
    </table>
  </div>
  <div class="orderInfo">
  <table width="60%">
    <caption>주문자 정보</caption>
    <tr>
      <td>주문자 이름 *</td>
      <td>${customer.name}</td>
    </tr>
    <tr>
      <td>휴대폰 번호 *</td>
      <td>${customer.phone}</td>
    </tr>
    <tr>
      <td>이메일 *</td>
      <td>${cutomer.email}</td>
    </tr>
  </table>
  <br>
</div>
<div class="deliver">
  <label><input type="checkbox" id="cb1" onclick="copy();">주문자 정보와 동일</label>
  <table width="60%">
    <caption>배송 정보</caption>
    <tr>
      <td>받으시는 분 *</td>
      <td><input type="text" id="name2" size="28" required></td>
    </tr>
    <tr>
      <td>휴대폰 번호 *</td>
      <td>
        <input type="tel" list="deliverphone" size="4" required>
        <datalist id="deliverphone" >
          <option>010</option>
          <option>011</option>
          <option>019</option>
          <option>016</option>
          <option>017</option>
          <option>018</option>
        </datalist>
        <label for="phone">-</label>
        <input type="tel" id="deliverphone2" size="4" required>
        <label for="phone">-</label>
        <input type="tel" id="deliverphone3" size="4" required>
      </td>
      </tr>
      <tr>
        <td>배송지 주소 *</td>
      <td>
        <input type="text" name="zipcode" maxlength="5" size="14" placeholder="우편번호" required>
        <button type="button">우편번호 찾기</button>
      </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="text" name="address" size="18" placeholder="기본 주소" required>
          <input type="text" name="address" size="16" placeholder="상세 주소" required>    
        </td>
      </tr>
      <tr>
        <td>메모</td>
        <td><textarea cols="42" rows="8"></textarea></td>
      </tr>
  </table>
</div>
<div class="reservation">
  <table width="60%">
    <caption>예약 정보</caption>
    <tr>
      <td>받으시는 분 *</td>
      <td><input type="text" id="name2" size="28" required></td>
    </tr>
    <tr>
      <td>휴대폰 번호 *</td>
      <td>
        <input type="tel" list="phone2" size="4" required>
      <datalist id="phone1" >
        <option>010</option>
        <option>011</option>
        <option>019</option>
        <option>016</option>
        <option>017</option>
        <option>018</option>
      </datalist>
      <label for="phone">-</label> 
      <input type="tel" id="phone2" size="4" required>
      <label for="phone">-</label>
      <input type="tel" id="phone2" size="4" required>
      </td>
    </tr>
    <!-- <tr>
      <td>수령 날짜 *</td>
      <td><input type="date" id="recievedate">
        <input type="text" id="recievedate2" size="12" placeholder="직접 입력"></td>
    </tr> -->
    <tr>
      <td>메모</td>
      <td><textarea cols="37" rows="8"></textarea></td>
    </tr>
  </table>
</div>
<div class="price">
  <p>상품 합계 금액:</p>
  <p>배송비:</p>
  <p>총 결제 금액 :</p>
</div>
<div class="payment">
	<input type="button" value="결제하기">
</div>
</body>
</html>