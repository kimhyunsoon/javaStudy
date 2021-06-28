import java.util.*;

class C3 //Generic + AutoBoxing
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();
	
	void in(){
		map.put(1, "��ħ"); //AutoBoxing�� ���ؼ� int->Integer
		map.put(2, "����");
		map.put(3, "����");
		map.put(4, "����");
	
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
