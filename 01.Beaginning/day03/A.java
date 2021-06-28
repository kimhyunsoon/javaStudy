class A
{
	int i; //멤버변수, 전역변수
	
	void m(){
		int j = 1; //지역변수, 선언초기화
		System.out.println("j: " + j);
	}

	public static void main(String[] args){
		
		A a= new A();
		a.m();
	

	}


} 