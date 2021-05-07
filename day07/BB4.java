import java.util.*;

class BB4 
{
	TreeSet<String> set = new TreeSet<String>();

	void in(){
		set.add("아침");set.add("점심");set.add("저녁");set.add("간식");
	
	}

	void out(){
		for(String item: set){
			System.out.println("item: "+item);
		}
	
	
	}
	
	public static void main(String[] args) 
	{
		BB4 b= new BB4();
		b.in();
		b.out();

	}
}
