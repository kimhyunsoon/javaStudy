public class CCC {
    private String name = "������";
    private void m(){
        System.out.println("CCC�� m");
    }
    
    static String name1 = "�̰���";
    static void mm(){
        System.out.println("CCC�� mm");
    }

    class CCCInner1{
        String name2 = "����";
        void m1(){
            System.out.println("CCC non-static �̳�Ŭ����");
        }
    }

    static class CCCInner2{
        int a = 5;
        static String name3 = "������";
        
        void m2(){
            System.out.println("CCC static �̳�Ŭ����"+a);
            
        }
        static void m22(){
            System.out.println(name3+"�� �׶��մϴ�");
        }
        
        void use(){
            System.out.println(name1+"�� �����մϴ�");
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
