class ABChild implements A,B{ //A,B 동시에 상속받음

    public void m1(){
        System.out.println("m1");
    }
    public void m4(){
        System.out.println("m4");
    }
}


class ABUser{
    public static void main(String[] args) {
        ABChild ab = new ABChild();
        ab.m1();
        A.m2();
        ab.m3();
        ab.m4();

        A a = ab; //A로 형변환
        B b = ab; //A로 형변환
        a.m1();
        A.m2();
        a.m3();
        b.m4(); //m4 메소드는 B에 있다
        
    }

}