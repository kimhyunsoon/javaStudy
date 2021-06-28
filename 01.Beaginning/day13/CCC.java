public class CCC {
    private String name = "김현순";
    private void m(){
        System.out.println("CCC의 m");
    }
    
    static String name1 = "이가은";
    static void mm(){
        System.out.println("CCC의 mm");
    }

    class CCCInner1{
        String name2 = "똥이";
        void m1(){
            System.out.println("CCC non-static 이너클래스");
        }
    }

    static class CCCInner2{
        int a = 5;
        static String name3 = "돈생님";
        
        void m2(){
            System.out.println("CCC static 이너클래스"+a);
            
        }
        static void m22(){
            System.out.println(name3+"은 뚱뚱합니다");
        }
        
        void use(){
            System.out.println(name1+"은 날씬합니다");
            mm();
        }

        public static void main(String[] args) {
            CCCInner2 var = new CCCInner2();
            System.out.println(var.a);
            var.m2();
            var.use();
            
        }
    }

}
