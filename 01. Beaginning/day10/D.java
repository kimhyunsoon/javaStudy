abstract class D { //�߻�Ŭ����
    // abstract int i; ������ ���� �� ����
    // abstract D(); �����ڿ��� ���� �� ����. �������̵� ������ ���� ������

    void m1(){ 
        System.out.println("�Ϲݸ޼ҵ� m1");
    }
    abstract void m2(); //�߻�޼ҵ�
    
}

class DChild extends D{ 
    //�߻�Ŭ���� ��ü�� �Ϻ��� �ڽ� Ŭ���� ��ü ���� �� ����ȯ�Ͽ� �����Ѵ�
    void m2(){
        System.out.println("�ڽ�Ŭ������ m2");
    }
}

class DUser{
    public static void main(String[] args) {
        D d = new DChild();
        d.m1();
        d.m2();
        
    }
}
