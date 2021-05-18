import java.util.*;

class A2{//Generic (JDK5부터 지원)
	
	ArrayList<String> list = new ArrayList<String>();

    void in(){
		list.add("봄");list.add("여름");list.add("가을");
		list.add("여름");list.add("겨울");
	}
	void out(){
        int size = list.size();
		//System.out.println("size: " + size);
		for(int i=0; i<size; i++){
		
			String item = list.get(i);
			System.out.println("list.get("+i+"): "+item);

			
		}
	}
	public static void main(String[] args) 
	{
		A1 a = new A1();
		a.in();
		a.out();
	}
}
