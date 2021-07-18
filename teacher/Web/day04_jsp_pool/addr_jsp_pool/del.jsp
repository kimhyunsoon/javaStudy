<%@ page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<jsp:useBean id="pool" class="soo.db.ConnectionPoolBean" scope="application"/>

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
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int i = pstmt.executeUpdate();
			if(i > 0) {
				out.println("alert('삭제 성공')");
			}else {
				out.println("alert('삭제 실패')");
			}
		}catch(Exception e) {
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) pool.returnConnection(con);
			}catch(SQLException se){}
		}
	}
%>
	location.href='list.jsp';
</script>