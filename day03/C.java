class C 
{
	//적금으로 얼마나 벌었는가

	int kb = 500000;
	int wel = 300000;
	int wb = 100000;
	double incomeTax = 0.165;
	

		

	void cal1(){ //kb 이자계산(단리)
		double rate = 0.05; //이자율
		int savingYear = kb*12;	//1년 저축액	
		double tax = kb*rate*12; //이자금액
		double prevTax = savingYear+tax; //세전금액
		
		
		System.out.println("국민은행 만기환급금액: " + (int)(prevTax-tax*incomeTax) +"원");
		System.out.println("국민은행 1년저축액: " + savingYear+"원");
		System.out.println("국민은행 1년이자: " + (int) tax+"원");
		System.out.println("국민은행 세전금액: " + (int)(savingYear+tax)+"원");
		System.out.println("국민은행 이자소득세: " + (int)(tax*incomeTax)+"원");
	}

	void cal2(){ //웰뱅 이자계산(단리)
		double rate = 0.03; //이자율
		int savingYear = wel*12;	//1년 저축액	
		double tax = wel*rate*12; //이자금액
		double prevTax = savingYear+tax; //세전금액
		
		
		System.out.println("웰컴뱅크 만기환급금액: " + (int)(prevTax-tax*incomeTax)+"원");
		System.out.println("웰컴뱅크 1년저축액: " + savingYear+"원");
		System.out.println("웰컴뱅크 1년이자: " + (int) tax+"원");
		System.out.println("웰컴뱅크 세전금액: " + (int)(savingYear+tax)+"원");
		System.out.println("웰컴뱅크 이자소득세: " + (int)(tax*incomeTax)+"원");
	}
	

	public static void main(String[] args) 
	{
		C c= new C();
		System.out.println("-----국민은행-----");
		c.cal1();
		System.out.println("-----웰컴뱅크-----");
		c.cal2();
	}

}





/* public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}*/