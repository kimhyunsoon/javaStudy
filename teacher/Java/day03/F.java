class F 
{
    static final int i = 10; //��� 

	static final int j[] = {10, 20}; //j:���, ����, Ŭ����, ���   

    void m1(){
		//i = 20;
		System.out.println("i: " + i);
	}
	void m2(){
		System.out.println("j[0]: " + j[0]);
		System.out.println("j[1]: " + j[1]);
	}
	public static void main(String[] args) 
	{
		F f = new F();
		//f.m1();
		f.m2();
	}
}
