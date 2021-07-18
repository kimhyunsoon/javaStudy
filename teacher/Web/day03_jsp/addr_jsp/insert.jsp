<%@ page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<%!
	Connection con;
	PreparedStatement pstmt;
	public void jspInit(){
	    String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			pstmt = con.prepareStatement(sql);
		}catch (ClassNotFoundException cnfe){
			System.out.println("#driver loading failed");
		}catch(SQLException se){}
	}
	public void jspDestroy(){ 
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}
%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	try{
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		int i = pstmt.executeUpdate();
	}catch(SQLException se){
	}
	response.sendRedirect("list.jsp");
%>