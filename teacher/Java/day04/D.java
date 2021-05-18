class D 
{
	void m1(){ //for while문 ( 신사 )
		int i = 0 ;  //초기식 
		while(i<0){ //조건식 
			System.out.println("i: " + i);
			i++; //증감식
		}

		System.out.println("while문 나옴");
	}
	void m2(){ //for do while문 ( 조폭 )
		int i = 0 ;  //초기식 
		do{  
			System.out.println("i: " + i);
			i++; //증감식
		}while(i<0); //조건식

		System.out.println("do while문 나옴");
	}
	void m3(){ //for for문 ( 신사 )
		for(int i=0; i<5; i++){
			System.out.println("i: " + i);
		}

		System.out.println("for문 나옴");
	}
	void m4(){
		for(;;){ //== while(true){}
			System.out.println("무한루프");
		}
	}
	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		//d.m2();
		//d.m3();
		d.m4();
	}
}