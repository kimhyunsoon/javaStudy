class C {

	//1) ��� ex)+,-,*,/,%
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

	//2) ���� ex) ++, --
	void m2(){
		int i=0;
		int r1=(i++ + 1); //�켱������ �ش������� ����
		int r2=(++i + 1); //�켱������ �ش������� ����
		i++;
		System.out.println("r1: "+r1+", r2: "+r2+", i: "+ i);
	}

	//3) ���� ex) =, ���� ���� ����� ����
	void m3(){
		int r=10;
		r=20;
		System.out.println("r: "+r);
	}

	//4) ������� ex) +=,-=, *=, /=, %=
	void m4(){ 
		int i = 0;
		i += 2;
		System.out.println("i: "+i);
	}

	//5) ��Ʈ ex) &, |, ^, ~, ����Ʈ(<<, >>, >>>)
	void m5(){
		int i=8;
		int r = i>>2;
			System.out.println("r: "+r);
	
	}

	//6) �� ex) ==, !=, <, <=, >, >=
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
	//7) �� ex) &, &&, |, ||
	void m7(){
		int k=0;
		boolean r1 = 1>2 && k++<1; // short circuit �ΰ� �ִ°� �������ϴ�(������ ����)
		System.out.println("r1: "+r1+", k:"+k);

		int i=1;
		int j=0;
		boolean r2 = true|| i<j++; //short circuit
		System.out.println("r2: " + r2 + ", j: " + j);
	
	
	}

	//8) ������ ex) &=, |=
	void m8(){
		boolean f = false;
		f|=true;
		System.out.println("f: "+f);
	}

	//9) ���� ex) A? B:C
	void m9(){
		String r = 20<10 ? "�����":"«��";
		System.out.println("r: "+r);

		r = null;
		if(20<10){
			r = "�����";
		}else {
			r = "«��";
		}
		System.out.println("r: " + r);
	}
//10) instanceof ex)��ü instanceof Ŭ����
	void m10(){
		String str = "����";
		boolean f = str instanceof Object;
		System.out.println("f: "+f);

		String obj = new String();

		if(obj instanceof String){
			System.out.println(obj+"��ü�� ���ڿ� ��ü�̴�");
		}else{
			System.out.println(obj+"��ü�� ���ڿ� ��ü�� �ƴϴ�");
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
