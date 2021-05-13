interface A1 { //접근제한자 중 public하고 default만 나올 수 있음
    
    final int i=10;
    public abstract void m1();
    static void m2(){
        System.out.println("m2");

    }
    default void m3(){
        System.out.println("m3");

    } //세상에 이건 접근제한자가 아니라 예약어였음
    //이미 내가 구현을 했다라고 하는 예약어였다.

    public static void main(String str) {
        
    }
}

class A1Child implements A1{ //껍데기 안을 채운다

    public void m1(){
        System.out.println("AChild의 m1");
    }

    public void m3(){
        System.out.println("AChild의 m3");
    }   

}


class A1User{

    public static void main(String [] args) {
        A1 a= new A1Child();
        System.out.println("a.i" +A1.i);
        a.m1();
        A1.m2();
        a.m3();
    }

}


