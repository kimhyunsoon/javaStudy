class A 
{
	String name = "ȫ�浿";
	A(String name){
	
	this.name = name; //���������� �̸��� ���� ��������� �ش� ������ ������ ��
	
	}

	void m(){
	
		System.out.println("A�� �޼ҵ�" );
	
	}
	
	
	public static void main(String[] args) 
	{
		
		A a = new A("�̼���");
		System.out.println("a�� ����: " +a.name);
	}
}


