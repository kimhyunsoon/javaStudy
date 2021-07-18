<%@ page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<%!
	Connection con;
	PreparedStatement pstmt;
	public void jspInit() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String sql = "delete from ADDRESS where SEQ=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "servlet", "java");
			pstmt = con.prepareStatement(sql);
		}catch(ClassNotFoundException cnfe) {
		}catch(SQLException se) {}
	}
	public void jspDestroy() {
		try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se) {}
	}
%>

<script>
<%	
	String seqStr = request.getParameter("seq");
	if(seqStr != null) {
		seqStr = seqStr.trim();
		try {
			int seq = Integer.parseInt(seqStr);
			pstmt.setInt(1, seq);
			int i = pstmt.executeUpdate();
			if(i > 0) {
				out.println("alert('삭제 성공')");
			}else {
				out.println("alert('삭제 실패')");
			}
		}catch(Exception e) {}
	}
%>
	location.href='list.jsp';
</script>