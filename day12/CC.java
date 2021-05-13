class CCChild implements CC{
    public void m1(){
		System.out.println("CCChild m1()");
	}
	public void m4(){
		System.out.println("CCChild m4()");
	}
	public void m5(){
		System.out.println("CCChild m5()");
	}
}

class CCUser {
    public static void main(String[] args) {
        CCChild cc = CCChild();
        AA a = cc;
        BB b = cc;
        CC c = cc;

        System.out.println(cc.name);
        cc.m1();
        AA.m2();
        cc.m3();
        cc.m4();
        cc.m5();
        
    }
}
