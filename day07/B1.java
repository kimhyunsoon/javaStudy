import java.util.*;

class B1 
{
	TreeSet set=new TreeSet();
    void in(){
		set.add("��");set.add("����");set.add("����");set.add("�ܿ�");
	}
	void out(){
        Iterator iter = set.iterator();
		while(iter.hasNext()){ //������ �ִ�? ������ true�� ��ȯ, ������ false
			Object obj = iter.next();
            String item = (String)obj;
			System.out.println("item: " + item);
		}
	}
	public static void main(String[] args) 
	{
		B1 b = new B1();
		b.in();
		b.out();
	}
}

//������ �������� �ʴ´�. �������� ���. �ߺ��� ������� �ʴ´�