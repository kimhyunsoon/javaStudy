class DD{
    void m1(){
        int i=0; //�ʱ��
        while(i<10){ //���ǽ�
            System.out.println("no "+i);
            i++; //������


        }
        System.out.println("while�� ����");


    }
    
    void m2(){
        int i = 0; //�ʱ��
        do {
            System.out.println("no "+i);
            i++; //������
        }while(i<10); //���ǽ�
        System.out.println("do while�� ����");
    }

    void m3(){
        for(int i=0;i<10;i++){
            System.out.println("no "+i);
        }System.out.println("for�� ����");
    }


    public static void main(String[] args){
        DD d= new DD();
        d.m1();
        d.m2();
        d.m3();
    }



}
