class BBB {
    static int i; // Ŭ���� ����
    BBB(){

    }
    static void m1(){ 
        System.out.println("m1 ����");
        System.out.println(i);
        //static �޼ҵ忡���� �ڿ� ���� �� �ڽ��� Ŭ���� �̸��� ������
    }
    
}

class BBBUser{

    public static void main(String[] args) {
        System.out.println("i: "+BBB.i); 
        BBB.m1();
        //static �ڿ��� ������ ���� Ŭ���� �̸����� ���� ����
        BBB bbb1 = new BBB();
        BBB bbb2 = new BBB();

        System.out.println("bbb1.i: "+bbb1.i);
        bbb1.i++;
        System.out.println("bbb2.i: "+bbb2.i);
        
    }
}
