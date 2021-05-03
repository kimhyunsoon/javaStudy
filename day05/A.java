class A  
{
	boolean flag = true;

	void m1(){
		aa:
		for (int j=0; j<2; j++){
			for (int i=0; i<5; i++){
				if(i==3) break aa; //break 자신을 둘러싼 첫 번째 블럭으로 나간다
				System.out.println("j: " + j + ", i: " + i);
			}
			System.out.println("안쪽 for 나옴");
		}
		System.out.println("바깥쪽 for 나옴");
	}
	void m2(){
		bb:
		for (int j =0; j<2;j++){
			for (int i=0;i<5 ;i++ ){
				if(i==2) continue bb; //조건에 맞으면 건너뛴다(연산하지 않는다?) 조건과 함께 나온다
				System.out.println("j: " + j + ", i: " + i);

			}
			System.out.println("안쪽 for 나옴");;
		}

		System.out.println("바깥쪽 for 나옴");
	}
	void m3(){
		System.out.println("m3(): 1");
		if(flag) return; 
		System.out.println("m3(): 2");
	}
	
	A(){
		m3();
		System.out.println("B()");
	}
	
	
	

	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		a.m2();
		a.m3();
		
	}
}
