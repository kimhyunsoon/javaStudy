public class AA {
    String strs[] = new String[4]; //���� �� ����

    void in(){ // �ʱ�ȭ
        strs[0] = "��ħ";
        strs[1] = "����";
        strs[2] = "����";
        strs[3] = "�߽�";
    }

    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
            
    }

    public static void main(String[] args) {
        AA a = new AA();
        a.in();
        a.out1();
    }
    
}
    

