class BBB{ //�ܺ�Ŭ���� class�� public, default
    private String fit = "���";

    class BBBinner1 {
        String fit1 = "��ü";
        void m1(){
            System.out.println(fit+"�ϴ� ��");
        }
    }

    static class BBBinner2{
        String fit2 = "�����";
        void m2(){
            System.out.println(fit2+"�ϴ� ��");
        }

    }
}

class BBBUser{

    public static void main(String[] args) { 
        // BB1 bb1 = new BB1();
        // BB1.BB1Inner1 inner1 = bb1.new BB1Inner1();
        BBB.BBBinner1 in1 = new BBB().new BBBinner1(); //static Ŭ������ �ƴ� ��
        in1.m1();
        
        BBB.BBBinner2 in2 = new BBB.BBBinner2(); //static Ŭ������ ��
        in2.m2();


    }
}