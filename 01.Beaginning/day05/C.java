class C {

	//1) 산술 ex)+,-,*,/,%
	void m1(){
		int i=3;
		int j=10;
		int r1=i/j;
		System.out.println("r1: "+r1);
		int r2=j/i;
		System.out.println("r2: "+r2);
		int r3=j%i;
		System.out.println("r3: "+r3);
	}

	//2) 증감 ex) ++, --
	void m2(){
		int i=0;
		int r1=(i++ + 1); //우선순위가 극단적으로 낮음
		int r2=(++i + 1); //우선순위가 극단적으로 높음
		i++;
		System.out.println("r1: "+r1+", r2: "+r2+", i: "+ i);
	}

	//3) 대입 ex) =, 거의 제일 꼴찌로 연산
	void m3(){
		int r=10;
		r=20;
		System.out.println("r: "+r);
	}

	//4) 산술대입 ex) +=,-=, *=, /=, %=
	void m4(){ 
		int i = 0;
		i += 2;
		System.out.println("i: "+i);
	}

	//5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
	void m5(){
		int i=8;
		int r = i>>2;
			System.out.println("r: "+r);
	
	}

	//6) 비교 ex) ==, !=, <, <=, >, >=
	void m6(){
		int i =1;
		int j =0;
		boolean f1 = true;
		//boolean r1 = f1;
		boolean r1 = f1 != (i<j);
		System.out.println("r1: "+r1);
		boolean r2 = i>=1;
		System.out.println("r2: "+r2);

	}
	//7) 논리 ex) &, &&, |, ||
	void m7(){
		int k=0;
		boolean r1 = 1>2 && k++<1; // short circuit 두개 있는건 고지식하다(무조건 수행)
		System.out.println("r1: "+r1+", k:"+k);

		int i=1;
		int j=0;
		boolean r2 = true|| i<j++; //short circuit
		System.out.println("r2: " + r2 + ", j: " + j);
	
	
	}

	//8) 논리대입 ex) &=, |=
	void m8(){
		boolean f = false;
		f|=true;
		System.out.println("f: "+f);
	}

	//9) 조건 ex) A? B:C
	void m9(){
		String r = 20<10 ? "자장면":"짬뽕";
		System.out.println("r: "+r);

		r = null;
		if(20<10){
			r = "자장면";
		}else {
			r = "짬뽕";
		}
		System.out.println("r: " + r);
	}
//10) instanceof ex)객체 instanceof 클래스
	void m10(){
		String str = "순대";
		boolean f = str instanceof Object;
		System.out.println("f: "+f);

		String obj = new String();

		if(obj instanceof String){
			System.out.println(obj+"객체는 문자열 객체이다");
		}else{
			System.out.println(obj+"객체는 문자열 객체가 아니다");
		}




	}








	public static void main(String[] args) 
	{
		C c = new C();
		c.m1();
		c.m2();
		c.m3();
		c.m4();
		c.m5();
		c.m6();
		c.m7();
		c.m8();
		c.m9();
		c.m10();
	}
}
