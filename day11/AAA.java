class AAA extends Object
{
	String name = "홍길동";
	
	AAA(){

		this("이건희");
		AUser u=new AUser();
		u.use();
	}
	
	AAA(String name){
		super();
		this.name = name;
	}

	void m(){
		System.out.println("A의 메소드" );
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

		System.out.println("#의 네임" +a.name);
		a.m();
	}
}
