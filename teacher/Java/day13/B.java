class B { //Outter
	int i = 0;

	class BIn1 { //Inner 
		int i1 = 1;
		void m1(){
			System.out.println("BIn1ÀÇ m1()");
		}
	}
	static class BIn2 { //Inner 
		int i2 = 2;
		void m2(){
			System.out.println("BIn2ÀÇ m2()");
		}
	}
}

class BUser
{
	public static void main(String args[]){
		B.BIn1 in1 = new B().new BIn1();
		System.out.println("in1.i1: " + in1.i1);
		in1.m1();
		System.out.println();

		B.BIn2 in2 = new B.BIn2();
		System.out.println("in2.i2: " + in2.i2);
		in2.m2();
	}
}
