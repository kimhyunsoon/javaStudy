class D //AutoBoxing (JDK5 이상 지원)
{
	void m1(){ //boxing :  기본형을 참조형으로 바꾸는 것(Wrapper)
	int i=10;
	//Integer iObj = new Integer();
	Integer iObj = i;
	System.out.println("iObj" + iObj);
		
		
		
	}

	void m2(){ //UnBoxing (참조형 Wrapper을 기본형으로)
	
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
