class A2 
{
	int age = 27;
	String name = "ȫ�浿";
	A2(){
		A2Friend f = new A2Friend(this);
		f.use();
	}
	void m(){
		System.out.println("A2�� m()");
	}
	public static void main(String[] args) 
	{
		new A2();
	}
}
class A2Friend 
{
	int age;
	A2Friend(int age){
		this.age = age;
	}
	void use(){
		System.out.println("#age: " + age);
		name;
		//m();
	}
}
