import java.util.*;

class C4 //Generic + AutoBoxing + Enhanced Loop ( JDK5 이상부터 지원)
{
	Hashtable<Integer, String> map = new Hashtable<Integer, String>();
	void in(){
		map.put(1, "봄"); //AutoBoxing ( int -> Integer )
		map.put(2, "여름");
		map.put(3, "가을");
		map.put(2, "초여름");
		map.put(4, "겨울");
	}
	void out(){
		Set<Integer> keys = map.keySet();
		for(int key: keys){
			System.out.println("key: " + key + ", val: "+map.get(key));
		}
	}
	public static void main(String[] args) 
	{
		C4 c = new C4();
		c.in();
		c.out();
	}
}
