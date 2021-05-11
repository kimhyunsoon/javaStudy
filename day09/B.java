/* public class B {
    int[] arr = new int[5];

    void m1(){
        for(int i=0; i<=5; i++){ //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.m1();
    }
    
    
} */



class B{ //ArrayException 예외처리
    int[] arr = new int[5];

    void m1(){
        try {
            for(int i=0; i<=5; i++){ 
            arr[i] = i;
            System.out.println(arr[i]);
        }
            
        } catch (ArrayIndexOutOfBoundsException e) { 
            //java.lang.ArrayIndexOutOfBoundsException 상위클래스가 런타임. 실행할 때 오류
            //인덱스가 음수이거나 배열 크기보다 크거나 같다
            System.out.println(e);
            System.out.println("예외처리 부분");
        }
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        B b = new B();
        b.m1();
    }
}