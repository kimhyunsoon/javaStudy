import java.util.*;

class BBB1 
{
	TreeSet set = new TreeSet();

	void in(){
		set.add("봄");set.add("여름");set.add("가을");set.add("겨울");
	
	}
	
	void out(){
		Iterator iter = set.iterator(); //데이터를 iterator에 저장
		while(iter.hasNext()){ //Returns true if the iteration has more elements.
			Object obj= iter.next();
			String item = (String)obj;
			System.out.println("item: "+item);
		
		}
	}


	public static void main(String[] args) 
	{
		BBB1 b= new BBB1();
		b.in();
		b.out();
	}
}
