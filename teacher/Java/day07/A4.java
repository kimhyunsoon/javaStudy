import java.util.*;

class A4 //Generic + Enhanced Loop ( JDK5 이상부터 지원)
{
	ArrayList<String> list = new ArrayList<String>();

    void in(){
		list.add("봄");list.add("여름");list.add("가을");
		list.add("여름");list.add("겨울");
	}
	void out(){
        for(String item: list){
			System.out.println("item: "+ item);
		}
	}
	public static void main(String[] args) 
	{
		A4 a = new A4();
		a.in();
		a.out();
	}
}
