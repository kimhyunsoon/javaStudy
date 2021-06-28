class 주체
{
	int 기상시간=7;
	주체(){
	}
	void 일어난다(){
		System.out.println("나는"+기상시간+"시에 일어난다");
	} 
}

class 기상조건
{
	String 상태1 = "맑은";
	String 상태2 = "비가 오는";
	
	기상조건(){
	}
	void 맑은날씨() {
		System.out.print(상태1 + " 날씨에는");
	}
	void 비오는날씨() {
		기상조건 날씨2 = new 기상조건();
		System.out.print(날씨2.상태2 + " 날씨에는");
	}
}

class 활동
{
	String 종류1 = "달리기";
	String 종류2 = "실내운동";
	int 시간1 = 60;
	int 시간2 = 90;

	활동(){
	}
	void 야외활동(){	
		System.out.println(종류1 + "를" +시간1+" 분 동안 하고,");
	}
	void 실내활동(){
		System.out.println(종류2 + "를" +시간2+" 분 동안 한다");
	}
}

class 아침엔{
	public static void main(String args[]) {
		주체 나1 = new 주체();
		기상조건 날씨1 = new 기상조건();
		기상조건 날씨2 = new 기상조건();
		활동 운동1 = new 활동();
		활동 운동2 = new 활동();

		나1.일어난다();
		날씨1.맑은날씨(); 
		운동1.야외활동();
		날씨2.비오는날씨(); 
		운동2.실내활동();
	}
}
