class ABChild implements A, B
{
	public void m1(){
		System.out.println("ABChild m1()");
	}
	public void m4(){
		System.out.println("ABChild m4()");
	}
}

class ABUser {
	public static void main(String[] args) {
		ABChild ab = new ABChild();
        /*ab.m1(); A.m2();ab.m3();
		ab.m4();*/
		A a = ab; //A�� ����ȯ 
		B b = ab; //B�� ����ȯ 
		a.m1(); A.m2(); a.m3();
		b.m4();
	}
}
