import java.util.*;

class A4 //Generic + Enhanced Loop ( JDK5 �̻���� ����)
{
	ArrayList<String> list = new ArrayList<String>();

    void in(){
		list.add("��");list.add("����");list.add("����");
		list.add("����");list.add("�ܿ�");
	}
	void out(){
        for(String item: list){
			System.out.println("item: "+ item);
		}
	}
	public static void main(String[] args) 
	{
		A4 a = new A4();
		a.in();
		a.out();
	}
}
