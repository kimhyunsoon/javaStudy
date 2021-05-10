class A
{	
	/*String strs[]; //(1) 선언 
	A(){
		strs = new String[4]; //(2) 생성 
	}*/
    String strs[] = new String[4]; //(1)(2) 선언 및 생성 

	void in(){ //(3) 초기화
		strs[0]="봄";strs[1]="여름";strs[2]="가을"; strs[3]="겨울";
	}
	void out(){ //(4) (원할때) 사용 
		for(int i=0; i<strs.length; i++)
			System.out.println("strs["+i+"]: " + strs[i]);
	}
	public static void main(String args[]) 
	{
		A a = new A();
		a.in();
		a.out();
	}
}
