class ABChild implements A,B{ //A,B ���ÿ� ��ӹ���

    public void m1(){
        System.out.println("m1");
    }
    public void m4(){
        System.out.println("m4");
    }
}


class ABUser{
    public static void main(String[] args) {
        ABChild ab = new ABChild();
        ab.m1();
        A.m2();
        ab.m3();
        ab.m4();

        A a = ab; //A�� ����ȯ
        B b = ab; //A�� ����ȯ
        a.m1();
        A.m2();
        a.m3();
        b.m4(); //m4 �޼ҵ�� B�� �ִ�
        
    }

}