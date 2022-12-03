<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>예약 정보</title>
<style>
    form {
      width: 60%;
      height: 80%;
      margin: 100px;
      padding: 10%;
    }
    fieldset {
      padding: 50px;
    }
  </style>
</head>
<body>
  <div>
    <label><input type="checkbox" name="same" value="">주문자 정보와 동일</label>
    <form name="deliverform" method="post" action="">
      <fieldset>
        <legend>예약 정보</legend>
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
      <label for="date">수령 날짜 *</label>
      <input type="date" id="recievedate">
      <input type="text" id="recievedate2" size="10" placeholder="직접 입력">
      <p/>
      <label for="memo">메모</label>
      <textarea cols="37" rows="8"></textarea>
    </fieldset>
    
    </form>
  </div>
</body>
</html>