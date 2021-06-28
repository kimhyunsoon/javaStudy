import java.util.*;

class C4 //Generic + AutoBoxing + Enhanced Loop 에 의해서
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	void in(){
		map.put(10,"아침");
		map.put(20,"점심");
		map.put(30,"저녁");
	}

	void out(){
		Set<Integer> keys= map.keySet();
		for(int key: keys){
			System.out.println("key: "+key+", val: "+map.get(key));
		}
	}
	public static void main(String[] args) 
	{
		C4 c = new C4();
		c.in();
		c.out();
	}
}
