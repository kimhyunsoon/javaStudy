<%@ page contentType="text/html; charset=utf-8"%>

<script>	
    if(${flag}){
	    alert("삭제 성공 with JSTL+EL");
    }else{
	    alert("삭제 실패 with JSTL+EL");
    }
	location.href='addr.do';
</script>