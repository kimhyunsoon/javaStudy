class B2 { //Outter
	private int i = 0;
    private void m(){
        System.out.println("B? m()");
    }

	class B2In1 { //Inner 
		int i1 = 1;
		void m1(){
			System.out.println("BIn? m1()");
		}
        void use(){
            System.out.println("i: "+i);
            m();
        }
        
	}
	static class B2In2 { //Inner 
		int i2 = 2;
		void m2(){
			System.out.println("BIn? m2()");
		}
	}
}

class B2User
{
	public static void main(String args[]){
		B2.B2In1 in1 = new B2().new B2In1();
		System.out.println("in1.i1: " + in1.i1);
		in1.m1();
        in1.use();
		System.out.println();

		B2.B2In2 in2 = new B2.B2In2();
		System.out.println("in2.i2: " + in2.i2);
		in2.m2();
	}
}
