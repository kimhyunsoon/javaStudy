class �ؾ{
	String �Ӳ� = "��";
	int ���� = 200; //�Ӽ�
	�ؾ(){	//������, ��ü�� ����� ����
		}
	�ؾ(String ��, int ��){
		�Ӳ� = ��;
		���� = ��;
	
	}

	
	void �����ϰ��Ѵ�(){//mathod
		System.out.println("�����ϰ��Ѵ�");
	}
	void ��θ����Ѵ�(){
		System.out.println("��θ����Ѵ�");
	}
}

/* �ؾ�� �Ӽ��� �Ӳ��� ������ ����
�ؾ�� ������ �����ϰ� �Ѵ�, ��θ��� �Ѵ�*/

class ���ָӴ�{//
	int ���� = 60;
	�ؾ ��1, ��2; //��1�� ��2�� �ؾ�̶�� Ÿ���� ���� �ִ�
	���ָӴ�(){
		���� = 55;
		}
	���ָӴ�(int ��){
		���� = ��; //Ŭ���� �Ʒ����� ����Ȱ� �������
		} 
		//Ŭ���� �ſ��� ���ָӴ� Ŭ������ ȣ���Ҷ� �Ķ���Ͱ��� �����ϸ�, int ���� �� ���̰� ��

	void ���´�(){
		��1 = new �ؾ(); //��1�̶�� ��ü�� �ؾ�̶�� �����ڸ� ȣ���ؼ� �������
		
		System.out.print("�Ӳ���"+��1.�Ӳ�+"�� �ؾ��");
		��2 = new �ؾ("����",100);
		System.out.println("�Ӳ���"+��2.�Ӳ�+"�� �ؾ�� ����̾��");
	}
	void �Ǹ��Ѵ�(�ؾ ��){
		System.out.println("������" +��.����+"�� �ؾ�� �Ǹ��Ѵ�");
	}

}

class ��
{
	public static void main(String args[]){
	 ���ָӴ� ��1 = new ���ָӴ�(45);
	 System.out.print("������" + ��1.���� + "���� ���ָӴϲ���");
	 ��1.���´�();
	 ��1.�Ǹ��Ѵ�(��1.��2);
	}
}

class �ؾ������
{
	public static void main(String args[]){
		�ؾ ��1 = new �ؾ();
		System.out.print("�ؾ�� ����");
		��1.�����ϰ��Ѵ�();
	}

}

