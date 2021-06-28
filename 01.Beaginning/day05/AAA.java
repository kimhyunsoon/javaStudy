class AAA {
    void m1(){
        aa:
        for(int j=0; j<3 ; j++){
            for(int i=0; i<5 ; i++){
                if(i==2) break aa;
                System.out.println("j: "+j+",i: "+i);
            }
            System.out.println("¾ÈÂÊ for¹® ³ª¿È");
        }
        System.out.println("¹Ù±ùÂÊ for¹® ³ª¿È");
    }

    void m2(){
        bb:
        for(int j=0; j<4; j++){
            for(int i=0; i<5; i++){
                if(i==3) continue bb;
                System.out.println("j: "+j+",i: "+i);
            }
            System.out.println("¾ÈÂÊ for¹® ³ª¿È");
        }
        System.out.println("¹Ù±ùÂÊ for¹® ³ª¿È");
    }

    public static void main (String[] args){
        AAA aaa= new AAA();
        aaa.m1();
        aaa.m2();
        

    }
}
