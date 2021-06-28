class C 
{

	void m1(){ 
		/*byte, short, char, int 등 정수형만 들어갈 수 있다.
		JDK7 이후부터는 String 됨 String str = " "; */

		
		int i = 20; 
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: System.out.println("20");
					 System.out.println("21");
					 System.out.println("22");
					 break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10도 20도 30도 아니다"); //위치는 관계가 없다
			
		}
	} //스위치문




	void m2(){
		String str = "점심";
		int i = -10;
		switch(str) {
			case "아침": System.out.println("아침"); break;
			case "점심": 
				if(i>0) System.out.println("점심A"); 
				else if(i<0) System.out.println("점심B");
				else System.out.println("A나 B도 아님");
				break;				
			default: System.out.println("저녁"); 
		}
	}

	void m3(){
		String str = "점심";
		char c = 'A';
		switch(str) {
			case "아침": System.out.println("아침"); break;
			case "점심": 
				switch(c){
				case 'A' : System.out.println("점심A"); break;
				case 'B' : System.out.println("점심B"); break;
				default : System.out.println("A도 B도 아님");
			}
				break;				
			default: System.out.println("저녁"); 
		
		
		}
	
	
	}



	public static void main(String[] args) 
	{
		C c = new C();
		c.m1();
		c.m2();
		c.m3();
	}
}
