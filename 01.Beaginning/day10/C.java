class C {
    final int i = 0; 
    final void m(){
        System.out.println("C�� m ����");
    }
    
}

class CKid extends C{

    void m(){
        System.out.println("CChild�� m()");
    //Cannot override the final method from C
    //�޼ҵ忡 final ������ �������̵��� �ȵ�
    }   


}
