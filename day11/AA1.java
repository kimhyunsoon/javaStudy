class AA1 
{
	String name = "ȫ�浿";
	AA1(String a){
	
		this.name = a; //���������� �̸��� ���� ��������� �ش� ������ ������ ��
		//���⼭ this�� Ŭ������ ���Ѵ�. �������� ȫ�浿�� �Ű����� a�� �����Ѵٰ�
	
	}

	void plus(int a, int b){
		System.out.println(a+b);
	}

	//name = name �� �Ѵ� �Ű������� �����Ѽ� �������� name�� ��ȭ�������

	void m(){
	
		System.out.println("A�� �޼ҵ�" );
	
	}
	
	
	public static void main(String[] args) 
	{
		
		AA1 aa = new AA1("�̼���");
		System.out.println("a�� ����: " +aa.name);
		aa.plus(1,2);
	}
}



