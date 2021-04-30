class D
{	
	void m1(){ // for while (신사)
		int i = 0;  //초기식 - 와일문 밖에 있어야지 유한루프
		while(i<5){ //조건식(유한루프)
			System.out.println("i: "+i);
			i++; //증감식
		}	
		System.out.println("while문 나옴");
	}


	void m2(){ //for do while (조폭)
		int i = 0 ; //초기식
		do{
			System.out.println("i: "+i);
			i++; //증감식
		
		}while(i<0); //조건식
		System.out.println("do while문 나옴");
	}


	void m3(){ //for for문 (신사)
		 for (int i = 0; i<7;i++ ){
			 System.out.println("i: "+i);
		 }
	
		System.out.println("for문 나옴");
		
	}

	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		d.m2();
		d.m3();
	}
}
