import java.util.*;

class AA2 //Generic에 의해서 Object를 String으로 형변환
{
	ArrayList<String> list = new ArrayList<String>();
	
	void in(){
	list.add("봄");
	list.add("여름");
	list.add("가을");
	list.add("겨울");
	}
	
	void out(){
		int size = list.size();
		for (int i=0; i<size;i++ ){
			//Object obj = list.get(i); Generic에 의해서 생략 가능
			String item = list.get(i);
			System.out.println("item: "+item);

		}
	}


	public static void main(String[] args) 
	{
		AA2 a = new AA2();
		a.in();
		a.out();
	}
}
