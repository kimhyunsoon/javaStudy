class B1 { //Outter

	class B1In1 { //Inner 
		int i1 = 1;
		void m1(){
			System.out.println("BIn1의 메소드 m1()");
		}
	}
	static class B1In2 { //Inner 
		int i2 = 2;
		void m2(){
			System.out.println("BIn2의 메소드 m2()");
		}
	}
}

class B1User
{
	public static void main(String args[]){
		B1.B1In1 in1 = new B1().new B1In1();
		System.out.println("in1.i1: " + in1.i1);
		in1.m1();
		System.out.println();

		B1.B1In2 in2 = new B1.B1In2();
		System.out.println("in2.i2: " + in2.i2);
		in2.m2();
	}
}
