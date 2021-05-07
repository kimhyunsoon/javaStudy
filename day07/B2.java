import java.util.*;

class B2 //Generic
{
	
	TreeSet<String> set = new TreeSet<String>();

	void in(){
		set.add("아침");set.add("점심");set.add("저녁");set.add("간식");
	
	}
	
	void out(){
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()){
			//Object obj = iter.next();
			//String item= (String )obj;
			String item = iter.next();
			System.out.println("item: "+item);
		}
	}


	public static void main(String[] args) 
	{
		B2 b = new B2();
		b.in();
		b.out();
	}
}
