package aa.cc;
import aa.bb.A; //�ٸ� ��Ű�������� ��Ӱ����� �θ��� �ڿ� ���� ����

class AUser extends A
{
	AUser(){
		super(); //�θ��� ������ 
		System.out.println("�̸�: " + name); //��� ���� 
		m(); //�޼ҵ� ����
	}
	public static void main(String[] args) 
	{
		new AUser();
	}
}


