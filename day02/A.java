class 붕어빵{
	String 앙꼬 = "팥";
	int 가격 = 200; //속성
	붕어빵(){	//생성자, 객체를 만들기 위해
		}
	붕어빵(String 앙, int 가){
		앙꼬 = 앙;
		가격 = 가;
	
	}

	
	void 따뜻하게한다(){//mathod
		System.out.println("따뜻하게한다");
	}
	void 배부르게한다(){
		System.out.println("배부르게한다");
	}
}

/* 붕어빵의 속성은 앙꼬와 가격이 있음
붕어빵의 행위는 따뜻하게 한다, 배부르게 한다*/

class 아주머니{//
	int 나이 = 60;
	붕어빵 빵1, 빵2; //빵1과 빵2가 붕어빵이라는 타입을 갖고 있다
	아주머니(){
		나이 = 55;
		}
	아주머니(int 나){
		나이 = 나; //클래스 아래에서 선언된게 멤버변수
		} 
		//클래스 신에서 아주머니 클래스를 호출할때 파라미터값이 존재하면, int 나에 그 나이가 들어감

	void 굽는다(){
		빵1 = new 붕어빵(); //빵1이라는 객체는 붕어빵이라는 생성자를 호출해서 만든거임
		
		System.out.print("앙꼬가"+빵1.앙꼬+"인 붕어빵과");
		빵2 = new 붕어빵("설탕",100);
		System.out.println("앙꼬가"+빵2.앙꼬+"인 붕어빵을 구우셨어요");
	}
	void 판매한다(붕어빵 빵){
		System.out.println("가격이" +빵.가격+"인 붕어빵을 판매한다");
	}

}

class 신
{
	public static void main(String args[]){
	 아주머니 주1 = new 아주머니(45);
	 System.out.print("연세가" + 주1.나이 + "세인 아주머니께서");
	 주1.굽는다();
	 주1.판매한다(주1.빵2);
	}
}

class 붕어빵의입장
{
	public static void main(String args[]){
		붕어빵 빵1 = new 붕어빵();
		System.out.print("붕어빵은 나를");
		빵1.따뜻하게한다();
	}

}

