class B 
{	
	void m1(){
		int i = 10;
		int j = 20;
		boolean b = i<j;
		if(b){
			System.out.println("����");
		}	
	}
	
	
	void m2(){
		int i = -10;
		if(i<0){
			System.out.println("i�� 0���� �۴�");
		}else if(i>0){
			System.out.println("i�� 0���� ũ��");
		}else{
			System.out.println("i�� 0�̴�");
		}
		
	}



	public static void main(String[] args) 
	{
		B b = new B();
		b.m1();
		b.m2();
	}
}