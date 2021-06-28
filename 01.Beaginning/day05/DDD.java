class DDD {
    void m1(){ //1~100 합
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println("1부터 100까지 합: "+sum);
    }

    void m2(){//짝수 합
        int sum = 0;
        for(int i=0;i<=100;i+=2){
            sum+=i;
        }
        System.out.println("1부터 100까지 짝수합: "+sum);
    }

    void m3(){//홀수 합
        int sum = 0;
        for(int i=1;i<=100;i+=2){
            sum+=i;
        }System.out.println("1부터 100까지 홀수합: "+sum);
    }

    public static void main(String[] args){
        DDD d = new DDD();
        d.m1();
        d.m2();
        d.m3();
    }
}
