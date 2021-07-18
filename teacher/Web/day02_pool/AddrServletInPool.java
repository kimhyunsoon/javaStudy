package soo.sv.addr.pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soo.db.ConnectionPoolBean;

@WebServlet("/addr_pool/insert.do")
public class AddrServletInPool extends HttpServlet {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		ConnectionPoolBean pool = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?,?, SYSDATE)";
		try {
			pool = getPool();
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,addr);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) pool.returnConnection(con);
			}catch(SQLException se) {}
		}
		
		response.sendRedirect("list.do");
	}
}
