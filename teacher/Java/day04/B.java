class B 
{
	void m1(){
		int i = -10; 

		if(i<0){  
			System.out.println("i���� 0���� �۴�");
		}else if(i>0){
			System.out.println("i���� 0���� ũ��");
		}else {
			System.out.println("i���� 0�̴�");
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
