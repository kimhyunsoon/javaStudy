class B 
{
	boolean flag = true;
	B(){
		m1();
		System.out.println("B()");
	}
	void m1(){
		System.out.println("m1(): 1");
		if (flag) return;
		System.out.println("m1(): 2");
	
	}

	void m2(){
		for (int j=0; j<2 ; j++ ){
			for (int i=0; i<5; i++){
				if(i==3) return;
				System.out.println("j: " + j + ", i: " + i);
			}
			System.out.println("¾ÈÂÊ for ³ª¿È");
		}
	
	}

	int m3(){
		int i=7;
		System.out.println("m3()");
		return i;
	
	}

	public static void main(String[] args) 
	{
		B b= new B();
		b.m1();
		b.m2();
		System.out.println("main(): 1");
		int r = b.m3();
		System.out.println("main(): 2, r: "+r);

	}
}
