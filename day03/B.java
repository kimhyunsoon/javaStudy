class B
{
	//100�� ������ ���輺��ǥ
	byte ���� = 80;
	byte ���� = 85;
	byte ���� = 75;

	void sum(){
		int �հ� = ���� + ���� + ����;
		System.out.println("�հ�: "+ �հ� );
		}


	void average(){
		byte ��� = (byte)((���� + ���� + ����)/3);
		System.out.println("���: "+ ��� );

	
	}
}

class ����ǥ
{
	public static void main(String[] args){
		B b1 = new B();
		b1.sum();
		b1.average();

	}
}


	
	












/* public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	} */