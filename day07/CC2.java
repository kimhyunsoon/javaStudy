import java.util.*;

class C2 //Generic ( JDK5 �̻���� ����)
{
	Hashtable<Integer, String> map = new Hashtable<Integer, String>();
	void in(){
		map.put(new Integer(1), "��");
		map.put(new Integer(2), "����");
		map.put(new Integer(3), "����");
		map.put(new Integer(2), "�ʿ���");
		map.put(new Integer(4), "�ܿ�");
	}
	void out(){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			//Object keyObj = e.nextElement();
			//Integer key = (Integer)keyObj;
			Integer key = e.nextElement();

			//Object valObj = map.get(key);
			//String val = (String)valObj;
			String val = map.get(key);
			System.out.println("key: " + key + ", val: "+val);
		}
	}
	public static void main(String[] args) 
	{
		C2 c = new C2();
		c.in();
		c.out();
	}
}
