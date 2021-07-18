<%@ page contentType="text/html; charset=utf-8" import = "java.util.*, domain.Board"%>



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
<font color='gray' size='4'>
<hr width='600' size='2' color='gray' noshade>
<h3>Simple Board with MVC(kaeun)</h3>
</font>

<a href='board.do?m=input'>write</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='board.do?m=list'>list</a>
<hr width='600' size='2' color='gray' noshade>
<table border='2' width='600' align='center' noshade>

<%

	ArrayList<Board> select = (ArrayList<Board>)request.getAttribute("select");
	if(select !=null){//예외가 발생하지 않을때
		if(select.size()==0){
			System.out.println("에러");
		}else{ //list의 사이즈가 0이 아니면
			for(Board dto:select){
%>

    <tr>
        <td width='20%' align='center'>No</td>
        <td><%=dto.getSeq()%></td>
    </tr>
    <tr>
        <td width='20%' align='center'>Writer</td>
        <td><%=dto.getWriter()%></td>
    </tr>
    <tr>
        <td width='20%' align='center'>E-mail</td>
        <td><%=dto.getEmail()%></td>
    </tr>
    <tr>
        <td width='20%' align='center'>Subject</td>
        <td><%=dto.getSubject()%></td>
    </tr>
    <tr>
        <td width='20%' align='center'>Contents</td>
        <td><%=dto.getContent()%></td>
    </tr>
    
    </table>

	<hr width='600' size='2' color='gray' noshade>
	<a href='board.do?m=modify&seq=<%=dto.getSeq()%>'>modify</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='board.do?m=del&seq=<%=dto.getSeq()%>'>delete</a>

<%
	
			}
		}
		
	}


%>

<hr width='600' size='2' color='gray' noshade>
</center>

