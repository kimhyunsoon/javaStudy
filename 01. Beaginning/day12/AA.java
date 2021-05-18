interface AA { //접근제한자 중 public하고 default만 나올 수 있음
    
    int i=10;
    void m1(); //public abstract 생략
    static void m2(){ // public 생략
        System.out.println("m2");
    }
    default void m3(){
        System.out.println("m3");

    } //세상에 이건 접근제한자가 아니라 예약어였음
    //이미 내가 구현을 했다라고 하는 예약어였다.
}

class AAChild implements AA{ //껍데기 안을 채운다

    public void m1(){
        System.out.println("AAChild의 m1");
    }

    public void m3(){
    //자식클래스의 메소드는 부모클래스의 메소드보다 접근제한자의 범위가 커야 함
        System.out.println("AAChild의 m3");
    }
}


class AAUser{

    public static void main(String [] args) {
        AA a= new AAChild();
        System.out.println("a.i" +AA.i);
        a.m1();
        AA.m2();
        a.m3();
    }

}


