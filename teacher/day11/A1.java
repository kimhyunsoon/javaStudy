class A1 
{
	int age;
	A1(int age){
		this.age = age; //(1) �ڽ��� ��ü�� �ǹ�
	}
	public static void main(String[] args) 
	{
		System.out.println("age: " + new A1(27).age);
	}
}
