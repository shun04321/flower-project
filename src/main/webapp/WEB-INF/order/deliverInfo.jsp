<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>배송 정보</title>
<style>
  div {
      width: 50%;
      height: 80%;
      margin: 80px;
      padding: 10%;
    }
    fieldset {
      padding: 50px;
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
  <div>
    <label><input type="checkbox" name="same" value="">주문자 정보와 동일</label>
    <form name="deliverform" method="post" action="">
      <fieldset>
        <legend>배송 정보</legend>
        <br>
        <label for="name">받으시는 분 *</label>
      <input type="text" id="name2" size="24" required>
      <p/>
      <label for="phone">휴대폰 번호 *</label>
      <input type="tel" list="phone2" size="3" required>
      <datalist id="phone1" >
        <option>010</option>
        <option>011</option>
        <option>019</option>
        <option>016</option>
        <option>017</option>
        <option>018</option>
      </datalist>
      <label for="phone">-</label>
      <input type="tel" id="phone2" size="3" required>
      <label for="phone">-</label>
      <input type="tel" id="phone2" size="3" required>
      <p/>
      <label for="phone">전화 번호 &nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="tel" list="telephone1" size="3">
      <datalist id="telephone1" >
        <option>010</option>
        <option>011</option>
        <option>019</option>
        <option>016</option>
        <option>017</option>
        <option>018</option>
      </datalist>
      <label for="phone">-</label>
      <input type="tel" id="telephone" size="3">
      <label for="phone">-</label>
      <input type="tel" id="telephone" size="3">
      <p/>
      <label for="address">배송지 주소 *</label>
      <input type="text" name="zipcode" maxlength="5" size="10" placeholder="우편번호" required>
      <button type="button">우편번호 찾기</button>
      <p/>
      <input type="text" name="address" size="18" placeholder="기본 주소" required>
      <input type="text" name="address" size="16" placeholder="상세 주소" required>
      <p/>
      <label for="memo">메모</label>
      <textarea cols="37" rows="8"></textarea>
    </fieldset>
    
    </form>
  </div>
</body>
</html>