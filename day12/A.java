interface A { //접근제한자 중 public하고 default만 나올 수 있음
   //abstract가 생략되어 있음 
    int i=10; //상수, public static final이 생략되어 있음

    void m1(); //추상메소드, public abstract 생략
    
    static void m2(){ //static 메소드
        System.out.println("m2");
    }
    default void m3(){ //default 메소드(예약어)
        System.out.println("m3");
    }

    public static void main(String str) {
        
    }
}

class AChild implements A{ //껍데기 안을 채운다
    //인터페이스의 객체 생성 방법: 완벽한 자식클래스를 만들어 객체 생성 후 형변환하여 만듬

    public void m1(){
        System.out.println("AChild의 m1");
    }


}


class AUser{

    public static void main(String [] args) {
        A a= new AChild();
        System.out.println("A.i: " +A.i); //static 자원은 인터페이스의 이름으로 접근
        a.m1();
        A.m2(); //static 메소드 m2도 인터페이스의 이름으로만 접근 가능
        a.m3();
    }

}


