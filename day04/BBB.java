class BBB 
{
	void m1(){
		int i = 20;
		int j = 15;

		if (i>j){
			System.out.println("i>j");
		}else if (i<j){
			System.out.println("i<j");
		}else{
		System.out.println("i=j");
		} 
	
	
	}
	
	public static void main(String[] args) 
	{
		BBB b = new BBB();
		b.m1();
	}
}
