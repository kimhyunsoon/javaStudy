class A1 
{
	int age;
	A1(int age){
		this.age = age; //(1) 자신의 객체를 의미
	}
	public static void main(String[] args) 
	{
		System.out.println("age: " + new A1(27).age);
	}
}
