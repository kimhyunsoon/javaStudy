import java.util.*;

class B1 
{
	TreeSet set=new TreeSet();
    void in(){
		set.add("봄");set.add("여름");set.add("가을");
		set.add("여름");set.add("겨울");
	}
	void out(){
        Iterator iter = set.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
            String item = (String)obj;
			System.out.println("item: " + item);
		}
	}
	public static void main(String[] args) 
	{
		B1 b = new B1();
		b.in();
		b.out();
	}
}
