import java.util.*;

class A1 
{
	ArrayList list = new ArrayList();

    void in(){
		list.add("��");list.add("����");list.add("����");
		list.add("����");list.add("�ܿ�");
	}
	void out(){
        int size = list.size();
		//System.out.println("size: " + size);
		for(int i=0; i<size; i++){
			Object obj = list.get(i);
			String item = (String)obj;
			System.out.println("list.get("+i+"): "+ item);
		}
	}
	public static void main(String[] args) 
	{
		A1 a = new A1();
		a.in();
		a.out();
	}
}
