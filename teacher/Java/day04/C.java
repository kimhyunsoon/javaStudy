class C {

	void m1(){ //정수형 ( byte, short, char, int ) + String (JDK7~)
		int i = 20;
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: 
				System.out.println("20"); 
				break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10도 20도 30도 아니다");
		}//
	}
	void m2(){
		String str = "점심";
		char c = 'Z';
		switch(str){
			case "아침": System.out.println("아침"); break;
			case "점심": 
				 switch(c){
				    case 'A': System.out.println("A"); break;
					case 'B': System.out.println("B"); break;
					default: System.out.println("A도 B도 아님");
				 }
                 break;
			default: System.out.println("저녁"); 
		}//
	}
	void m3(){
		String str = "점심";
		char c = 'Z';
		switch(str){
			case "아침": System.out.println("아침"); break;
			case "점심": 
				if(c == 'A') System.out.println("A");
			    else if(c == 'B') System.out.println("B");
				else System.out.println("A나 B는 아님"); 

				break;
			default: System.out.println("저녁"); 
		}//
	}
	public static void main(String[] args) 
	{
		C c = new C();
		//c.m1();
		//c.m2();
		c.m3();
	}
}
