class C {
    final int i = 0; 
    final void m(){
        System.out.println("C의 m 실행");
    }
    
}

class CKid extends C{

    void m(){
        System.out.println("CChild의 m()");
    //Cannot override the final method from C
    //메소드에 final 붙으면 오버라이딩이 안됨
    }   


}
