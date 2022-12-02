<!-- 유효성검사, 전화번호주소 합치기 -->
<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Customer customer = (Customer)request.getAttribute("customer");
%>
<html>
<head>
<title>회원 정보 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<style>
	a.main {
		font-family: 'Nunito Sans', 'Noto Sans KR', sans-serif;
	    cursor: pointer;
	    display: inline-block;
	    box-sizing: border-box;
	    padding: 0 11px;
	    font-size: 13px;
	    font-weight: 300;
	    text-decoration: none;
	    vertical-align: middle;
	    letter-spacing: -0.3px;
	    color: #4e4c4a;
	    text-align: center;
	    white-space: nowrap;
	    transition: 0.2s ease-in-out;
	    background-color: transparent;
	    border: 1px solid #eeeeee;
	    height: 40px;
	    line-height: 40px;
	    word-break: keep-all;
	    word-wrap: break-word;
	    margin-left: 0px;
	    width: 100px;
	}
</style>
<script>
function userModify() {
	if (form.pwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.pwd.focus();
		return false;
	}
	if (form.pwd.value != form.pwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	//var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	//if(phoneExp.test(form.phone.value)==false) {
	//	alert("전화번호 형식이 올바르지 않습니다.");
	//	form.phone.focus();
	//	return false;
	//}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}

	form.submit();
}

function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                            
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
            	extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
            	extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
            	extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                     
            document.getElementById("sample4_engAddress").value = data.addressEnglish;
                                   
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
            	document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
            	document.getElementById("sample4_extraAddress").value = '';
            }
            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
            	var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';
            } else if(data.autoJibunAddress) {
            	var expJibunAddr = data.autoJibunAddress;
            	guideTextBox.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp(예상 지번 주소 : ' + expJibunAddr + ')';
            	guideTextBox.style.display = 'block';
            } else {
            	guideTextBox.innerHTML = '';
            	guideTextBox.style.display = 'none';
            }
		}
	}).open();
}
</script>
</head>
<body>
<div align="center">
<form name="form" method="POST" action="<c:url value='/user/update' />">
<br><br><br><br><br><br><br>
  <input type="hidden" name="customerId" value="${customer.customerId}"/>	  
		<table width="800" cellpadding="0" cellspacing="0">
			<tr>
				<td width="800" height="50">
				<h2>회원 정보 수정</h2>
				</td>
			</tr>
		</table>
	    <br>	  
	    <table class="list" border="1" align="center">
	  	  <tr>
			<td align="center" width="150" height="50" bgcolor="#eeeeee">아이디 <font color="blue">*</font></td>
			<td style="border-left: 1px solid #eeeeee;">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input name="customerId" type="text" size="15" maxlength="16" value="${customer.customerId}" readonly>
					&nbsp&nbsp
					<input class="button" type="button" value="중복 체크" onClick="idCheck()">
					&nbsp
					<font size="2">(영문 소문자/숫자, 4~16자)</font>
			</td>
		  </tr>
		  <tr>
			<td align="center" width="150" height="50" bgcolor="#eeeeee">비밀번호 <font color="blue">*</font></td>
			<td style="border-left: 1px solid #eeeeee;">
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input name="pwd" type="password" size="15" maxlength="16" value="${customer.pwd}">
					&nbsp
					<font size="2">(영문 대소문자/숫자/특수문자, 8~16자)</font>
			</td>
		  </tr>
		  <tr>
			<td align="center" width="150" height="50" bgcolor="#eeeeee">비밀번호 확인 <font color="blue">*</font></td>
			<td style="border-left: 1px solid #eeeeee;">
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input name="pwd2" type="password" size="15" maxlength="16" value="${customer.pwd}">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="150" height="50" bgcolor="#eeeeee">이름 <font color="blue">*</font></td>
			<td style="border-left: 1px solid #eeeeee;">
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input name="name" type="text" size="15" value="${customer.name}">
			</td>
		  </tr>
		  <tr>
		  <td align="center" width="150" height="50" bgcolor="#eeeeee">
					전화번호 <font color="blue">*</font>
				</td>
				<td style="border-left: 1px solid #eeeeee;">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<select name="phone1" class="small" style="height:40px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select>
					-
				<input name="phone2" class="small" type="text" size="4" maxlength="4"> 
				<!--<c:if test="${registerFailed}">value="${customer.phone}"</c:if>-->
				-
				<input name="phone3" class="small" type="text" size="4" maxlength="4">
				</td>
		  </tr>	
		  <tr>
		  		<td align="center" width="150" height="50" bgcolor="#eeeeee">
	  	  			이메일 <font color="blue">*</font>
	  	  		</td>
				<td style="border-left: 1px solid #eeeeee;">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input name="email" type="text" size="30" value="${customer.email}">
				</td>
		  </tr>	
		  <tr>
		  		<td align="center" width="150" height="100" bgcolor="#eeeeee">
					주소 <font color="blue">*</font>
				</td>
				<td style="border-left: 1px solid #eeeeee;">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="text" id="sample4_postcode" name="addr1" placeholder=" 우편번호">
					&nbsp&nbsp
					<input class="button" type="button"  onclick="sample4_execDaumPostcode()" value="주소 검색">
					<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input class="big" type="text" id="sample4_roadAddress" name="addr2" placeholder=" 기본주소" size="50">
					<br>
					<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" size="50">
					<span id="guide" style="color:#999; display:none"></span>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input class="big" type="text" id="sample4_detailAddress" name="addr3" placeholder=" 나머지 주소"  size="50">
					<input type="hidden" id="sample4_extraAddress" placeholder="참고항목" size="50">
					<input type="hidden" id="sample4_engAddress" placeholder="영문주소" size="50" >
					<!-- <c:if test="${registerFailed}">value="${customer.address}"</c:if>> -->
				</td>
			</tr>	
	    </table>
	    <br>
	    <table width="60%" cellpadding="0" cellspacing="0">
			<tr>
				<td height="30" align="left">
					<h3>
					<a href="<c:url value='/user/delete'>
					<c:param name='customerId' value='<%=customer.getCustomerId()%>'/>
					</c:url>" class="main" onclick="return userRemove();">탈퇴</a>
					</h3>
				</td>
			</tr>
		</table>
		<c:if test="${registerFailed}">
	    	<font color="red"><c:out value="${exception.getMessage()}"/></font>
	    </c:if>
		<h3 align="center">
			<input type="button" class="joinus" value="회원정보수정" onClick="userModify()">
		</h3>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</div>
</body>
</html>