import java.util.*;

class AA2 //Generic�� ���ؼ� Object�� String���� ����ȯ
{
	ArrayList<String> list = new ArrayList<String>();
	
	void in(){
	list.add("��");
	list.add("����");
	list.add("����");
	list.add("�ܿ�");
	}
	
	void out(){
		int size = list.size();
		for (int i=0; i<size;i++ ){
			//Object obj = list.get(i); Generic�� ���ؼ� ���� ����
			String item = list.get(i);
			System.out.println("item: "+item);

		}
	}


	public static void main(String[] args) 
	{
		AA2 a = new AA2();
		a.in();
		a.out();
	}
}
