class AA {
    void m1(){
        aa:
        for(int j=0; j<2; j++){
            for(int i=0; i<5; i++){
                if(i==3) break aa;
                System.out.println("j: " + j + ", i: " + i);
            }
            System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
    }
    void m2(){
        bb:
        for(int j=0 ; j<2; j++){
            for(int i=0; i<5; i++){
                if(i==3) continue bb;
                System.out.println("j: " + j + ", i: " + i);
            }
            System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
    }

    public static void main(String[] args){
        AA aa = new AA();
        aa.m1();
        aa.m2();


    }
}
