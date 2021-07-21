<%@ page contentType="text/html;charset=utf-8" import="mvc.domain.Board"%>

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
<h2>Simple Board with MVC</h2>
&nbsp;&nbsp;&nbsp;
<a href='board.do'>글목록</a>
<hr width='600' size='2' noshade>
<%
    Board board = (Board)request.getAttribute("board");
    if(board != null){
%>
     <form name='f' method='post' action='board.do?m=update'>
		<input type='hidden' name='seq' value='<%=board.getSeq()%>'>
		<input type='hidden' name='writer' value='<%=board.getWriter()%>'>
		<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>
		<td width='30%' align='center'>글쓴이</td>
		<td align='center'><input type='text' name='aa' size='60' value='<%=board.getWriter()%>' readonly></td>
		</tr>
		<tr>
		<td width='30%' align='center'>이메일</td>
		<td align='center'><input type='text' name='email' size='60' value='<%=board.getEmail()%>'></td>
		</tr>
		<tr>
		<td width='30%' align='center'>글제목</td>
		<td align='center'><input type='text' name='subject' size='60' value='<%=board.getSubject()%>'></td>
		</tr>
		<tr>
		<td width='30%' align='center'>글내용</td>
		<td align='center'><textarea name='content' rows='5' cols='53'><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
		<td colspan='2' align='center'>
		<input type='submit' value='수정'>
		</td>
		</tr>
		</table>
	 </form>  
<%
    }
%>

<hr width='600' size='2' noshade>
<b>
<a  href='board.do?m=update_form&seq=<%=board.getSeq()%>'>수정</a>
| 
<a href='board.do?m=del&seq=<%=board.getSeq()%>'>삭제</a>
| 
<a href='board.do'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
