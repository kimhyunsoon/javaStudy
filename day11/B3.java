class B3 
{
	int age = 10;
	B3(int age){
		this.age=age;
		//지역을 멤버로 꺼내줘야 의미가 생김
	}
	void m(){
		System.out.println("B의 메소드");
	}
}
class B3Child extends B3 //이름이 동일한 부모의 멤버를 자식에서 호출할 때
{
	int age = 100;
	
	B3Child(){
		super(20);
	}

	void m(){ //오버라이딩
		System.out.println("b차일드의 메소드");
	}


	void use(){
		super.m();
	}

	void showAge(){
		System.out.println("bㅇ의 나이"+super.age);
	}
}

class B3User
{
	public static void main(String[] args) 
	{
		B3Child bc = new B3Child();
		bc.showAge();
		bc.m();
		bc.use();
	}
}