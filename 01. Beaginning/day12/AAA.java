interface AAA {
    String name = "순이"; //상수
    void m1(); //abstract 메소드

    static void m2(){ //static 메소드
        System.out.println("m2");
    }

    default void m3(){
        System.out.println("m3");
    }
}

class AAAChild implements AAA{
    public void m1(){
        System.out.println("m1");
    }

    public void m2(){
        System.out.println("자식클래스의 m2");
    }
    public void m3(){
        System.out.println("자식클래스의 m3");
    }
}

class AAAUser {
    public static void main(String[] args) {

        AAA aaa = new AAAChild(); ///자식클래스를 사용해서 객체를 생성 후 형변환해서
        System.out.println("이름: "+AAA.name);
        aaa.m1();
        AAA.m2();
        aaa.m3();

    }
}
