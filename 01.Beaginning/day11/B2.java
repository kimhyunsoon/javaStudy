class B2 
{
	int age = 10;
	B2(int age){
		this.age=age;
		//������ ����� ������� �ǹ̰� ����
	}
	void m(){
		System.out.println("B2�� �޼ҵ�");
	}
}

class B2Child extends B2
{

	B2Child(){
		super(20);
	}
	void m(){
		System.out.println("B2���ϵ��� �޼ҵ�");
	}
	void use(){ //�������̵� �Ǳ� ������ �θ� �޼ҵ带 ȣ���� ��
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