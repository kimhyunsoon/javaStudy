<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>
<jsp:useBean id="dto" class="soo.mv.model.AddrDTO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	addrDao.insert(dto);
	response.sendRedirect("list.jsp");
%>