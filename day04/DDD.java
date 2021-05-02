class DDD {
    void m1(){
        int i=0;
        while(i<=5){
            System.out.println(i+"+"+i+"="+(i+i));
            i++;
        }
        System.out.println("while¹® ³ª¿È");
    }
    void m2(){
        int i=0;
        do{
            System.out.println(i+"+"+i+"="+(i+i));
            i++;
        }while(i<=5);
        System.out.println("do while¹® ³ª¿È");
    }

    void m3(){
        for(int i=0;i<=5;i++){
            System.out.println(i+"+"+i+"="+(i+i));
        }System.out.println("for¹® ³ª¿È");
    }

    public static void main(String[] args){
        DDD d=new DDD();
        d.m1();
        d.m2();
        d.m3();
    }
}
