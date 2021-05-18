class B
{	
	String strs[] = {"봄", "여름", "가을", "겨울"}; //(1)(2)(3) 선언 및 생성 및 초기화 
	void out(){ //(4) (원할때) 사용 
		for(int i=0; i<strs.length; i++)
			System.out.println("strs["+i+"]: " + strs[i]);
	}
	public static void main(String args[]) 
	{
		B b = new B();
		b.out();
	}
}
