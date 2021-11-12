<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modify</title>
</head>
<body>


	<form action="/modify" method="post">
		
		번호 : <input type="text" name="bno" value="${dto.bno}" readonly="readonly"><br>
		
		<p>제목 : <input type="text" name="btitle" value="${dto.btitle}"></p>
		<p>내용 : <input type="text" name="bcontent" value="${dto.bcontent}"></p>
		<p>작성자 : <input type="text" name="bwriter" value="${dto.bwriter}" readonly="readonly"></p>
		<p>등록일 : <input type="text" name="bregdate" value="${dto.bregdate}" readonly="readonly"></p>
		
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
