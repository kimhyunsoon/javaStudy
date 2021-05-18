class BBBB
{
	void m(){
		int i = 2;
		int j = 5;

		if (i+j>10){
			System.out.println("수행");		
		}else{
			System.out.println("수행하지 않음");
		}	
	
	}

	public static void main(String[] args) 
	{
		BBBB b = new BBBB();
		b.m();
		
	}

}