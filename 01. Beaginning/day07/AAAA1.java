import java.util.*;

class AAAA1 
{
	ArrayList list = new ArrayList();
	
	void in(){
	list.add("��");
	list.add("����");
	list.add("����");
	list.add("�ܿ�");
	}
	
	void out(){
		int size = list.size();
		for (int i=0; i<size;i++ ){
			Object obj = list.get(i);
			String item = (String)obj;
			System.out.println("item: "+item);

		}
	}


	public static void main(String[] args) 
	{
		AAAA1 a = new AAAA1();
		a.in();
		a.out();
	}
}
