<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>

<script>
<%	
String seqStr = request.getParameter("seq");
if(seqStr != null) {
	seqStr = seqStr.trim();
	try {
		int seq = Integer.parseInt(seqStr);
		boolean flag = addrDao.del(seq);
        if(flag){
%>
            alert("삭제 성공 with MV");
<%       	
        }else{
%>
            alert("삭제 실패 with MV");
<%         	
        }
	}catch(Exception e) {	
	}	
}	  
%>

location.href='list.jsp';
</script>