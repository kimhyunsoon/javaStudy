class D 
{
	byte b;
	char c;
	short s;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;
	String str;

	void m1(){
		System.out.println("b: " + b);
		System.out.println("c: " + (int)c);
		System.out.println("s: " + s);
		System.out.println("i: " + i);
		System.out.println("lo: " + lo);
		System.out.println("f: " + f);
		System.out.println("d: " + d);
        System.out.println("flag: " + flag);
		System.out.println("str: " + str);
	}
	void m2(){ //int 
	    /*Integer i = new Integer(10);
		Integer j = new Integer(20);
		Integer rr = new Integer(i.intValue() + j.intValue());
		System.out.println("결과: " + rr.intValue());
		*/

		int i = 10;
		int j = 20;
		int r = i+j;
        System.out.println("결과: " + r);  
	}

	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		d.m2();
	}
}
