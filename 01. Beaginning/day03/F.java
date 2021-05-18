class G
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
		System.out.println("byte의 디폴트값은: " + b );
		System.out.println("short의 디폴트값은: " + s );
		System.out.println("char의 디폴트값은: " + c );
		System.out.println("int의 디폴트값은: " + i );
		System.out.println("long의 디폴트값은: " + lo );
		System.out.println("float의 디폴트값은: " + f );
		System.out.println("double의 디폴트값은: " + d );
		System.out.println("boolean의 디폴트값은: " + flag );
		System.out.println("String의 디폴트값은: " + str );

	
	}


	void m2(){
	
		int i = 10;
		int j = 20;
		int r = i+j;
		System.out.println("결과: " + r );
	
	
	}

	public static void main(String[] args) 
	{
		G g = new G();
		g.m1();
		g.m2();
	}

}



