<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8"/>
		<title>Ajax Test01</title>
		<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript">
		     /*
		     $(document).ready(function(){
		     });*/
		     
		     //HTML DOM Events => https://www.w3schools.com/jsref/dom_obj_event.asp
		     $(function(){
		    	 //$("#searchOk01").on("click", function(){
		    	 $("#seq").on("keyup", function(){	 
		    		 $.ajax({
		    			 url: "../ajax02/search01.do", 
		    			 type: "GET",
		    			 data: {seq:$("#seq").val()}, 
		    			 success: function(data){ 
		    				 //var jsObj = JSON.parse(data); //(json-> jsObj) jQuery 버젼을 올려서 필요 없음 
		    				 //참고: var json = JSON.stringify(data); //(jsObj -> json) 
		    				 
		    				 //data; //현재는 jsObj 
		    				 if(!data){
		    					 alert("존재하지 않는 seq");
		    					 return false;
		    				 }
		    				 var html = "";
		    				 html += "<form id='ajax'>";
		    				 html += "번호 <input name='seq' value='"+data.seq+"'>";
		    				 html += "이름 <input name='name' value='"+data.name+"'>";
		    				 html += "주소 <input name='addr' value='"+data.addr+"'>";
		    				 html += "날짜 <input name='rdate' value='"+data.rdate+"'>";
		    				 html += "</form>";
		    				 $("#name").val("");
		    				 
		    				 $("#container").html(html);
		    			 }
		    		 });
		    	 });
		    	 
		    	 $("#searchOk02").on("click", function(){
		    		 $.ajax({
                         url: "../ajax02/search02.do", 
                         type: "POST", 
                         data: {name: $("#name").val()}, 
                         success: function(data){
                        	 ///alert(data);
                        	 if(!data){
		    					 alert("존재하지 않는 name");
		    					 return false;
		    				 }
                        	 
                        	 var html = "";
                        	 html += "<table border='1' width='50%'>";
                        	 html += "<tr>";
                        	 html += "<th>번호</th>";
                        	 html += "<th>이름</th>";
                        	 html += "<th>주소</th>";
                        	 html += "<th>날짜</th>";
                        	 html += "</tr>";
                        	 
                        	 if(data.length == 0){
                        		 html += "<tr>";
                        		 html += "<td colspan='4' align='center'>그런 이름의 사람 없음</td>";
                        		 html += "</td>";
                        	 }else{
                        		 for (let address of data){
	                        		 html += "<tr>";
	                        		 html += "<td align='center'>"+address.seq+"</td>";
	                        		 html += "<td align='center'>"+address.name+"</td>";
	                        		 html += "<td align='center'>"+address.addr+"</td>";
	                        		 html += "<td align='center'>"+address.rdate+"</td>";
	                        		 html += "</tr>";
                        	     }
                        	 }
                             html += "</table>";
                             $("#seq").val("");
                             
                             $("#container").html(html);
                         }
		    		 });
		    	 });
		     });
		</script>
	</head>
	<body>
	    <center>
	    <h2>(방법2) ObjectMapper</h2>
	    
	    번호: <input type="text" name="seq" id="seq"/>
	    <input type="button" value="번호 검색" id="searchOk01"/>
	    <br/>
	    
	    이름: <input type="text" name="name" id="name"/>
	    <input type="button" value="이름 검색" id="searchOk02"/>
	 
        <br/><br/>
		<div id="container"></div>
		<br/><br/>
		
		<a href="../">인덱스</a><br/><br/>
		</center>
	</body>
</html>