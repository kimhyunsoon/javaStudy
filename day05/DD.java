class DD {

    void m1(){ //1~100 ÇÕ
        int sum = 0;
        for(int i=1; i<=100; i++){
            //sum = sum + i;
            sum +=i;
        }
        System.out.println("sum: "+sum);
    }

    void m2(){ // 1~100 Â¦¼ö ÇÕ
        int sum = 0;
        for(int i= 0; i<=100; i+=2){
            sum += i;
        }
        System.out.println("Â¦¼ö sum: "+sum);
    }

    void m3(){ //1~100 È¦¼ö ÇÕ
        int sum=0;
        for(int i=1; i<100 ; i+=2){
            sum += i;
        }
        System.out.println("È¦¼ö sum: "+sum);
    }

    public static void main(String[] args){
        DD d = new DD();
        d.m1();
        d.m2();
        d.m3();
    }


}
