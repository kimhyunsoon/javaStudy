interface A { //���������� �� public�ϰ� default�� ���� �� ����
   //abstract�� �����Ǿ� ���� 
    final int i=10; //public static final�� �����Ǿ� ����
    public abstract void m1();
    static void m2(){
        System.out.println("m2");

    }
    default void m3(){
        System.out.println("m3");

    }

    public static void main(String str) {
        
    }
}

class AChild implements A{ //������ ���� ä���

    public void m1(){
        System.out.println("AChild�� m1");
    }


}


class AUser{

    public static void main(String [] args) {
        A a= new AChild();
        System.out.println("a.i" +a.i);
        a.m1();
        A.m2();
        a.m3();
    }

}


