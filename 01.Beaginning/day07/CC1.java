import java.util.*;

class CC1 
{
	Hashtable map = new Hashtable();
	
	void in(){
		map.put(new Integer(1), "아침");
		map.put(new Integer(2), "점심");
		map.put(new Integer(3), "저녁");
		map.put(new Integer(4), "간식");
	}

	void out(){
		Enumeration e = map.keys();
		while(e.hasMoreElements()){
			Object keyObj= e.nextElement();
			Integer key = (Integer)keyObj;
			Object valObj = map.get(key);
			String val = (String)valObj;
			System.out.println("key: "+key+", val: "+val);
		}
	}
	
	public static void main(String[] args) 
	{
		CC1 c = new CC1();
		c.in();
		c.out();
	}
}
