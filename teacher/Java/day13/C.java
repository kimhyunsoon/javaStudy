class C { 
	private int i = 0;
	private void m(){
		System.out.println("C의 m()");
	}
	private static int ii = 0;
	private static void mm(){
		System.out.println("C의 mm()");
	}

	private class CIn1 {  
		int i1 = 1;
		void m1(){
			System.out.println("CIn1의 m1()");
		}
	}
	static class CIn2 { 
		int i2 = 2;
		static int i22 = 3; 
		void m2(){
			System.out.println("CIn2의 m2()");
		}
		static void m22(){
			System.out.println("CIn2의 m22()");	
		}
		void use(){
			System.out.println("ii: " + ii);
			mm();
		}
		public static void main(String args[]){
			CIn2 in2 = new CIn2();
			System.out.println("i2: " + in2.i2);
			in2.m2();
			in2.use();
			System.out.println();

			System.out.println("i22: " + i22);
			m22();
		}
	}
}