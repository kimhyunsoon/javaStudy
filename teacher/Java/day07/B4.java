import java.util.*;

class B4 //Generic + Enhanced Loop( JDK5 이상부터 지원)
{
	TreeSet<String> set=new TreeSet<String>();
    void in(){
		set.add("봄");set.add("여름");set.add("가을");
		set.add("여름");set.add("겨울");
	}
	void out(){
        for(String item: set){
			System.out.println("item: " + item);
		}
	}
	public static void main(String[] args) 
	{
		B4 b = new B4();
		b.in();
		b.out();
	}
}
 
