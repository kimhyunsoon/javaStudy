interface AAA {
    String name = "����"; //���
    void m1(); //abstract �޼ҵ�

    static void m2(){ //static �޼ҵ�
        System.out.println("m2");
    }

    default void m3(){
        System.out.println("m3");
    }
}

class AAAChild implements AAA{
    public void m1(){
        System.out.println("m1");
    }

    public void m2(){
        System.out.println("�ڽ�Ŭ������ m2");
    }
    public void m3(){
        System.out.println("�ڽ�Ŭ������ m3");
    }
}

class AAAUser {
    public static void main(String[] args) {

        AAA aaa = new AAAChild(); ///�ڽ�Ŭ������ ����ؼ� ��ü�� ���� �� ����ȯ�ؼ�
        System.out.println("�̸�: "+AAA.name);
        aaa.m1();
        AAA.m2();
        aaa.m3();

    }
}
