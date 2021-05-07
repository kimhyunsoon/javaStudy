import java.util.*;

class BB1 
{
	TreeSet set = new TreeSet();
	void in(){
		set.add("봄");
		set.add("여름"); set.add("가을");
		set.add("겨울");
	
	}

	void out(){
		Iterator iter = set.iterator();
		while (iter.hasNext()) //다음이 있으면 true 반환, 없으면 false 반환
		{
			Object obj = iter.next();
			String item = (String)obj;
			System.out.println("item: "+item);
		}
	
	}
	
	public static void main(String[] args) 
	{
		BB1 b= new BB1();
		b.in();
		b.out();
	}
}


//순서를 보존하지 않는다. 오름차순 출력. 중복을 허용하지 않는다