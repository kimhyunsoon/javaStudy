import java.util.*;

class C1 
{
	Hashtable map = new Hashtable();
	void in(){
		map.put(new Integer(1), "��");
		map.put(new Integer(2), "����");
		map.put(new Integer(3), "����");
		map.put(new Integer(2), "�ʿ���");
		map.put(new Integer(4), "�ܿ�");
	}
	void out(){
		Enumeration e = map.keys();
		while(e.hasMoreElements()){
			Object keyObj = e.nextElement();
			Integer key = (Integer)keyObj;
			Object valObj = map.get(key);
			String val = (String)valObj;
			System.out.println("key: " + key + ", val: "+val);
		}
	}
	public static void main(String[] args) 
	{
		C1 c = new C1();
		c.in();
		c.out();
	}
}
