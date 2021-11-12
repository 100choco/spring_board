<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Insert 예제</title>
</head>
<body>


	<form action="/register" method="post">
	
		타이틀입력 : <input type="text" name="btitle"><br>
		내용입력 : <input type="text" name="bcontent"><br>
		작성자입력 : <input type="text" name="bwriter"><br>
		
		<input type="submit" value="저장하기">
	
	</form>

<a href="/">돌아가기</a>


</body>
</html>
