class D 
{
	void m1(){ //1~100 ШІМіЧе
		int sum = 0;
		for(int i=1; i<=100; i+=2){
			System.out.println("i : " + i);
			sum += i;
		}
		System.out.println("sum : " + sum);
	}
	void m2(){ //1~100 ТІЧе, ШІЧе, УбЧе 
		int jjsum = 0; 
		int holsum = 0;
		for(int i=1; i<=100; i++){
			if(i%2 == 0){
				jjsum += i;
			}else{
				holsum += i;
			}
		}
		System.out.println("jjsum : " + jjsum + ", holsum: " + holsum 
			+ ", total: " + (jjsum + holsum));
	}
	public static void main(String[] args) 
	{
		 D d = new D();
		 //d.m1();
		 d.m2();
	}
}
