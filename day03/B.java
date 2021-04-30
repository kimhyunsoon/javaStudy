class B
{
	//100점 만점인 시험성적표
	byte 국어 = 80;
	byte 수학 = 85;
	byte 영어 = 75;

	void sum(){
		int 합계 = 국어 + 수학 + 영어;
		System.out.println("합계: "+ 합계 );
		}


	void average(){
		byte 평균 = (byte)((국어 + 수학 + 영어)/3);
		System.out.println("평균: "+ 평균 );

	
	}
}

class 성적표
{
	public static void main(String[] args){
		B b1 = new B();
		b1.sum();
		b1.average();

	}
}


	
	












/* public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	} */