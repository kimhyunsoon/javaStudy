class AA {
    void m1(){
        aa:
        for(int j=0; j<2; j++){
            for(int i=0; i<5; i++){
                if(i==3) break aa;
                System.out.println("j: " + j + ", i: " + i);
            }
            System.out.println("¾ÈÂÊ for³ª¿È");
        }System.out.println("¹Ù±ùÂÊ for³ª¿È");
    }
    void m2(){
        bb:
        for(int j=0 ; j<2; j++){
            for(int i=0; i<5; i++){
                if(i==3) continue bb;
                System.out.println("j: " + j + ", i: " + i);
            }
            System.out.println("¾ÈÂÊ for³ª¿È");
        }System.out.println("¹Ù±ùÂÊ for³ª¿È");
    }

    public static void main(String[] args){
        AA aa = new AA();
        aa.m1();
        aa.m2();


    }
}
