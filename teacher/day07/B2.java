import java.util.*;

class B2 //Generic ( JDK5 �̻���� ����)
{
	TreeSet<String> set=new TreeSet<String>();
    void in(){
		set.add("��");set.add("����");set.add("����");
		set.add("����");set.add("�ܿ�");
	}
	void out(){
        Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			//Object obj = iter.next();
            //String item = (String)obj;
			String item = iter.next();
			System.out.println("item: " + item);
		}
	}
	public static void main(String[] args) 
	{
		B2 b = new B2();
		b.in();
		b.out();
	}
}
