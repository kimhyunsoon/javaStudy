< JSP 디폴트 객체 ( 9개 ) > 

(1) 설명 : 객체를 따로 생성하지 않고 스크립트렛 즉, 
	   <%%> 사이에서 사용 가능한 객체를 의미 

(2) 종류 
    <1> out 객체 ( type : JspWriter )
	     -> 클라이언트 브라우져와 연결된 출력 객체 

	<2> request 객체 ( type : HttpServletRequest )
	  -> 클라이언트 요청정보를 가진 객체/공간[객체]

    <3> response 객체 ( type : HttpServletResponse )
	  -> 서버의 답변정보를 가진 객체

    <4> session 객체 ( type : HttpSession )
	  -> 클라이언트측 브라우져에 할당된 서버측 공간[객체]
	   ( JSessionId라는 label 표식 소유 )

	     cf1) 세션 변수 ( 속성 == Attribute) 
		   -> session 객체안에 들어가는 객체(속성값 Object) 의 주소를 참조하는 변수 (type : String) 

	     cf2) 세션 변수값 
		     session.setAttribute("id", "tiger");
			 # "id": 세션변수 
			 # "tiger": 세션변수값 
		   
	<5> application 객체 ( type : ServletContext ) 
	   -> WebApplication 전체에 공유되는 공간[객체]
	     
		 cf) application 변수(속성) / application 변수값(속성값)
		      application.setAttribute("list", list);

	<6> page 객체 ( type : Object )
	   -> JSP 페이지 자신을 의미하는 객체 
	  
	<7> pageContext 객체 ( type : PageContext ) 
	   -> 다른 디폴트객체들을 접근할 수 있는 method 
	   -> 모든 scope에 들어있는 속성(변수)들을 접근할 수 있는 method와 field를 가지고 있음 
		   - setAttribute(String name, Object value, int scope)
		   - getAttribute(String name, int scope)
		   - getAttributeNamesInScope(int scope)
		   - findAttribute(java.lang.String name)
	   -> page scope 영역을 핸들링
 
    <8> config 객체 ( type : ServletConfig )
	  -> DD(web.xml)에서 서블릿의 구성정보를 접근할 수 있는 객체

      정의) web.xml 
	   <servlet>
		  <servlet-name>servletEx</servlet-name>
		  <jsp-file>/jspEx.jsp</jsp-file>
		  <init-param>
			  <param-name>adminId</param-name>
			  <param-value>admin</param-value>
		  </init-param>
	   </servlet>

      사용) jspEx.jsp
	   <%
	        String adminId = config.getInitParameter("adminId");
	   %>

	<9> exception ( type : Throwable )
	  -> 예외 처리 객체 
	   