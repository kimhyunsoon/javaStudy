class AAAAA {
    int j=4;
    String strs[] = new String[j];

    void in(){ //�ʱ�ȭ
        strs[0] = "������ ���ַ�";
        strs[1] = "��̿�ī ����";
        strs[2] = "ī���� ź����";
        strs[3] = "���ݿ� �ó��";

    }
    
    void out(){
        for(int i=0;i<strs.length;i++){
            System.out.println("strs["+i+"]: "+strs[i]);
        }

    }

    public static void main(String[] args){
        AAAAA a = new AAAAA();
        a.in();
        a.out();
    }
}
