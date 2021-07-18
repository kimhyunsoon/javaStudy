<%@ page contentType="text/html; charset=utf-8" import="java.sql.*, javax.sql.DataSource"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<script>
<%	
    Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "delete from ADDRESS where SEQ=?";
	
	String seqStr = request.getParameter("seq");
	if(seqStr != null) {
		seqStr = seqStr.trim();
		try {
			int seq = Integer.parseInt(seqStr);
			
			DataSource ds = dbcp.getDs();
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int i = pstmt.executeUpdate();
			if(i > 0) {
				out.println("alert('삭제 성공 with dbcp')");
			}else {
				out.println("alert('삭제 실패 with dbcp')");
			}
		}catch(Exception e) {
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
%>
	location.href='list.jsp';
</script>