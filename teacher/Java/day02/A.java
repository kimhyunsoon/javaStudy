class �ؾ {
	String �Ӳ� = "��"; //���, ����, ��ü, ���� 
	int ���� = 200; //���, �⺻, ��ü, ���� 
	�ؾ(){}
	�ؾ(String ��, int ��){
		�Ӳ� = ��;
		���� = ��; 
		//�� : ����(��), �⺻, X, ���� 
	}
}
class ���ָӴ�{ 
	int ����;
	�ؾ ��1, ��2;

	���ָӴ�(int ��){
		���� = ��;
	}
	void ���´�(){
        ��1 = new �ؾ(); //��1:���, ����, ��ü, ����   
		System.out.print(
		"�Ӳ��� "+��1.�Ӳ�+"�̰�, ");
		��2 = new �ؾ("����", 100);
		System.out.println(
		"�Ӳ��� "+��2.�Ӳ�+"�� �ؾ�� ���̾��" );
	}
}
class �� {
	public static void main(String args[]){
        ���ָӴ� ��1 = new ���ָӴ�(45); //��1:����(����), ����, X, ����  
		System.out.print("������ " + ��1.����+"���� ���ָӴϲ��� ");
		��1.���´�();
	}
}