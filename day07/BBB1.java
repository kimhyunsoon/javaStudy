import java.util.*;

class BBB1 
{
	TreeSet set = new TreeSet();

	void in(){
		set.add("��");set.add("����");set.add("����");set.add("�ܿ�");
	
	}
	
	void out(){
		Iterator iter = set.iterator(); //�����͸� iterator�� ����
		while(iter.hasNext()){ //Returns true if the iteration has more elements.
			Object obj= iter.next();
			String item = (String)obj;
			System.out.println("item: "+item);
		
		}
	}


	public static void main(String[] args) 
	{
		BBB1 b= new BBB1();
		b.in();
		b.out();
	}
}
