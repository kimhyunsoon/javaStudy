<%@ page contentType="text/html; charset=utf-8" import = "java.util.*,domain.Board"%>


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
<h3>
	Simple Board with MVC(kaeun)
</h3>
</font>
<a href='board.do?m=input'>write</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='../'>index</a>
<hr width='600' size='2' color='gray' noshade>
<TABLE border='2' width='600' align='center' noshade>
	<TR size='2' align='center' noshade bgcolor='AliceBlue'>
		<th bgcolor='AliceBlue'>NO</th>
		<th color='gray'>WRITER</th>
		<th color='gray'>E-MAIL</th>
		<th color='gray'>SUBJECT</th>
		<th color='gray'>DATE</th>
	</tr>
	
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	if(list !=null){//예외가 발생하지 않을때
		if(list.size()==0){
			
		}else{ //list의 사이즈가 0이 아니면
			for(Board dto:list){
%>
				<tr>
					<td align='center'><%=dto.getSeq()%></td>
					<td><%=dto.getWriter()%></td>
					<td><%=dto.getEmail()%></td>
					<td align='center'>
					<a href='board.do?m=select&seq=<%=dto.getSeq()%>'><%=dto.getSubject()%>
					</a></td>
					<td align='center'><%=dto.getRdate()%></td>
				</tr>

<% 				
			}
		}
		
	}

%>

</table>
</center>
