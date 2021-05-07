import java.util.*;

class AAAA1 
{
	ArrayList list = new ArrayList();
	
	void in(){
	list.add("봄");
	list.add("여름");
	list.add("가을");
	list.add("겨울");
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
