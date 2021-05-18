class BB1{ //Outter 클래스

    class BB1Inner1{ //Inner 클래스 (객체소속)
        int a = 1;
        void m1(){
            System.out.println("BB1의 메소드 m1");
        }

    }

    static class BB1Inner2{ //Inner 클래스 (클래스소속)
        int b = 3;
        void m2(){
            System.out.println("BB2의 메소드 m2");
        }
    }
}

class BB1User{
    public static void main(String [] args) {
        // BB1 bb1 = new BB1();
        // BB1.BB1Inner1 inner1 = bb1.new BB1Inner1();
        
        BB1.BB1Inner1 inner1 = new BB1().new BB1Inner1();
        
        
        //외클.내클 변수 = new 외클.new 내클
        //클래스 BB1.BB1Inner1 을 BB1().new BB1Inner1(); 객체로 생성하여 
        //변수 inner1 에 저장
        
        System.out.println("생성된 inner의 a: "+inner1.a);
        inner1.m1();
        System.out.println("");

        
        
        BB1.BB1Inner2 inner2 = new BB1.BB1Inner2(); 
        //클래스 소속이기 때문에 클래스 이름으로 접근
        System.out.println("생성된 inner의 b: "+inner2.b);
        inner2.m2();
    }

}