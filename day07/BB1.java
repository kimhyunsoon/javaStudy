import java.util.*;

class BB1 
{
	TreeSet set = new TreeSet();
	void in(){
		set.add("��");
		set.add("����"); set.add("����");
		set.add("�ܿ�");
	
	}

	void out(){
		Iterator iter = set.iterator();
		while (iter.hasNext()) //������ ������ true ��ȯ, ������ false ��ȯ
		{
			Object obj = iter.next();
			String item = (String)obj;
			System.out.println("item: "+item);
		}
	
	}
	
	public static void main(String[] args) 
	{
		BB1 b= new BB1();
		b.in();
		b.out();
	}
}


//������ �������� �ʴ´�. �������� ���. �ߺ��� ������� �ʴ´�