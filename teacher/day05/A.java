class A 
{
	void m1(){
		aa:
		for(int j=0; j<2; j++){
			for(int i=0; i<5; i++){
				if(i==3) break aa;
				System.out.println("j: " + j + ", i: " + i);
			}//(1)
			System.out.println("¾ÈÂÊ for³ª¿È");
		}//(2) 
		System.out.println("¹Ù±ùÂÊ for³ª¿È");
	}
	void m2(){
		bb:
		for(int j=0; j<2; j++){
			for(int i=0; i<5; i++){
				if(i==2) continue bb;
				System.out.println("j: " + j + ", i: " + i);
			}
			System.out.println("¾ÈÂÊ for³ª¿È");
		}
		System.out.println("¹Ù±ùÂÊ for³ª¿È");
	}
	public static void main(String[] args) 
	{
		A a= new A();
		//a.m1();
		a.m2();
	}
}
