public class BB2 {

    private String name = "����";
    private void m(){
        System.out.println("BB1�� �޼ҵ�");
    }

    class BB2In1{
        int a = 1;
        void m1(){
            System.out.println("�̳�Ŭ����1�� �޼ҵ�");
        }
        void use(){
            System.out.println("name: "+name); //�ܺ�Ŭ������ ��� �̿� ����
            m(); //�ܺ�Ŭ������ �޼ҵ� �̿� ����
        }

    }

    static class BB2In2{ //Ŭ���� ����
        int b = 5;
        void m2(){
            System.out.println("�̳�Ŭ����2�� �޼ҵ�");
        }
        void use2(){
            System.out.println("name: "+name); 
            //static Ŭ���������� private ����� �̿����� ���ϴ� ������ ����!!
            
        }
    }
}

class BB2User{
    public static void main(String[] args) {
        BB2.BB2In1 inner1 = new BB2().new BB2In1();
        System.out.println("inner1.a: "+inner1.a);
        inner1.m1(); 
        inner1.use(); 

        BB2.BB2In2 inner2 = new BB2.BB2In2();
        System.out.println("inner2.b: "+inner2.b);
        inner2.use2();
        
    }
}


