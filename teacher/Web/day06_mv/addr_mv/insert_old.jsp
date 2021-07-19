<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>
<jsp:useBean id="dto" class="soo.mv.model.AddrDTO"/>
<jsp:setProperty name="dto" property="name" param="name"/>
<jsp:setProperty name="dto" property="addr" param="addr"/>

<%
	//request.setCharacterEncoding("utf-8");
	//String name = request.getParameter("name");
	//String addr = request.getParameter("addr");
	//addrDao.insert(name, addr);
	
	response.sendRedirect("list.jsp");
%>