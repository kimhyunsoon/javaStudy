interface A { //접근제한자 중 public하고 default만 나올 수 있음
   //abstract가 생략되어 있음 
    final int i=10; //public static final이 생략되어 있음
    public abstract void m1();
    static void m2(){
        System.out.println("m2");

    }
    default void m3(){
        System.out.println("m3");

    }

    public static void main(String str) {
        
    }
}

class AChild implements A{ //껍데기 안을 채운다

    public void m1(){
        System.out.println("AChild의 m1");
    }


}


class AUser{

    public static void main(String [] args) {
        A a= new AChild();
        System.out.println("a.i" +a.i);
        a.m1();
        A.m2();
        a.m3();
    }

}


