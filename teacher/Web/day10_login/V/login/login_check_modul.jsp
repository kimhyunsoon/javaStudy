<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<c:if test="${empty loginOkUser}">
    <script>
        alert("회원 서비스입니다. 먼저 로긴을 하고 오세요~");
        location.href="../login/login.do?m=form";
    </script>
</c:if>