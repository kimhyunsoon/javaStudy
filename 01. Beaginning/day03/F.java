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
		System.out.println("byte�� ����Ʈ����: " + b );
		System.out.println("short�� ����Ʈ����: " + s );
		System.out.println("char�� ����Ʈ����: " + c );
		System.out.println("int�� ����Ʈ����: " + i );
		System.out.println("long�� ����Ʈ����: " + lo );
		System.out.println("float�� ����Ʈ����: " + f );
		System.out.println("double�� ����Ʈ����: " + d );
		System.out.println("boolean�� ����Ʈ����: " + flag );
		System.out.println("String�� ����Ʈ����: " + str );

	
	}


	void m2(){
	
		int i = 10;
		int j = 20;
		int r = i+j;
		System.out.println("���: " + r );
	
	
	}

	public static void main(String[] args) 
	{
		G g = new G();
		g.m1();
		g.m2();
	}

}



