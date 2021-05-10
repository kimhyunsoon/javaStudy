class D
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;
	String str;

	void m1(){
		/*System.out.println("b: " + b );
		System.out.println("s: " + s );
		System.out.println("char의 디폴트값은: " + c );
		System.out.println("int의 디폴트값은: " + i );
		System.out.println("long의 디폴트값은: " + lo );
		System.out.println("float의 디폴트값은: " + f );
		System.out.println("double의 디폴트값은: " + d );
		System.out.println("boolean의 디폴트값은: " + flag );
		System.out.println("String의 디폴트값은: " + str );*/

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

	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		
	}

}


