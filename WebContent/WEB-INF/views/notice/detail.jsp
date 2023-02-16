<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 조회</title>
</head>
<body>
	<h1>공지사항 상세 정보</h1>
	작성자 : ${notice.noticeWriter } / 작성일자 : ${notice.noticeDate } / 조회수 : ${notice.viewCount }
	<h3>제목 : ${notice.noticeSubject }</h3>
	<p>내용 : ${notice.noticeContent }</p>
	<a href="/notice/list.do">목록으로</a>
	<a href="/notice/modify.do?notice-no=${notice.noticeNo }">수정하기</a>
<!--	<a href="javascript:void(0);" onclick="deleteCheck();">삭제하기</a>  -->
	<form action="/notice/remove.do" method="post">
		<input type="hidden" name="notice-no" value="${notice.noticeNo }">
		<input type="submit" value="삭제하기" onclick="return deleteCheck();">
	</form>
	<script>
		function deleteCheck() {
			if(!confirm("ㄹㅇ찐?")) {		
				return false;
			}
		}
/* 		function deleteCheck() {
			if(confirm("ㄹㅇ찐?")) {		
				return true;
			} 				
			return false;
			} */
/* 		function deleteCheck() {
			// 기본 이벤트 제거, 페이지 이동X
			event.preventDefault();
			if(confirm("ㄹㅇ찐?")) {		
				location.href = "/notice/remove.do?notice-no"
			} else {				
			}
		} */
	</script>
</body>
</html>