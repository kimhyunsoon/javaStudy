import java.util.*;

class C4 //Generic + AutoBoxing + Enhanced Loop ( JDK5 �̻���� ����)
{
	Hashtable<Integer, String> map = new Hashtable<Integer, String>();
	void in(){
		map.put(1, "��"); //AutoBoxing ( int -> Integer )
		map.put(2, "����");
		map.put(3, "����");
		map.put(2, "�ʿ���");
		map.put(4, "�ܿ�");
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
