import java.util.*;

class BB2 //Generic
{
	TreeSet<String> set = new TreeSet<String>();
	void in(){
		set.add("��");set.add("����");set.add("����");set.add("�ܿ�");
	}

	void out(){
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()){
			String item = iter.next();
			System.out.println("item: "+item);
		}
	}

	public static void main(String[] args) 
	{
		BB2 b = new BB2();
		b.in();
		b.out();
	}
}
