class D 
{
	
	void m1(){//1~100 ÇÕ
		int sum = 0;
		for (int i=1;i<=100 ;i++ )
		{
			//sum = sum +i;
			sum += i;	
		}
		System.out.println("sum: "+sum);
		
		
	
	}

	void m2(){//1~100 È¦¼öÀÇ ÇÕ
		int sum = 0;
		for (int i=1;i<=100 ;i+=2 )
		{
			//sum = sum +i;
			sum += i;	
		}
		System.out.println("sum: "+sum);
		
		
	
	}
	void m3(){//1~100 Â¦¼öÀÇ ÇÕ
		int sum = 0;
		for (int i=0;i<=100 ;i+=2 )
		{
			//sum = sum +i;
			sum += i;	
		}
		System.out.println("sum: "+sum);
		
	}

	void m4(){
		int jjsum = 0;
		int holsum = 0;
		for (int i=1; i<=100; i++)
		{
			if(i%1 == 0){
				jjsum += i;
			}else{
				holsum +=i;
			}
		}
		System.out.println("jjsum : " + jjsum + ", holsum: " + holsum 
			+ ", total: " + (jjsum + holsum));
	}	
	
	
	
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		d.m2();
		d.m3();
		d.m4();
	}
}
