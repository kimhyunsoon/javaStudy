class AA3
{
	String name = "ȫ�浿";
	
	AA3(){

		this("�̰���");
		AA3User aa3u=new AA3User(this);
		// AA3User aa3u = new AA3User(new AA3());

		aa3u.use();

	}
	
	AA3(String a){
		super();
		this.name = a;
	}

	void m(){
		System.out.println("A�� �޼ҵ�" );
	}
	
	public static void main(String[] args) 
	{
		new AA3();
	}

}



class AA3User
{
	
	AA3 aa3;
	
	AA3User(AA3 a){
		this.aa3 = a;
	}
	
	void use(){

		System.out.println("#�� ����" +aa3.name);
		aa3.m();
	}
}
