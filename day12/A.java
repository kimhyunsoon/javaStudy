interface A { //���������� �� public�ϰ� default�� ���� �� ����
   //abstract�� �����Ǿ� ���� 
    int i=10; //���, public static final�� �����Ǿ� ����

    void m1(); //�߻�޼ҵ�, public abstract ����
    
    static void m2(){ //static �޼ҵ�
        System.out.println("m2");
    }
    default void m3(){ //default �޼ҵ�(�����)
        System.out.println("m3");
    }

    public static void main(String str) {
        
    }
}

class AChild implements A{ //������ ���� ä���
    //�������̽��� ��ü ���� ���: �Ϻ��� �ڽ�Ŭ������ ����� ��ü ���� �� ����ȯ�Ͽ� ����

    public void m1(){
        System.out.println("AChild�� m1");
    }


}


class AUser{

    public static void main(String [] args) {
        A a= new AChild();
        System.out.println("A.i: " +A.i); //static �ڿ��� �������̽��� �̸����� ����
        a.m1();
        A.m2(); //static �޼ҵ� m2�� �������̽��� �̸����θ� ���� ����
        a.m3();
    }

}


