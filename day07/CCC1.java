import java.util.*;

class CCC1 
{
	Hashtable map = new Hashtable();
	
	void in(){
		map.put(new Integer(1), "��");
		map.put(new Integer(2), "����");
		map.put(new Integer(3), "����");
		map.put(new Integer(4), "�ܿ�");
	
	}

	void out(){
		Enumeration e = map.keys();
		while (e.hasMoreElements()){
			Object keyObj = e.nextElement();
			Integer key = (Integer)keyObj;
			Object valObj = map.get(key);
			String val = (String)valObj;
			System.out.println("key: "+key+", val: "+val);

		}
	
	}
	
	
	public static void main(String[] args) 
	{
		CCC1 c = new CCC1();		
		c.in();
		c.out();
	}
}
