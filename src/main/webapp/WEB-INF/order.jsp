<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
    form {
      width: 80%;
      margin: 50px;
      padding: 5px;
    }
  </style>
</head> 
<body>
	<form name="aa" method="post" action="">
    <fieldset>
      <legend>�ֹ��� ����</legend> 
      <label for="name">�ֹ��� �̸�</label>
      <input type="text" id="name">
      <p/>
      <label for="phone">�޴��� ��ȣ</label>
      <input type="tel" list="phone1">
      <datalist id="phone1">
        <option>010</option>
        <option>011</option>
        <option>019</option>
        <option>016</option>
        <option>017</option>
      </datalist>
      <label for="phone">-</label>
      <input type="tel" id="phone">
      <label for="phone">-</label>
      <input type="tel" id="phone">
      <p/>
      <label for="email">�̸���</label>
      <input type="email" id="email">
    </fieldset>
    <p/>
    <input type="submit" value="����">
    <input type="reset" value="�ٽ��ۼ�">
  </form>
</body>
</html>