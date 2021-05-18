class AABBChild implements AA,BB { //AA,BB 동시에 상속 받음
    //자식클래스를 만들 때는 implements 예약어 사용

    public void m1(){
        System.out.println("AABBChild의 m1");
    }
    public void m4(){
        System.out.println("AABBChild의 m4");
    }

}

class AABBUser{
    public static void main(String[] args) {
        AABBChild ab = new AABBChild();
        ab.m1();
        AA.m2(); //static 메소드는 인터페이스 이름으로 접근
        ab.m3();
        ab.m4();

        
    }

}
