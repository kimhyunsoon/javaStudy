class A 
{
	String name = "홍길동";
	
	A(){
		AUser u=new AUser(this); 
		u.use();
	}
		
	A(String name){
		this.name = name;
	}

	void m(){
		System.out.println("A의 메소드" );
	}
		
	public static void main(String[] args) 
	{
		
		A a = new A("이순신");
		System.out.println("a의 네임" +a.name);
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
