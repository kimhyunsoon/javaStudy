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
<hr width='600' size='2' color='gray' noshade>
<font color='gray' size='4'>
<h3>Simple Board with MVC(kaeun)</h3>
</font>
<font color="gray" size="3">
<a href='board.do?m=list'>list</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='../'>index</a><br/>
</font>
<hr width='600' size='2' color='gray' noshade>
</center>

<form name='f' method='post' action='board.do?m=update'>
<table border='0' width='500' align='center' cellpadding='3' cellspacing='1' bordercolor='gray'>

<% 

	ArrayList<Board> select = (ArrayList<Board>)request.getAttribute("select");
	if(select !=null){//예외가 발생하지 않을때
		if(select.size()==0){
			System.out.println("에러");
		}else{ //list의 사이즈가 0이 아니면
			for(Board dto:select){

%>

<input type='hidden' name='seq' value='<%=dto.getSeq()%>'>

    <tr>
        <td width='20%' align='center'>WRITER</td>
        <td>
        <input type='text' name='writer' readonly value='<%=dto.getWriter()%>' size='67'/>
        </td>
    </tr>
    <tr>
        <td align='center'>EMAIL</td>
        <td><input type='text' name='email' value='<%=dto.getEmail()%>' size='67'/>
        </td>
    </tr>
    <tr>
        <td align='center'>SUBJECT</td>
        <td><input type='text' name='subject' value='<%=dto.getSubject()%>' size='67'/>
        </td>
    </tr>
    <tr>
        <td align='center'>CONTENT</td>
        <td><textarea id='ta' name='content' rows='15' cols='60'><%=dto.getContent()%></textarea>
        </td>
    </tr>
    <tr>
        <td colspan='2' align='center'>
        <input type='submit' value='modify'>
        </td>
    </tr>
</table>


<%
	
			}
		}
		
	}



%>

<hr width='600' size='2' color='gray' noshade>
</form>
</body>

