class D //AutoBoxing (JDK5 �̻� ����)
{
	void m1(){ //boxing :  �⺻���� ���������� �ٲٴ� ��(Wrapper)
	int i=10;
	//Integer iObj = new Integer();
	Integer iObj = i;
	System.out.println("iObj" + iObj);
		
		
		
	}

	void m2(){ //UnBoxing (������ Wrapper�� �⺻������)
	
		Integer iObj = i;
		//int i=iObj.intValue();
		int i = iObj;
		System.out.println("i: "+i);
	
	
	
	}

	
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		d.m2();
	}
}
