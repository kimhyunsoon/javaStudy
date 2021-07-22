<%@ page language="java" contentType="text/html; charset=UTF-8" import="login.mvc.model.LoginConst"%>
    
  
<script>
	if(${result} == <%=LoginConst.NO_ID%>){
		alert("그런 이메일을 가진 회원이 없어요");
		location.href = "login.do?m=form";
	}else if(${result} == <%=LoginConst.NO_PWD%>){
		alert("비밀번호가 맞지 않아요");
		location.href = "login.do?m=form";
	}else {
		alert("로긴 성공");
		location.href="../index.do";
	}
</script>