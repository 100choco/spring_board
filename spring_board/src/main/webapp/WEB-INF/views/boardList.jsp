<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Board List</title>
</head>
<body>

	<table border="1">

		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>삭제</td>
		</tr>

		<c:forEach var="boardList" items="${boardList}">
			<tr>
				<td>${boardList.bno}</td>
				<td><a href="/boardContent?bno=${boardList.bno}">${boardList.btitle}</a></td>
				<td>${boardList.bwriter}</td>
				<td>${boardList.bregdate}</td>
				<td><a href="/delete?bno=${boardList.bno}">삭제하기</a></td>
			</tr>
		</c:forEach>

	</table>




	<div class="pageInfo">

		<c:if test="${pageMaker.prev}">
			<li><a href="${pageMaker.startPage -1}">이전</a></li>
			<!-- 이전버튼이 있는데 이 버튼을 누르면 시작페이지에서 마이너스1을 해줘야 넘어간다. -->
		</c:if>

		<c:forEach var="num" begin="${pageMaker.startPage}"
			end="${pageMaker.endPage}">
			<li><a href="${num}">${num}</a></li>
		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li><a href="${pageMaker.endPage +1}">다음</a></li>
			<!-- 다음버튼이 있는데 이 버튼을 누르면 시작페이지에서 마이너스1을 해줘야 넘어간다. -->
		</c:if>

	</div>



	<form method="get" class="moveForm">
		<!-- 엑션이 있어야지 값이 넘어가잖아 하지만 a태그를 눌렀을 때 액션이라는걸 추가해서 요 버튼을 눌렀을 때  -->
		<input type="text" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="text" name="amount" value="${pageMaker.cri.amount }">

	</form>


	<a href="/">돌아가기</a>

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(function() {

			var moveForm = $(".moveForm");
			
			$(".pageInfo a").on(
					"click",
					function(e) {

						e.preventDefault(); // 기본 이벤트 막기
						moveForm.find("input[name = 'pageNum']").val(
								$(this).attr("href")); //	위에 벨류값을 뭘로 바꿔줄껀데 인풋네임이 '페이지넘'인아이의 벨류값을 넘길꺼다.

						moveForm.attr("action", "/boardList");
						moveForm.submit();

					})

		})
	</script>

</body>
</html>
