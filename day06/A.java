class A {
    String strs[]; //����
    A(){
        strs = new String[4]; //����

    }
    void in(){ // �ʱ�ȭ
        strs[0] = "��";
        strs[1] = "����";
        strs[2] = "����";
        strs[3] = "�ܿ�";


    }
    void out(){ //���Ҷ� ��� 
        System.out.println("strs[0]: "+strs[0]);
        System.out.println("strs[0]: "+strs[1]);
        System.out.println("strs[0]: "+strs[2]);
        System.out.println("strs[0]: "+strs[3]);

    }

    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
            
    }

    public static void main(String[] args) {
        A a = new A();
        a.in();
        a.out1();
    }
    
}
