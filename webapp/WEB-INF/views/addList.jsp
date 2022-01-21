<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- 등록폼영역 -->
	<form action="/guestbook4/guest/add" method="get" >
	<table border="2" width="500px">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value=""></td>
			<td>비밀번호</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td colspan="4">
				<textarea cols="65" rows="5" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="submit">작성하기</button>
			</td>
		</tr>

	</table>
	</form>
	<br>
	
	<!-- 리스트영역 -->
	<c:forEach items="${requestScope.gbList }" var="vo">
		<table border="2" width="500px">
		<tr>
			<td>${vo.no }</td>
			<td>${vo.name }</td>
			<td>${vo.regDate }</td>
			<td><a href="/guestbook4/guest/deleteForm?no=${vo.no }">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">
				${vo.content }
			</td>
		</tr>
	</table>
	<br>
	</c:forEach>
	
	
	
	
	
	
	
	
</body>
</html>