< JSP ����Ʈ ��ü ( 9�� ) > 

(1) ���� : ��ü�� ���� �������� �ʰ� ��ũ��Ʈ�� ��, 
	   <%%> ���̿��� ��� ������ ��ü�� �ǹ� 

(2) ���� 
    <1> out ��ü ( type : JspWriter )
	     -> Ŭ���̾�Ʈ �������� ����� ��� ��ü 

	<2> request ��ü ( type : HttpServletRequest )
	  -> Ŭ���̾�Ʈ ��û������ ���� ��ü/����[��ü]

    <3> response ��ü ( type : HttpServletResponse )
	  -> ������ �亯������ ���� ��ü

    <4> session ��ü ( type : HttpSession )
	  -> Ŭ���̾�Ʈ�� �������� �Ҵ�� ������ ����[��ü]
	   ( JSessionId��� label ǥ�� ���� )

	     cf1) ���� ���� ( �Ӽ� == Attribute) 
		   -> session ��ü�ȿ� ���� ��ü(�Ӽ��� Object) �� �ּҸ� �����ϴ� ���� (type : String) 

	     cf2) ���� ������ 
		     session.setAttribute("id", "tiger");
			 # "id": ���Ǻ��� 
			 # "tiger": ���Ǻ����� 
		   
	<5> application ��ü ( type : ServletContext ) 
	   -> WebApplication ��ü�� �����Ǵ� ����[��ü]
	     
		 cf) application ����(�Ӽ�) / application ������(�Ӽ���)
		      application.setAttribute("list", list);

	<6> page ��ü ( type : Object )
	   -> JSP ������ �ڽ��� �ǹ��ϴ� ��ü 
	  
	<7> pageContext ��ü ( type : PageContext ) 
	   -> �ٸ� ����Ʈ��ü���� ������ �� �ִ� method 
	   -> ��� scope�� ����ִ� �Ӽ�(����)���� ������ �� �ִ� method�� field�� ������ ���� 
		   - setAttribute(String name, Object value, int scope)
		   - getAttribute(String name, int scope)
		   - getAttributeNamesInScope(int scope)
		   - findAttribute(java.lang.String name)
	   -> page scope ������ �ڵ鸵
 
    <8> config ��ü ( type : ServletConfig )
	  -> DD(web.xml)���� ������ ���������� ������ �� �ִ� ��ü

	<9> exception ( type : Throwable )
	  -> ���� ó�� ��ü 
	   