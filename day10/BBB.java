class BBB {
    static int i; // 클래스 소유
    BBB(){

    }
    static void m1(){ 
        System.out.println("m1 실행");
        System.out.println(i);
        //static 메소드에서는 자원 접근 시 자신의 클래스 이름이 생략됨
    }
    
}

class BBBUser{

    public static void main(String[] args) {
        System.out.println("i: "+BBB.i); 
        BBB.m1();
        //static 자원에 접근할 때는 클래스 이름으로 접근 가능
        BBB bbb1 = new BBB();
        BBB bbb2 = new BBB();

        System.out.println("bbb1.i: "+bbb1.i);
        bbb1.i++;
        System.out.println("bbb2.i: "+bbb2.i);
        
    }
}
