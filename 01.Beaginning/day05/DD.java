class DD {

    void m1(){ //1~100 ��
        int sum = 0;
        for(int i=1; i<=100; i++){
            //sum = sum + i;
            sum +=i;
        }
        System.out.println("sum: "+sum);
    }

    void m2(){ // 1~100 ¦�� ��
        int sum = 0;
        for(int i= 0; i<=100; i+=2){
            sum += i;
        }
        System.out.println("¦�� sum: "+sum);
    }

    void m3(){ //1~100 Ȧ�� ��
        int sum=0;
        for(int i=1; i<100 ; i+=2){
            sum += i;
        }
        System.out.println("Ȧ�� sum: "+sum);
    }

    public static void main(String[] args){
        DD d = new DD();
        d.m1();
        d.m2();
        d.m3();
    }


}
