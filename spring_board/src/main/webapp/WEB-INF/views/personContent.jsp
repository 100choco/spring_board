<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>person Content</title>
</head>
<body>

<p>회원번호 : ${dto.pno}</p>
<p>회원이름 : ${dto.pname}</p>
<p>회원전화번호 : ${dto.pphoneNumber}</p>
<p>회원 주소 : ${dto.paddress}</p>
<p>회원나이 : ${dto.page}</p>
<p>회원성별 : ${dto.pgender}</p>
<p>회원등록일 : ${dto.pregdate}</p>

<a href="/personModifyForm?pno=${dto.pno}">수정하기</a>
<a href="/personDelete?pno=${dto.pno}">삭제하기</a>

<a href="/">돌아가기</a>








	<%-- <div>
		번호 : ${dto.bno}
	</div>
	
	<div>
		제목 : ${dto.btitle}
	</div>
	
	<div>
		내용 : ${dto.bcontent}
	</div>
	
	<div>
		등록일 : ${dto.bregdate}
	</div>
	
	<pre><a href="/modifyForm?bno=${dto.bno}">수정하기</a>     <a href="/delete?bno=${dto.bno}">삭제하기</a></pre>
 --%>
</body>
</html>
