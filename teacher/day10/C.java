class C {
	final int i = 0; //public static 
	//final C(){}
	final void m(){
		System.out.println("C�� m()");
	}
}

class CChild extends C {
	//void m(){ //�������̵� �ȵ�
	//	System.out.println("CChild�� m()");
	//}
}
