public class CC {
    private int a = 5;
    private void m(){
        System.out.println("C�� m");
        
    }
    static int b = 0;
    static void mm(){
        System.out.println("C�� �޼ҵ� mm");
    }

    class CCInner1{ //static�� �ƴ� ����Ŭ���� (��ü �Ҽ�)
        int j = 7;
        void m1(){
            System.out.println("CC�̳�Ŭ����1�� m1");
        }
        void use(){
            m();
        }
    }

    static class CCInner2{ //static�� ����Ŭ���� (Ŭ���� �Ҽ�)
              
        int i = 3;
        static String name = "����";
        
        void m2(){
            System.out.println("CC�̳�Ŭ����2�� m2");
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
