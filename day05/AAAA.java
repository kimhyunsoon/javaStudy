class AAAA{
    void m1(){
        aa:
        for(int j=0;j<3;j++){
            for(int i=0;i<5;i++){
                if(i==2) break aa;
                System.out.println("j: " + j + ", i: " + i);
            }System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
    
    }

    void m2(){
        bb:
        for(int j=0;j<3;j++){
            for(int i=0;i<5;i++){
                if(i==2) break bb;
                System.out.println("j: " + j + ", i: " + i);
            }System.out.println("���� for����");
        }System.out.println("�ٱ��� for����");
        
    }






    public static void main(String[] args){
        AAAA aaaa = new AAAA();
        aaaa.m1();
        aaaa.m2();
    }

}