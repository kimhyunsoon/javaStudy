final class CC {
    final int i = 0; 
    void m(){
        System.out.println("C�� m ����");
    }
    
}

class CCKid extends CC{
    void m(){
        System.out.println("CChild�� m()");
        //The type CCKid cannot subclass the final class CC
        //Ŭ������ final ������ �ڽ� Ŭ������ �������. ���� ���� �ȵ�
        
    }

}