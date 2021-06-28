class C { //Outter
	private int i = 0;
    private void m(){
        System.out.println("C의 m()");
    }

	class CIn1 { //Inner 
		int i1 = 1;
		void m1(){
			System.out.println("CIn1의 m1()");
		}
        public static void main(String[] args) {
            
        } //static이 아닌 내부클래스는 main을 만들 수 없다
        //The method main cannot be declared static; 
        //static methods can only be declared in a static or top level type
        
	}
	static class CIn2 { //Inner 
		int i2 = 2;
		void m2(){
			System.out.println("BIn의 m2()");
		}
        public static void main(String[] args) {
            
        } 

	}
}
