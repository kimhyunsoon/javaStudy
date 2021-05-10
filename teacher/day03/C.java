class C 
{
	long lo = 20L;
    float f = 30.111111111f;

	void m1(){
		float r = f + lo;
		System.out.println("r: " + r);
	}
	void m2(){
		float f2 = 40.222222222f;
		float r = f + f2;
		System.out.println("r: " + r);
	}
	void m3(){
		double d1 = 30.1111111111111111111111111111d;
		double d2 = 40.2222222222222222222222222222d;
		double r = d1 + d2; 
		System.out.println("r: " + r);
	}
	public static void main(String[] args) 
	{
		C c = new C();
		//c.m1();
		//c.m2();
		c.m3();
	}
}
