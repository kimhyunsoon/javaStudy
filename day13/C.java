class C { //Outter
	private int i = 0;
    private void m(){
        System.out.println("C�� m()");
    }

	class CIn1 { //Inner 
		int i1 = 1;
		void m1(){
			System.out.println("CIn1�� m1()");
		}
        public static void main(String[] args) {
            
        } //static�� �ƴ� ����Ŭ������ main�� ���� �� ����
        //The method main cannot be declared static; 
        //static methods can only be declared in a static or top level type
        
	}
	static class CIn2 { //Inner 
		int i2 = 2;
		void m2(){
			System.out.println("BIn�� m2()");
		}
        public static void main(String[] args) {
            
        } 

	}
}
