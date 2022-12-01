<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문자 정보</title>
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
	<form name="form" method="post" action="">
    <fieldset>
      <legend>주문자 정보</legend> 
      <br>
      <label for="name">주문자 이름 *</label>
      <input type="text" id="name1" size="25" required>
      <p/>
      <label for="phone">휴대폰 번호 *</label>
      <input type="tel" list="phone1" size="3" required>
      <datalist id="phone1" >
        <option>010</option>
        <option>011</option>
        <option>019</option>
        <option>016</option>
        <option>017</option>
        <option>018</option>
      </datalist>
      <label for="phone">-</label>
      <input type="tel" id="phone1" size="3" required>
      <label for="phone">-</label>
      <input type="tel" id="phone1" size="3" required>
      <p/>
      <label for="email">이메일 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="email" id="email" size="12" required>
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
    </fieldset>
    <p/>
    <input type="submit" value="다음" >
    <input type="reset" value="다시작성">
  </form>
  </div>
</body>
</html>