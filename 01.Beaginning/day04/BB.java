class BB 
{
	int i = 30;
	int j = 20;
	
	void m1(){
		boolean t = i>j;
		if(t){
			System.out.println("����");
			
		}	
	}
	
	
	void m2(){
		if (i>j){
			System.out.println("i�� j���� ũ��");
		}else if (i<j){
			System.out.println("i�� j���� �۴�");
		}else{
			System.out.println("i�� j�� ����");
		}
	
	
	
	
	
	}
	
	
	public static void main(String[] args) 
	{
		BB bb= new BB();
		bb.m1();
		bb.m2();
	}
}
