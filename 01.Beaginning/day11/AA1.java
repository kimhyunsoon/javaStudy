class AA1 
{
	String name = "홍길동";
	AA1(String a){
	
		this.name = a; //지역변수와 이름이 같은 멤버변수를 해당 지역에 접근할 때
		//여기서 this는 클래스를 뜻한다. 전역변수 홍길동에 매개변수 a를 대입한다고
	
	}

	void plus(int a, int b){
		System.out.println(a+b);
	}

	//name = name 이 둘다 매개변수를 가르켜서 전역변수 name는 변화가없어요

	void m(){
	
		System.out.println("A의 메소드" );
	
	}
	
	
	public static void main(String[] args) 
	{
		
		AA1 aa = new AA1("이순신");
		System.out.println("a의 네임: " +aa.name);
		aa.plus(1,2);
	}
}



