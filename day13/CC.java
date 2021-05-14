public class CC {
    private int a = 5;
    private void m(){
        System.out.println("C의 m");
        
    }
    static int b = 0;
    static void mm(){
        System.out.println("C의 메소드 mm");
    }

    class CCInner1{ //static이 아닌 내부클래스 (객체 소속)
        int j = 7;
        void m1(){
            System.out.println("CC이너클래스1의 m1");
        }
        void use(){
            m();
        }
    }

    static class CCInner2{ //static인 내부클래스 (클래스 소속)
              
        int i = 3;
        static String name = "가은";
        
        void m2(){
            System.out.println("CC이너클래스2의 m2");
        }

        void m22(){
            System.out.println(i);
        }
        
        void use2(){
            System.out.println(b);
            mm();
        }
        
        
        
        public static void main(String[] args) {
            CCInner2 var2 = new CCInner2(); 
            System.out.println(var2.i);
            var2.m2();
            var2.m22();
            var2.use2();
            
            
            System.out.println("");

        }

    }
    
}
