class AAAAA {
    void m1(){
        aa:
        for(int j=0;j<4;j++){
            for(int i=0;i<4;i++){
                if(i==2) break aa;
                System.out.println("i: "+i+", j: "+j);
            }
            System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
    }

    void m2(){
        bb:
        for(int j=0;j<4;j++){
            for(int i=0;i<4;i++){
                if(i==2) continue bb;
                System.out.println("i: "+i+", j: "+j);
            }
            System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
    }

    public static void main(String[] args){
        AAAAA a = new AAAAA();
        a.m1();
        a.m2();
    }
    
}
