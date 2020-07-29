<!-- list.jsp -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                                        "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>니뮤 블로그</title>
</head>
<script src="https://unpkg.com/vue/dist/vue.js"></script>

<body>
<div>
    <a href="../view/index.html">vue</a>
</div>

	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<tr>
			<td>${bNo}</td>
			<td>${id}</td>
			<td>${bTitle}</td>
			<td>${bContent}</td>
		</tr>
	</table>
</body>

</html>

