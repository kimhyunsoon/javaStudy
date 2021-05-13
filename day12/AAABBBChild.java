class AAABBBChild implements AAA,BBB{ //AAA,BBB 동시에 상속받은 AAABBBChild 클래스
    
    public void m1(){
        System.out.println("AAABBBChild m1()");
    }
    public void m4(){
        System.out.println("AAABBBChild m4()");
    }
}

class AAABBBUser{
    public static void main(String[] args) {
        AAABBBChild ab = new AAABBBChild();
        AAA aaa = ab; //A로 형변환
        BBB bbb = ab; //B로 형변환
        aaa.m1(); 
        AAA.m2(); 
        aaa.m3(); 
        bbb.m4();

        
    }
}
