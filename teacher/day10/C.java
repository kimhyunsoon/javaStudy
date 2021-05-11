class C {
	final int i = 0; //public static 
	//final C(){}
	final void m(){
		System.out.println("C의 m()");
	}
}

class CChild extends C {
	//void m(){ //오버라이딩 안됨
	//	System.out.println("CChild의 m()");
	//}
}
