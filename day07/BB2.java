import java.util.*;

class BB2 //Generic
{
	TreeSet<String> set = new TreeSet<String>();
	void in(){
		set.add("봄");set.add("여름");set.add("가을");set.add("겨울");
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
