<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>person List</title>
</head>
<body>
"personList"이름으로 빼온객체::::${personList}


<table border="1">

	<tr>
		<td>회원번호</td>
		<td>이름</td>
		<td>등록일</td>
		
	</tr>
	
	<c:forEach var="personList" items="${personList}">
		<tr>
			<td>${personList.pno}</td>
			<td><a href="/personContent?pno=${personList.pno}">${personList.pname}</a></td>
			<td>${personList.pregdate}</td>
			
		</tr>
	</c:forEach>

</table>
<a href="/">돌아가기</a>












<%-- <table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
	
	<c:forEach var="boardList" items="${boardList}">
	
		<tr>
			<td>${boardList.bno}</td>
			<td><a href="/boardContent?bno=${boardList.bno}">${boardList.btitle}</a></td>
			<td>${boardList.bwriter}</td>
			<td>${boardList.bregdate}</td>
		</tr>
	
	</c:forEach>

</table>
 --%>
</body>
</html>
