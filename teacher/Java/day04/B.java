class B 
{
	void m1(){
		int i = -10; 

		if(i<0){  
			System.out.println("i보다 0보다 작다");
		}else if(i>0){
			System.out.println("i보다 0보다 크다");
		}else {
			System.out.println("i보다 0이다");
		}
	}
	public static void main(String[] args) 
	{
		B b = new  B();
		b.m1();
	}
}

/*
  > greater than
  < less than 
  >= greater than or equal
  <= less than or equal 
*/
