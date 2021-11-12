<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modify</title>
</head>
<body>


	<form action="/personModify" method="post">
		
		<p>번호 : <input type="text" name="pno" value="${dto.pno}" readonly="readonly"><br></p>
		
		<p>이름 : <input type="text" name="pname" value="${dto.pname}"></p>
		<p>전화번호 : <input type="text" name="pphoneNumber" value="${dto.pphoneNumber}"></p>
		<p>주소 : <input type="text" name="paddress" value="${dto.paddress}"></p>
		<p>나이 : <input type="text" name="page" value="${dto.page}"></p>
		<p>성별 :
		
		<c:if test="${dto.pgender == 'f'}">
		남 : <input type="radio" name="pgender" value="m">
		여 : <input type="radio" name="pgender" value="f" checked="checked">
		</c:if>
		<c:if test="${dto.pgender == 'm'}">
		남 : <input type="radio" name="pgender" value="m" checked="checked">
		여 : <input type="radio" name="pgender" value="f">
		</c:if>
		<p>등록일 : <input type="text" name="pregdate" value="${dto.pregdate}" readonly="readonly"></p>
		
		<input type="submit" value="수정하기">
		
	</form>
	<a href="/">돌아가기</a>




<%-- 	<form action="/modify" method="post">
	
		<input type="hidden" name="bno" value="${dto.bno}">
		<input type="hidden" name="bwriter" value="${dto.bwriter}">
		<div>
			번호 : <span>${dto.bno}</span> 
		</div>
		
		<div>
			제목 : <input type="text" name="btitle" value="${dto.btitle}">
		</div>
		
		<div>
			내용 : <input type="text" name="bcontent" value="${dto.bcontent}">
		</div>
		
		<div>
			등록일 : <span>${dto.bcontent}</span> 
		</div>
		
		<input type="submit" value="수정하기">
		
	</form> --%>
</body>
</html>
