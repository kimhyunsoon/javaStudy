//AutoBoxing ( JDK5 ~ 이상 지원 ) 

class D 
{
	void m1(){ //boxing ( 기본형 -> 참조형(Wrapper) )
		int i = 10;
		//Integer iObj = new Integer(i);
        Integer iObj = i; //AutoBoxing 
		System.out.println("iObj: " + iObj);
	}
	void m2(){ //unboxing ( 참조형(Wrapper) ->)
		Integer iObj = new Integer(20);
		//int i = iObj.intValue();
		int i = iObj; //UnBoxing 
		System.out.println("i: " + i);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		d.m2();
	}
}
