class AABBChild implements AA,BB { //AA,BB ���ÿ� ��� ����
    //�ڽ�Ŭ������ ���� ���� implements ����� ���

    public void m1(){
        System.out.println("AABBChild�� m1");
    }
    public void m4(){
        System.out.println("AABBChild�� m4");
    }

}

class AABBUser{
    public static void main(String[] args) {
        AABBChild ab = new AABBChild();
        ab.m1();
        AA.m2(); //static �޼ҵ�� �������̽� �̸����� ����
        ab.m3();
        ab.m4();

        
    }

}
