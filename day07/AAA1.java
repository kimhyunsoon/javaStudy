import java.util.*;

class AAA1 
{
	ArrayList list = new ArrayList();

	void in(){
		list.add("��");	list.add("����"); list.add("����"); list.add("�ܿ�");
	}

	void out(){
		int size = list.size(); //����Ʈ�� ����
		for (int i=0; i<size ;i++ ){
			Object obj = list.get(i); //����Ʈ �����͸� �޴� �Լ�
			String item = (String)obj;
			System.out.println("item: "+item);

		}
	}

	public static void main(String[] args) 
	{
		AAA1 a= new AAA1();
		a.in();
		a.out();

	}
}