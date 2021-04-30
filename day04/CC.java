class CC // 스위치 구문 반복연습 
{
	void m1(){
	
		int i = 30;
		switch(i){
		case 10: System.out.println("10"); break;
		case 20: System.out.println("20"); break;
		case 30: System.out.println("30"); break;
		default : System.out.println("해당되지 않는다"); break;
		
		}
	}



	void m2(){
		String str = "아침";
		int i = 10;  
		switch(str){
			case "아침": System.out.println("아침");break;
			case "점심": 
				if(i>0) System.out.println("점심A");
				else if(i<0) System.out.println("점심B");
				else System.out.println("안먹음");break;
			default: System.out.println("저녁");
		
		}
	}
	
	void m3(){
		String str = "점심";
		char c = 'A';
		switch(str){
			case "아침": System.out.println("아침");break;
			case "점심":
				switch (c){
					case 'A': System.out.println("점심A");break;
					case 'B': System.out.println("점심B");break;
					default : System.out.println("안먹음");
				}
					break;
				default: System.out.println("저녁");

		
		}
	
	
	
	}




	public static void main(String[] args){
		CC c = new CC();
		c.m1();
		c.m2();
		c.m3();
	}
}

