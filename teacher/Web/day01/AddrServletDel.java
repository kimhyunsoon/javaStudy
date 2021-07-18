package soo.sv.addr;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddrServletDel extends HttpServlet
{
	Connection con;
	PreparedStatement pstmt;
	public void init() throws ServletException{
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		String sql = "delete from ADDRESS where SEQ=?";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			pstmt = con.prepareStatement(sql);
		}catch (ClassNotFoundException cnfe){
			System.out.println("#driver loading failed");
		}catch(SQLException se){}
	}
	public void destroy(){ 
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}

	public void service(HttpServletRequest req, HttpServletResponse res)
           throws ServletException, IOException {
		String seqStr = req.getParameter("seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			try{
				int seq = Integer.parseInt(seqStr);
				pstmt.setInt(1, seq);
				pstmt.executeUpdate();
			}catch(NumberFormatException ne){
			}catch(SQLException se){
			}
		}

		res.sendRedirect("list.do");
	}
	
}