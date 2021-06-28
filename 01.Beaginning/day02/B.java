class 나
{
	int 기상시간=7;
	나(){
		
	}
	
	void 일어난다(){
		나 나1 = new 나();
		System.out.println("나는"+나1.기상시간+"시에 일어난다");		
	} 

}

class 날씨
{
	String 상태 = "맑은";	
	날씨(){
		}
	
	void 날씨상태() {
	날씨 날씨1 = new 날씨();
	System.out.println(날씨1.상태 + "날씨에는");
	}
}



class 운동
{
	String 종류 = "달리기";
	int 시간 = 60;	

	운동(){
	}
	
	void 야외운동(){	
		
		운동 운동1 = new 운동();
		System.out.println
			(운동1.종류 + "를" +운동1.시간+"분 동안 한다");
	}
		
}


class 아침{
	
	public static void main(String args[]) {
		나 나1 = new 나();
		날씨 날씨1 = new 날씨();
		운동 운동1 = new 운동();
		
		나1.일어난다();
		날씨1.날씨상태(); 
		운동1.야외운동();
	
	}
}
