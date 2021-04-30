class B 
{	
	void m1(){
		int i = 10;
		int j = 20;
		boolean b = i<j;
		if(b){
			System.out.println("수행");
		}	
	}
	
	
	void m2(){
		int i = -10;
		if(i<0){
			System.out.println("i는 0보다 작다");
		}else if(i>0){
			System.out.println("i는 0보다 크다");
		}else{
			System.out.println("i는 0이다");
		}
		
	}



	public static void main(String[] args) 
	{
		B b = new B();
		b.m1();
		b.m2();
	}
}