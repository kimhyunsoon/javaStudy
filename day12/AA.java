interface AA { //���������� �� public�ϰ� default�� ���� �� ����
    
    int i=10;
    void m1(); //public abstract ����
    static void m2(){ // public ����
        System.out.println("m2");
    }
    default void m3(){
        System.out.println("m3");

    } //���� �̰� ���������ڰ� �ƴ϶� ������
    //�̹� ���� ������ �ߴٶ�� �ϴ� ������.
}

class AAChild implements AA{ //������ ���� ä���

    public void m1(){
        System.out.println("AAChild�� m1");
    }

    public void m3(){
    //�ڽ�Ŭ������ �޼ҵ�� �θ�Ŭ������ �޼ҵ庸�� ������������ ������ Ŀ�� ��
        System.out.println("AAChild�� m3");
    }
}


class AAUser{

    public static void main(String [] args) {
        AA a= new AAChild();
        System.out.println("a.i" +AA.i);
        a.m1();
        AA.m2();
        a.m3();
    }

}


