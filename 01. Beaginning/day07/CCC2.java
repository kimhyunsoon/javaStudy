import java.util.*;

class CCC2 
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();
	
	void in(){
		map.put(new Integer(1), "��ħ");
		map.put(new Integer(2), "����");
		map.put(new Integer(3), "����");
		map.put(new Integer(4), "����");
	
	}
	
	void out(){
		Enumeration<Integer> e = map.keys();
		while (e.hasMoreElements())
		{
			Integer key = e.nextElement();
			String val = map.get(key);
			System.out.println("key: "+key+", val"+val);
		}
	
	
	}


	public static void main(String[] args) 
	{
		CCC2 c = new CCC2();
		c.in();
		c.out();

	}
}
