import java.util.*;

class C3 //Generic + AutoBoxing
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();
	
	void in(){
		map.put(1, "아침"); //AutoBoxing에 의해서 int->Integer
		map.put(2, "점심");
		map.put(3, "저녁");
		map.put(4, "간식");
	
	}
	
	void out(){
		Enumeration<Integer> e = map.keys();
		while (e.hasMoreElements())
		{
			int key = e.nextElement();
			String val = map.get(key);
			System.out.println("key: "+(key+1)+", val"+val);
		}
	
	
	}


	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();

	}
}
