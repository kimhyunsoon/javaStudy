package soo.sv.addr;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddrServletIn extends HttpServlet
{
	Connection con;
	PreparedStatement pstmt;
	public void init() throws ServletException{
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
	public void service(HttpServletRequest req, HttpServletResponse res)
           throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		/*try{
			FileWriter fw = new FileWriter("log.txt");
			PrintWriter pwFile = new PrintWriter(fw, true);
			pwFile.println("the value from client => name: " + name + ", addr: " + addr);
			pwFile.close();
			fw.close();
		}catch(IOException ie){
			System.out.println("ie: " + ie);
		}
		System.out.println("the value from client => name: " + name + ", addr: " + addr);
		*/

		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		try{
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			int i = pstmt.executeUpdate();
			//if(i>0) pw.println("<h3>입력성공</h3>");
			//else pw.println("<h3>입력실패</h3>");
		}catch(SQLException se){
			pw.println("<h3>입력실패</h3>");
		}
		//pw.println("<center><a href='list.do'>리스트</a></center>");
		res.sendRedirect("list.do");
	}
	public void destroy(){ 
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}
}