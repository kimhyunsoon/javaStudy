class A
{	
	/*String strs[]; //(1) ���� 
	A(){
		strs = new String[4]; //(2) ���� 
	}*/
    String strs[] = new String[4]; //(1)(2) ���� �� ���� 

	void in(){ //(3) �ʱ�ȭ
		strs[0]="��";strs[1]="����";strs[2]="����"; strs[3]="�ܿ�";
	}
	void out(){ //(4) (���Ҷ�) ��� 
		for(int i=0; i<strs.length; i++)
			System.out.println("strs["+i+"]: " + strs[i]);
	}
	public static void main(String args[]) 
	{
		A a = new A();
		a.in();
		a.out();
	}
}
