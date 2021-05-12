abstract class D { //추상클래스
    // abstract int i; 변수에 붙을 수 없음
    // abstract D(); 생성자에도 붙을 수 없음. 오버라이딩 개념이 없기 때문에

    void m1(){ 
        System.out.println("일반메소드 m1");
    }
    abstract void m2(); //추상메소드
    
}

class DChild extends D{ 
    //추상클래스 객체는 완벽한 자식 클래스 객체 생성 후 형변환하여 생성한다
    void m2(){
        System.out.println("자식클래스의 m2");
    }
}

class DUser{
    public static void main(String[] args) {
        D d = new DChild();
        d.m1();
        d.m2();
        
    }
}
