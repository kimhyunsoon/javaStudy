class DD
{
	
	void m1(){ //boxing : �⺻��->������ (Wrapper)
		int i = 10;
		//Integer iObj = new Integer(i);
		Integer iObj = i; //AutoBoxing
		System.out.println("iObj: "+(iObj+1));
	
	
	}

	void m2(){//unBoxing : ������(Wrapper)->�⺻��
		Integer iObj = new Integer(20);
		//int i = iObj.intValue();
		int i = iObj;
		System.out.println("i: "+(i+3));
	
	
	
	}
	
	public static void main(String[] args) 
	{
		DD d= new DD();
		d.m1();
		d.m2();
	}
}
