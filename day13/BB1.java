class BB1{ //Outter Ŭ����

    class BB1Inner1{ //Inner Ŭ���� (��ü�Ҽ�)
        int a = 1;
        void m1(){
            System.out.println("BB1�� �޼ҵ� m1");
        }

    }

    static class BB1Inner2{ //Inner Ŭ���� (Ŭ�����Ҽ�)
        int b = 3;
        void m2(){
            System.out.println("BB2�� �޼ҵ� m2");
        }
    }
}

class BB1User{
    public static void main(String [] args) {
        // BB1 bb1 = new BB1();
        // BB1.BB1Inner1 inner1 = bb1.new BB1Inner1();
        
        BB1.BB1Inner1 inner1 = new BB1().new BB1Inner1();
        
        
        //��Ŭ.��Ŭ ���� = new ��Ŭ.new ��Ŭ
        //Ŭ���� BB1.BB1Inner1 �� BB1().new BB1Inner1(); ��ü�� �����Ͽ� 
        //���� inner1 �� ����
        
        System.out.println("������ inner�� a: "+inner1.a);
        inner1.m1();
        System.out.println("");

        
        
        BB1.BB1Inner2 inner2 = new BB1.BB1Inner2(); 
        //Ŭ���� �Ҽ��̱� ������ Ŭ���� �̸����� ����
        System.out.println("������ inner�� b: "+inner2.b);
        inner2.m2();
    }

}