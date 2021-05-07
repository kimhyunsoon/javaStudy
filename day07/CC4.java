import java.util.*;

class CC4  
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	void in(){
		map.put(1,"봄");
		map.put(2,"여름");
		map.put(3,"가을");
		map.put(4,"겨울");
	}

	void out(){
		Set<Integer> keys = map.keySet(); //Returns a Set view of the keys contained in this map.
		for (int key: keys){
			System.out.println("key: "+key+", val: " + map.get(key));
		
		}
	
	
	}
	
	public static void main(String[] args) 
	{
		CC4 c = new CC4();
		c.in();
		c.out();
	}
}
