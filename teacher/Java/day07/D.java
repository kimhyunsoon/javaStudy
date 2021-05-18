//AutoBoxing ( JDK5 ~ �̻� ���� ) 

class D 
{
	void m1(){ //boxing ( �⺻�� -> ������(Wrapper) )
		int i = 10;
		//Integer iObj = new Integer(i);
        Integer iObj = i; //AutoBoxing 
		System.out.println("iObj: " + iObj);
	}
	void m2(){ //unboxing ( ������(Wrapper) ->)
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
