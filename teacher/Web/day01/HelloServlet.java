package soo.sv;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class HelloServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)
           throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<center>");
		pw.println("<h3 style='color:blue'>Hello Servlet~!!</h3> �ѱ۵� �����˴ϴ�^^");
		pw.println("<br/><br/>");
		pw.println("<a href='./'>�ε���</a>");
		pw.println("</center>");
	}
}
