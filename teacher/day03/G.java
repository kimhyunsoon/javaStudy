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
		System.out.println("char�� ����Ʈ����: " + c );
		System.out.println("int�� ����Ʈ����: " + i );
		System.out.println("long�� ����Ʈ����: " + lo );
		System.out.println("float�� ����Ʈ����: " + f );
		System.out.println("double�� ����Ʈ����: " + d );
		System.out.println("boolean�� ����Ʈ����: " + flag );
		System.out.println("String�� ����Ʈ����: " + str );*/

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


