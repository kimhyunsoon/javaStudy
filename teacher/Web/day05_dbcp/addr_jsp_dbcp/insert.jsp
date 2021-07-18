<%@ page contentType="text/html; charset=utf-8" import="java.sql.*, javax.sql.DataSource"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<%
	//request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	System.out.println("#name: " + name + ", addr: " + addr);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	try{
		DataSource ds = dbcp.getDs();
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		int i = pstmt.executeUpdate();
	}catch(SQLException se){
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}
	response.sendRedirect("list.jsp");
%>