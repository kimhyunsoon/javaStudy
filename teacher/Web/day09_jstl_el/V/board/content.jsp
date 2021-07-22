<%@ page contentType="text/html;charset=utf-8" import="mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset='utf-8'>
<style>
table, th, td {
border: 1px solid black;
border-collapse: collapse;
}
th, td {
padding: 5px;
}
a { text-decoration:none }
</style>
<center>
<hr width='600' size='2' noshade>
<h2>Simple Board with JSTL+EL</h2>
&nbsp;&nbsp;&nbsp;
<a href='board.do?m=write'>글쓰기</a>
<hr width='600' size='2' noshade>

<c:if test="${!empty board}">
	<table border='1' width='600' align='center' cellpadding='3'>
		<tr>
		<td width='100' align='center'>글번호</td>
		<td>${board.seq}</td>
		</tr>
		<tr>
		<td align='center'>글쓴이</td>
		<td>${board.writer}</td>
		</tr>
		<tr>
		<td align='center'>이메일</td>
		<td>${board.email}</td>
		</tr>
		<tr>
		<td align='center'>글제목</td>
		<td>${board.subject}</td>
		</tr>
		<tr>
		<td align='center'>글내용</td>
		<td>${board.content}</td>
		</tr>
	 </table>
</c:if>

<hr width='600' size='2' noshade>
<b>
<a  href='board.do?m=update_form&seq=${board.seq}'>수정</a>
| 
<a href='board.do?m=del&seq=${board.seq}'>삭제</a>
| 
<a href='board.do'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
