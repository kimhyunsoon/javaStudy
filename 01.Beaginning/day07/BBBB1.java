import java.util.*;

class BBBB1 
{
	
	TreeSet set = new TreeSet();

	void in(){
		set.add("아침");set.add("점심");set.add("저녁");set.add("간식");
	
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
