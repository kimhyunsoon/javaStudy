class AAA extends Object
{
	String name = "ȫ�浿";
	
	AAA(){

		this("�̰���");
		AUser u=new AUser();
		u.use();
	}
	
	AAA(String name){
		super();
		this.name = name;
	}

	void m(){
		System.out.println("A�� �޼ҵ�" );
	}
	
	public static void main(String[] args) 
	{
		new A();
	}
}


class AAAUser
{
	
	AAA a;
	AAAUser(){}
	AAAUser(AAA a){
		this.a = a;
	}
	
	void use(){

		System.out.println("#�� ����" +a.name);
		a.m();
	}
}
