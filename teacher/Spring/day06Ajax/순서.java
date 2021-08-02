< Spring에서 Ajax사용 패턴  >

(1) 삽질 패턴 ( response객체에 JSON문자열 담기 ) : AjaxT01Controller.java
    {"name":"John", "age":30, "car":null}

(2) ObjectMapper 패턴 : AjaxT02Controller.java
	<!-- for ajax -->
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.9.4</version>
	</dependency>
	<dependency>
	    <groupId>com.fasterxml.jackson.dataformat</groupId>
	    <artifactId>jackson-dataformat-xml</artifactId>
	    <version>2.9.6</version>
	</dependency>
	<dependency>
	    <groupId>com.google.code.gson</groupId>
	    <artifactId>gson</artifactId>
	    <version>2.8.2</version>
	</dependency>
	<!-- Append for ObjectMapper -->
	<dependency> 
	<groupId>org.codehaus.jackson</groupId> 
	<artifactId>jackson-core-lgpl</artifactId> 
	<version>1.9.11</version> 
	</dependency>	
	<dependency> 
	<groupId>org.codehaus.jackson</groupId> 
	<artifactId>jackson-mapper-asl</artifactId> 
	<version>1.9.11</version> 
	</dependency> 

(3) @ResponseBody 패턴 : AjaxT03Controller.java
    @GetMapping("search01")
    public @ResponseBody Address search01(long seq, HttpServletResponse response) {
	Address address = service.selectBySeqS(seq);
	return address;
    }

(4) @RestController 패턴 : AjaxT04Controller.java
    @RestController
    public class AjaxT04Controller {}