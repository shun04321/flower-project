<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
	<link rel=stylesheet href="<c:url value='/css/mypage.css' />" type="text/css">
</head>
<body>
<div class="box1">
  <div class="boxLeft">
    <div class="navigation">
      <div class="order">
	      <span class="orderManager">주문 관리</span>
	      <span class="orderDetail">주문 내역 조회</span>
      </div>
      <div class="post">
	      <span class="postManager">게시물 관리</span>
	      <span class="myPost">나의 게시물</span>
      </div>
      <div class="user">
	      <span class="infoManager">개인정보 관리</span>
	      <span class="updateInfo">회원정보 수정</span>
      </div>
    </div>
  </div>
  <div class="box2">
    <div class="boxTop">
      <div class="welcomeFrame">
	        <div class="profileIcon">
	        	<img src="<c:url value='/images/profile.png' />" />
	        </div>
	        <span class="welcome">000님 안녕하세요!</span>
      </div>
    </div>
    <div class="box3">
      <div class="boxBottom">
      <span  class="orderProgress">나의 주문 처리 현황(최근 3개월 기준)</span>
        <div class="progressFrame">
          <div class="progress1">
	          <span class="beforeDeposit">입금전</span>
	          <span class="beforeDepositCnt">0</span>
          </div>
          <div class="progress2">
	          <span class="preparing">배송준비중</span>
	          <span class="preparingCnt">0</span>
          </div>
          <div class="progress3">
	          <span class="delivering">배송중</span>
	          <span class="deliveringCnt">0</span>
          </div>
          <div class="progress4">
	          <span class="completed">배송완료</span>
	          <span class="completedCnt">0</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>