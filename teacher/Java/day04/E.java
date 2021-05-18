//2단 
class E 
{
	void m1(){ //2단 
		for(int i=1; i<=9; i++)
			System.out.println("2 * "+i+" =  "+ 2*i);
	}
	void m2(){ //for을 이용한 구구단 
		for(int j=2; j<=9; j++) {
			for(int i=1; i<=9; i++) {
				System.out.println(j+" * "+i+" =  "+ j*i);
			}
			System.out.println();
		}
	}
	void m22(){ //for을 이용한 구구단 
		for(int j=2; j<=9; j++)
			for(int i=1; i<=9; i++) 
				System.out.println(j+" * "+i+" =  "+ j*i);
	}
	void m3(){ //999단 
        System.out.println("2 * 1 * 1 =   2");
		System.out.println("2 * 1 * 2 =   4");
		System.out.println("....");
		System.out.println("2 * 2 * 1 =   4");
		System.out.println("2 * 2 * 2 =   8");
		System.out.println("....");
		System.out.println("9 * 1 * 1 =   9");
		System.out.println("9 * 1 * 2 =  18");
		System.out.println("....");
		System.out.println("9 * 9 * 9 =  729");
	}
	void m33(){ //999단
		for(int k=2; k<=9; k++)
           for(int j=1; j<=9; j++)
			 for(int i=1; i<=9; i++) 
				System.out.println(k + " * " +j+" * "+i+" =  "+ k*j*i);
	}
	void m4(){ //999단
		for(int k=2; k<=9; k++){
           for(int j=1; j<=9; j++){
			 for(int i=1; i<=9; i++) {
				System.out.println(k + " * " +j+" * "+i+" =  "+ k*j*i);
			 }
			 System.out.println();
		   }
		}
	}
	void m5(){ // 9999단 
		for(int l=2; l<=9; l++){
			for(int k=1; k<=9; k++){
			   for(int j=1; j<=9; j++){
				 for(int i=1; i<=9; i++) {
					System.out.println(
						l + " * " + k + " * " +j+" * "+i+" =  "+ l*k*j*i);
				 }
				 System.out.println();
			   }
			}
		}
	}
    void m6(){ //m5() 를 while문으로 
		int l=2;
		while(l<=9){
			for(int k=1; k<=9; k++){
			   for(int j=1; j<=9; j++){
				 for(int i=1; i<=9; i++) {
					System.out.println(
						l + " * " + k + " * " +j+" * "+i+" =  "+ l*k*j*i);
				 }
				 System.out.println();
			   }
			}

			l++;
		}
	}
	public static void main(String[] args) 
	{
		E e = new E();
		//e.m1();
		//e.m2();
		//e.m22();
		//e.m3();
		//e.m33();
		//e.m4();
		//e.m5();
		e.m6();
	}
}
