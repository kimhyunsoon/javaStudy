class B3 
{
	int age = 10;
	B3(int age){
		this.age=age;
		//������ ����� ������� �ǹ̰� ����
	}
	void m(){
		System.out.println("B�� �޼ҵ�");
	}
}
class B3Child extends B3 //�̸��� ������ �θ��� ����� �ڽĿ��� ȣ���� ��
{
	int age = 100;
	
	B3Child(){
		super(20);
	}

	void m(){ //�������̵�
		System.out.println("b���ϵ��� �޼ҵ�");
	}


	void use(){
		super.m();
	}

	void showAge(){
		System.out.println("b���� ����"+super.age);
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