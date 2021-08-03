<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Sp03 Index</title>
	</head>
	<body style="text-align:center">
		<h1>
			Sp03 for Spring Ajax
		</h1>
	    <h3>Ajax</h3>
	    <a href="ajax/test01.do">Ajax01</a>&nbsp;&nbsp;
	    <a href="ajax/test02.do">Ajax02</a>&nbsp;&nbsp;
	    <a href="ajax/test03.do">Ajax03</a>&nbsp;&nbsp;
	    <a href="ajax/test04.do">Ajax04</a>&nbsp;&nbsp;
	    
	    <h3>RestFul 테스트</h3>
	    <a href="rest/getText">getText</a>&nbsp;&nbsp;
	    <!-- <a href="rest/getAddress">getAddress</a>&nbsp;&nbsp;  -->
	    <a href="rest/getAddress.xml">getAddress</a>(xml)&nbsp;&nbsp; 
	    <a href="rest/getAddress.json">getAddress</a>(json))&nbsp;&nbsp; 
	    <a href="rest/getList.xml">getList</a>(xml)&nbsp;&nbsp; 
	    <a href="rest/getList.json">getList</a>(json)&nbsp;&nbsp; 
	    <a href="rest/getMap.xml">getMap</a>(xml)&nbsp;&nbsp; 
	    <a href="rest/getMap.json">getMap</a>(json)
	    <br/>
	    <a href="rest/check.xml?height=140&weight=70">check</a>(xml)&nbsp;&nbsp; 
	    <a href="rest/check.json?height=140&weight=70">check</a>(json)&nbsp;&nbsp; 
	    <a href="rest/product/bag/001.xml">product/bag/001.xml</a>(xml)&nbsp;&nbsp; 
	    <a href="rest/product/bag/002.json">product/bag/002.json</a>(json)&nbsp;&nbsp; 
	    <br/>
	    
	    <h3>RestFul(Address) 구축</h3>
	    <a href="rest_addr/write.do">rest_addr/write.do</a><br/><br/>
	    
	    <h3>Ajax 응용</h3>
	    <!-- 
	    <a href="file/form_dd.do">Drag&Drop</a>&nbsp;&nbsp; 
	     -->
	    <a href="file/list.do">파일리스트</a>&nbsp;&nbsp; 
	    <a href="chart/chart.do">Google Chart</a>&nbsp;&nbsp; 
	    <a href="auto/auto.do">자동완성</a>&nbsp;&nbsp; 
	    
	    
	</body>
</html>




