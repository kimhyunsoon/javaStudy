import java.util.*;

class CC3 
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	void in(){
		map.put(2, "����");
		map.put(4, "����");
		map.put(1, "�ܿ�");
		map.put(6, "��");
	}

	void out(){
		Enumeration<Integer> e= map.keys();
		while (e.hasMoreElements()){
			int key = e.nextElement();
			String val = map.get(key);
			System.out.println(key+": "+val);
		}
	
	
	}
	public static void main(String[] args) 
	{
		CC3 c = new CC3();
		c.in();
		c.out();

	}
}
