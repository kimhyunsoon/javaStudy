import java.util.*;
class AAA2 
{

ArrayList<String> list = new ArrayList<String>();

void in(){
	list.add("가영");
	list.add("순");
	list.add("소율");
	list.add("똥이");
}

void out(){
	int size = list.size();
	for (int i=0;i<size ;i++ )
	{
		String item = list.get(i);
		System.out.println("item: "+item);
	}


}



	public static void main(String[] args) 
	{
		AAA2 a = new AAA2();
		a.in();
		a.out();
	}
}
