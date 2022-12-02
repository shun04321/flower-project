<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문 정보</title>
<style>
  div{
    margin : 50px;
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
<script>
  function copy() {
    if(document.getElementById("same").checked)
    {
      document.getElementById("name1").value = document.getElementById("name2").value;
      document.getElementById("phone1").value = document.getElementById("phone2").value;
    }
  }
</script>
</head>
<body>
  <div class="orderInfo">
  <table \ width="60%">
    <caption>주문자 정보</caption>
    <tr>
      <td>주문자 이름 *</td>
      <td><input type="text" id="name1" size="28" required></td>
    </tr>
    <tr>
      <td>휴대폰 번호 *</td>
      <td>
        <input type="tel" list="phone1" size="4" required>
        <datalist id="phone1" >
          <option>010</option>
          <option>011</option>
          <option>019</option>
          <option>016</option>
          <option>017</option>
          <option>018</option>
        </datalist>
        <label for="phone">-</label>
      <input type="tel" id="phone1" size="4" required>
      <label for="phone">-</label>
      <input type="tel" id="phone1" size="4" required>
      </td>
    </tr>
    <tr>
      <td>이메일 *</td>
      <td>
      <input type="email" id="email" size="7" required>
      <label for="phone">@</label>
      <input type="email" list="email1" size="12" required>
      <datalist id="email1">
        <option>naver.com</option>
        <option>hanmail.net</option>
        <option>nate.com</option>
        <option>gmail.com</option>
        <option>hotmail.com</option>
        <option>nate.com</option>
      </datalist>
      </td>
    </tr>
  </table>
  <br>
</div>
<div class="deliver">
  <label><input type="checkbox" name="same" value="">주문자 정보와 동일</label>
  <table width="60%">
    <caption>배송 정보</caption>
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
    <tr>
      <td>수령 날짜 *</td>
      <td><input type="date" id="recievedate">
        <input type="text" id="recievedate2" size="12" placeholder="직접 입력"></td>
    </tr>
    <tr>
      <td>메모</td>
      <td><textarea cols="37" rows="8"></textarea></td>
    </tr>
  </table>
</div>
</body>
</html>