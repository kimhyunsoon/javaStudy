interface A { //abstract ����
	int i = 10;	//public static final ���� 

    void m1(); //public abstract ����

    static void m2(){ //public ����
		System.out.println("m2()");
	} 
	default void m3(){ //public ����
		System.out.println("m3()");
	}
}
class AChild implements A {
	public void m1(){
		System.out.println("AChild m1()");
	}
	public void m3(){
	}
}
class AUser {
	public static void main(String[] args) 
	{
		A a = new AChild();
		System.out.println("a.i: " + A.i);
		a.m1();
		A.m2();
		a.m3();
	}
}