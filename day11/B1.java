class B1 
{
	int age = 10;
	B1(int age){
		this.age=age;
		//������ ����� ������� �ǹ̰� ����
	}
	void m(){
		System.out.println("B1�� �޼ҵ�");
	}
}

class B1Child extends B1
{
	B1Child(){
		super(20);
	}
	void m(){ //�������̵�
		System.out.println("B���ϵ��� �޼ҵ�");
	}
}

class B1User
{
	public static void main(String[] args) 
	{
		B1Child bc = new B1Child();
		System.out.println("b1�� ����"+bc.age);
		bc.m();

	}
}