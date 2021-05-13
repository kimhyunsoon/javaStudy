class CChild implements C{
    
    public void m1(){
        System.out.println("CChild의 m1");

    }
    public void m2(){
        System.out.println("CChild의 m2");
    }
    public void m3(){
        System.out.println("CChild의 m3");
    }
    public void m4(){
        System.out.println("CChild의 m4");
    }
    public void m5(){
        System.out.println("CChild의 m5");
    }

}


class CUser{

    public static void main(String[] args) {

        CChild cc = new CChild();
        A a = cc;
        B b = cc;
        C c = cc;

        System.out.println(C.i);
        c.m1(); A.m2(); c.m3();c.m4();c.m5();
        
    }

}
