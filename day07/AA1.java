import java.util.*;

class AA1
{
	ArrayList list = new ArrayList();

	void in(){
		list.add("��ũ");
		list.add("ǻ��");
		list.add("ǻ��");
		list.add("���̳ʽ�Ƽ");
	}

	void out(){
		int size = list.size();
		System.out.println("size: "+size);
		for (int i=0;i<size ;i++ )
		{
			System.out.println("List.get("+i+"): "+list.get(i));
		}
	
	}
	


	public static void main(String[] args) 
	{
		AA1 a= new AA1();
		a.in();
		a.out();
	}
}
