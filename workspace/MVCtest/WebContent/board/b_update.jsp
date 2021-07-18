<%@ page contentType="text/html; charset=utf-8"%>

<% 
	boolean flag = (Boolean)request.getAttribute("flag");
%>

<script>

console.log(<%=flag%>)



	if(<%=flag%>) {
		alert('삭제 성공 with mvc')
	}else {
		alert('삭제 실패 with mvc')
	}
	location.href='board.do';

</script>
