class B1 
{
	int age = 10;
	B1(int age){
		this.age=age;
		//지역을 멤버로 꺼내줘야 의미가 생김
	}
	void m(){
		System.out.println("B1의 메소드");
	}
}

class B1Child extends B1
{
	B1Child(){
		super(20);
	}
	void m(){ //오버라이딩
		System.out.println("B차일드의 메소드");
	}
}

class B1User
{
	public static void main(String[] args) 
	{
		B1Child bc = new B1Child();
		System.out.println("b1의 나이"+bc.age);
		bc.m();

	}
}