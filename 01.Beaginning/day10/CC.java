final class CC {
    final int i = 0; 
    void m(){
        System.out.println("C의 m 실행");
    }
    
}

class CCKid extends CC{
    void m(){
        System.out.println("CChild의 m()");
        //The type CCKid cannot subclass the final class CC
        //클래스에 final 붙으면 자식 클래스를 못만든다. 따라서 실행 안됨
        
    }

}