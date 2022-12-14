<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>사용자 관리(UserMan3)</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function login() {
	if (form.customerId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.customerId.focus();
		return false;
	} 
	if (form.pwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.pwd.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>
<body>
<br>
<!-- login form  -->
<form name="form" method="POST" action="<c:url value='/user/login' />">
  <table style="width:100%">
	<tr>
	  <td width="20"></td>
	  <td>
	  	<b>UserMan3</b><br><br>
	   	<table>
	   	  <tr>
		    <td class="title">&nbsp;&nbsp;사용자 관리 - 로그인&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
		
	    <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${loginFailed}">
	  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
	    </c:if>
	    <br>	  
	    <table style="background-color: YellowGreen">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="customerId">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="pwd" style="width:240" name="pwd">
			</td>
		  </tr>
	    </table>
	    <br>	  
	    <table style="width:100%">
		  <tr>
			<td align=left>
			<input type="button" value="로그인" onClick="login()"> &nbsp;
			<input type="button" value="회원가입" onClick="userCreate(
								'<c:url value='/user/register'/>')">
			</td>						
		  </tr>
		  <tr height="40"><td>(관리자 로그인: admin/admin)</td></tr>
	    </table>
	  </td>	  
	</tr>
	<tr height="100"><td>&nbsp;</td>
	</tr>
  </table>  
</form>
</body>
</html>