class A 
{
	String name = "홍길동";
	A(String name){
	
	this.name = name; //지역변수와 이름이 같은 멤버변수를 해당 지역에 접근할 때
	
	}

	void m(){
	
		System.out.println("A의 메소드" );
	
	}
	
	
	public static void main(String[] args) 
	{
		
		A a = new A("이순신");
		System.out.println("a의 네임: " +a.name);
	}
}


