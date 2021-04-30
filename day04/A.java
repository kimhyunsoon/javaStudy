class A
{
	A(){
		System.out.println("A(): 1");
		m1();
		System.out.println("A(): 2");
		m2();
		System.out.println("A(): 3");
	
	}	

	void m1(){
		System.out.println("m1(): 0");
		m2();
		System.out.println("m1(): 1");
		
	}


	void m2(){
		System.out.println("m2(): 5");
			
	}

	public static void main(String[] args) 
	{
		System.out.println("main(): 1");
		A a = new A();
		System.out.println("main(): 2");
	
	}


}