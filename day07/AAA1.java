import java.util.*;

class AAA1 
{
	ArrayList list = new ArrayList();

	void in(){
		list.add("봄");	list.add("여름"); list.add("가을"); list.add("겨울");
	}

	void out(){
		int size = list.size(); //리스트의 갯수
		for (int i=0; i<size ;i++ ){
			Object obj = list.get(i); //리스트 데이터를 받는 함수
			String item = (String)obj;
			System.out.println("item: "+item);

		}
	}

	public static void main(String[] args) 
	{
		AAA1 a= new AAA1();
		a.in();
		a.out();

	}
}