class AAAA {
    
    /* String strs[]; //����
    A(){
        strs = new String[4]; //����

    }*/
    
    String strs[] = new String[4]; //���� �� ����

    void in(){//�ʱ�ȭ
        strs[0] = "��";
        strs[1] = "����";
        strs[2] = "����";
        strs[3] = "�ܿ�";
    }

    void out(){
        for(int i=0; i<strs.length; i++){
            System.out.println("strs["+i+"]: "+strs[i]);
        }
    }

    public static void main(String[] args){
        AAAA a = new AAAA();
        a.in();
        a.out();
    }
    
}
