import java.util.*;

class B4 //Generic
{
	TreeSet<String> set = new TreeSet<String>();
	void in(){
		set.add("��");set.add("����");set.add("����");set.add("�ܿ�");
	}

	void out(){
		
		for(String item: set){
			System.out.println("item: "+item);
		}
	}

	public static void main(String[] args) 
	{
		B4 b = new B4();
		b.in();
		b.out();
	}
}
