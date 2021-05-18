import java.util.*;

class AA4 
{
	ArrayList<String> list = new ArrayList<String>();
	
	void in(){
		list.add("아침");list.add("점심");list.add("저녁");list.add("간식");
	}

	void out(){
		for(String item: list){
			System.out.println("item: "+item);
		}
	}

	public static void main(String[] args) 
	{
		AA4 a= new AA4();
		a.in();
		a.out();
	}
}
