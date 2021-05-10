class B 
{
	int i = 2000000000;
	long j = 3000000000L;

	void m1(){
		long r = i + j;
		System.out.println("r: " + r);
	}
	void m2(){
        byte b = 10;
		int ii = 200;
		byte r = (byte)(ii-b);
		System.out.println("r: " + r);
	}
	void m3(){
		byte b = 10;
		short s = 20;
		int r = b + s;
		System.out.println("r: " + r);
	}
	public static void main(String[] args) 
	{
		B bObj = new B();
		//bObj.m1();
		//bObj.m2();
		bObj.m3();
	}
}
