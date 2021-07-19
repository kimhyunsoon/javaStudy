<%@ page contentType="text/html; charset=utf-8"%>


<%
    boolean flag = (Boolean)request.getAttribute("flag");
%>
<script>	
    if(<%=flag%>){
	    alert("삭제 성공 with MVC");
    }else{
	    alert("삭제 실패 with MVC");
    }
	location.href='addr.do';
</script>