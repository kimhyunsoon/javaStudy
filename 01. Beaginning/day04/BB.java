class BB 
{
	int i = 30;
	int j = 20;
	
	void m1(){
		boolean t = i>j;
		if(t){
			System.out.println("수행");
			
		}	
	}
	
	
	void m2(){
		if (i>j){
			System.out.println("i는 j보다 크다");
		}else if (i<j){
			System.out.println("i는 j보다 작다");
		}else{
			System.out.println("i와 j는 같다");
		}
	
	
	
	
	
	}
	
	
	public static void main(String[] args) 
	{
		BB bb= new BB();
		bb.m1();
		bb.m2();
	}
}
