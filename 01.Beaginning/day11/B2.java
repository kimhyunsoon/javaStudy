class B2 
{
	int age = 10;
	B2(int age){
		this.age=age;
		//지역을 멤버로 꺼내줘야 의미가 생김
	}
	void m(){
		System.out.println("B2의 메소드");
	}
}

class B2Child extends B2
{

	B2Child(){
		super(20);
	}
	void m(){
		System.out.println("B2차일드의 메소드");
	}
	void use(){ //오버라이딩 되기 이전의 부모 메소드를 호출할 때
		super.m();
	}

}
class B2User
{
	public static void main(String[] args) 
	{
		B2Child bc = new B2Child();

		bc.m();
		bc.use();
	}
}