import java.util.*;

class C4 //Generic + AutoBoxing + Enhanced Loop �� ���ؼ�
{
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	void in(){
		map.put(10,"��ħ");
		map.put(20,"����");
		map.put(30,"����");
	}

	void out(){
		Set<Integer> keys= map.keySet();
		for(int key: keys){
			System.out.println("key: "+key+", val: "+map.get(key));
		}
	}
	public static void main(String[] args) 
	{
		C4 c = new C4();
		c.in();
		c.out();
	}
}
