<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
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
    <label><input type="checkbox" name="same" value="">�ֹ��� ������ ����</label>
    <form name="deliverform" method="post" action="">
      <fieldset>
        <legend>���� ����</legend>
        <br>
        <label for="name">�����ô� �� *</label>
      <input type="text" id="name2" size="24" required>
      <p/>
      <label for="phone">�޴��� ��ȣ *</label>
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
      <label for="date">���� ��¥ *</label>
      <input type="date" id="recievedate">
      <input type="text" id="recievedate2" size="10" placeholder="���� �Է�">
      <p/>
      <label for="memo">�޸�</label>
      <textarea cols="37" rows="8"></textarea>
    </fieldset>
    
    </form>
  </div>
</body>
</html>