package soo.sv.addr.pool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soo.db.ConnectionPoolBean;

@WebServlet("/addr_pool/del.do")
public class AddrServletDelPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ConnectionPoolBean getPool() throws SQLException {
    	ServletContext application = this.getServletContext();
    	ConnectionPoolBean pool = (ConnectionPoolBean)application.getAttribute("pool");
    	if(pool == null) {
    		try {
    			pool = new ConnectionPoolBean();
    			application.setAttribute("pool", pool);
    		}catch(ClassNotFoundException cnfe) {
    		}
    	}
    	return pool;
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<script>");
		
		String seqStr = request.getParameter("seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			
			ConnectionPoolBean pool = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "delete from ADDRESS where SEQ=?";
			try {
				int seq = Integer.parseInt(seqStr);
				
				pool = getPool();
				con = pool.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, seq);
				int i = pstmt.executeUpdate();
				if(i > 0) {
					pw.println("alert('삭제 성공')");
				}else {
					pw.println("alert('삭제 실패')");
				}
			}catch(Exception e) {
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) pool.returnConnection(con);
				}catch(SQLException se) {}
			}
		}
		//response.sendRedirect("list.do");
		pw.println("location.href='list.do'");
		pw.println("</script>");
	}
}
