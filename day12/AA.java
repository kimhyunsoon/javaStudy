interface A1 { //���������� �� public�ϰ� default�� ���� �� ����
    
    final int i=10;
    public abstract void m1();
    static void m2(){
        System.out.println("m2");

    }
    default void m3(){
        System.out.println("m3");

    } //���� �̰� ���������ڰ� �ƴ϶� ������
    //�̹� ���� ������ �ߴٶ�� �ϴ� ������.

    public static void main(String str) {
        
    }
}

class A1Child implements A1{ //������ ���� ä���

    public void m1(){
        System.out.println("AChild�� m1");
    }

    public void m3(){
        System.out.println("AChild�� m3");
    }   

}


class A1User{

    public static void main(String [] args) {
        A1 a= new A1Child();
        System.out.println("a.i" +A1.i);
        a.m1();
        A1.m2();
        a.m3();
    }

}


