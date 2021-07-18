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
		pw.println("<h3 style='color:blue'>Hello Servlet~!!</h3> 한글도 지원됩니다^^");
		pw.println("<br/><br/>");
		pw.println("<a href='./'>인덱스</a>");
		pw.println("</center>");
	}
}
