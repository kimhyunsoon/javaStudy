import java.util.*;

class C3 //Generic + AutoBoxing ( JDK5 이상부터 지원)
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
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			//Object keyObj = e.nextElement();
			//Integer key = (Integer)keyObj;
			int key = e.nextElement(); //by UnBoxing
			
			//Object valObj = map.get(key);
			//String val = (String)valObj;
			String val = map.get(key);
			System.out.println("key: " + key + ", val: "+val);
		}
	}
	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();
	}
}
