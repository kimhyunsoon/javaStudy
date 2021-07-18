<%@ page contentType="text/html; charset=utf-8" import="javax.sql.DataSource, java.sql.Connection"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<center>
<%
	DataSource ds = dbcp.getDs();
    Connection con = ds.getConnection();
%>
#생성된 con : <%=con.hashCode()%>
</center>