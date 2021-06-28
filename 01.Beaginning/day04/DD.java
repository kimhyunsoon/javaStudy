class DD{
    void m1(){
        int i=0; //초기식
        while(i<10){ //조건식
            System.out.println("no "+i);
            i++; //증감식


        }
        System.out.println("while문 나옴");


    }
    
    void m2(){
        int i = 0; //초기식
        do {
            System.out.println("no "+i);
            i++; //증감식
        }while(i<10); //조건식
        System.out.println("do while문 나옴");
    }

    void m3(){
        for(int i=0;i<10;i++){
            System.out.println("no "+i);
        }System.out.println("for문 나옴");
    }


    public static void main(String[] args){
        DD d= new DD();
        d.m1();
        d.m2();
        d.m3();
    }



}
