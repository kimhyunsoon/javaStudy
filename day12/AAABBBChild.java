class AAABBBChild implements AAA,BBB{ //AAA,BBB ���ÿ� ��ӹ��� AAABBBChild Ŭ����
    
    public void m1(){
        System.out.println("AAABBBChild m1()");
    }
    public void m4(){
        System.out.println("AAABBBChild m4()");
    }
}

class AAABBBUser{
    public static void main(String[] args) {
        AAABBBChild ab = new AAABBBChild();
        AAA aaa = ab; //A�� ����ȯ
        BBB bbb = ab; //B�� ����ȯ
        aaa.m1(); 
        AAA.m2(); 
        aaa.m3(); 
        bbb.m4();

        
    }
}
