<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Insert 예제</title>
</head>
<body>


	<form action="/personRegister" method="post">
	
		이름입력 : <input type="text" name="pname"><br>
		전화번호입력 : <input type="number" name="pphoneNumber"><br>
		주소입력 : <input type="text" name="paddress"><br>
		나이입력 : <input type="number" name="page"><br>
		성별입력 : <br> 남 : <input type="radio" name="pgender" value="f">여 : <input type="radio" name="pgender" value="m"><br>
		
		<input type="submit" value="저장하기">
	
	</form>
<a href="/">돌아가기</a>



</body>
</html>
