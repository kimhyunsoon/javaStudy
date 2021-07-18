package soo.sv.addr;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddrServletList extends HttpServlet
{
	Connection con;
	Statement stmt;
	public void init() throws ServletException{ //�޸𸮿� �ö󰥶� ȣ��(ù��°��û�� ����) 
		//System.out.println("init() called");

        String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			stmt = con.createStatement();
		}catch (ClassNotFoundException cnfe){
			System.out.println("#driver loading failed");
		}catch(SQLException se){}
	}
	public void service(HttpServletRequest req,HttpServletResponse res)
           throws ServletException, IOException { //��û�Ҷ����� ȣ�� 
		//System.out.println("service() called");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<meta charset='utf-8'>");
		pw.println("<style>");
			pw.println("table, th, td {");
			   pw.println("border: 1px solid black;");
			pw.println("}");
			pw.println("th, td {");
			   pw.println("padding: 5px;");
			pw.println("}");
			pw.println("a { text-decoration:none }");
		pw.println("</style>");
		pw.println("<center>");
			pw.println("<h1>");
				pw.println("Address List");
			pw.println("</h1>");
			pw.println("<a href='../'>index</a>&nbsp;&nbsp;&nbsp;");
			pw.println("<a href='input.html'>input</a>");
			pw.println("<br/><br/>");
			pw.println("<table border='1' cellpadding='7' cellspacing='2' width='50%'>");
				pw.println("<tr>");
					pw.println("<th>��ȣ</th>");
					pw.println("<th>�̸�</th>");
					pw.println("<th>�ּ�</th>");
					pw.println("<th>��¥</th>");
					pw.println("<th>����</th>");
				pw.println("</tr>");

                ResultSet rs = null;
                String sql = "select * from ADDRESS order by SEQ desc";
				try{
					rs = stmt.executeQuery(sql);
					while(rs.next()){
						int seq = rs.getInt(1);
                        String name = rs.getString(2);
						String addr = rs.getString(3);
						Date rdate = rs.getDate(4);
						pw.println("<tr>");
							pw.println("<td align='center'>"+seq+"</td>");
							pw.println("<td>"+name+"</td>");
							pw.println("<td>"+addr+"</td>");
							pw.println("<td align='center'>"+rdate+"</td>");
							pw.println("<td align='center'><a href='del.do?seq="+seq+"'>����</a></td>");
						pw.println("</tr>");
					}
				}catch(SQLException se){
				}finally{
					try{
						if(rs != null) rs.close();
					}catch(SQLException se){}
				}
			pw.println("</table>");
		pw.println("</center>");		

	}
	public void destroy(){ //�޸𸮿��� �������� ȣ��(reload�Ҷ�, ��������å, ������ŷ)
		//System.out.println("destroy() called");
		try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}
}

//soo.sv.addr.AddrServletList