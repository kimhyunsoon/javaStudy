import java.util.*;

class AA4 
{
	ArrayList<String> list = new ArrayList<String>();
	
	void in(){
		list.add("��ħ");list.add("����");list.add("����");list.add("����");
	}

	void out(){
		for(String item: list){
			System.out.println("item: "+item);
		}
	}

	public static void main(String[] args) 
	{
		AA4 a= new AA4();
		a.in();
		a.out();
	}
}
