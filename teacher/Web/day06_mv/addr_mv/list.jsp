<%@ page contentType="text/html; charset=utf-8" import="java.util.*, soo.mv.model.AddrDTO"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>

<meta charset='utf-8'>
<style>
table, th, td {
border: 1px solid black;
}
th, td {
padding: 5px;
}
a { text-decoration:none }
</style>
<center>
<h1>
Address List JSP with MV 
</h1>
<a href='../'>index</a>&nbsp;&nbsp;&nbsp;
<a href='input.jsp'>input</a>
<br/><br/>
<table border='1' cellpadding='7' cellspacing='2' width='50%'>
<tr>
<th>번호</th>
<th>이름</th>
<th>주소</th>
<th>날짜</th>
<th>삭제</th>
</tr>
<tr>

<% 
	ArrayList<AddrDTO> list = addrDao.list();
    if(list != null){
		int size = list.size();
		if(size == 0){
%>
          <tr>
				<td align='center' colspan="5">데이터가 하나도 없음</td>
		  </tr>
<%			
		}else{
			for(AddrDTO dto: list){
%>
            <tr>
				<td align='center'><%=dto.getSeq()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddr()%></td>
				<td align='center'><%=dto.getRdate()%></td>
				<td align='center'><a href='del.jsp?seq=<%=dto.getSeq()%>'>삭제</a></td>
			</tr>
<%			
			}
		}
    }
%>

</table>
</center>
