class A 
{
	String name = "ȫ�浿";
	
	A(){
		AUser u=new AUser(this); 
		u.use();
	}
		
	A(String name){
		this.name = name;
	}

	void m(){
		System.out.println("A�� �޼ҵ�" );
	}
		
	public static void main(String[] args) 
	{
		
		A a = new A("�̼���");
		System.out.println("a�� ����" +a.name);
		new A();
	}
}

class AUser
{
	A a;
	AUser(){}
	AUser( A a){
		this.a = a;
	}

	void use(){
		System.out.println("#name: " + a.name);
		a.m();
	}


}
