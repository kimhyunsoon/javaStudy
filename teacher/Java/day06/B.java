class B
{	
	String strs[] = {"��", "����", "����", "�ܿ�"}; //(1)(2)(3) ���� �� ���� �� �ʱ�ȭ 
	void out(){ //(4) (���Ҷ�) ��� 
		for(int i=0; i<strs.length; i++)
			System.out.println("strs["+i+"]: " + strs[i]);
	}
	public static void main(String args[]) 
	{
		B b = new B();
		b.out();
	}
}
