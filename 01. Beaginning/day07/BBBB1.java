import java.util.*;

class BBBB1 
{
	
	TreeSet set = new TreeSet();

	void in(){
		set.add("��ħ");set.add("����");set.add("����");set.add("����");
	
	}
	
	void out(){
		Iterator iter = set.iterator();
		while (iter.hasNext()){
			Object obj = iter.next();
			String item= (String )obj;
			System.out.println("item: "+item);
		}
	}


	public static void main(String[] args) 
	{
		BBBB1 b = new BBBB1();
		b.in();
		b.out();
	}
}
