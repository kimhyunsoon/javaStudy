class DDD {
    void m1(){ //1~100 ��
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println("1���� 100���� ��: "+sum);
    }

    void m2(){//¦�� ��
        int sum = 0;
        for(int i=0;i<=100;i+=2){
            sum+=i;
        }
        System.out.println("1���� 100���� ¦����: "+sum);
    }

    void m3(){//Ȧ�� ��
        int sum = 0;
        for(int i=1;i<=100;i+=2){
            sum+=i;
        }System.out.println("1���� 100���� Ȧ����: "+sum);
    }

    public static void main(String[] args){
        DDD d = new DDD();
        d.m1();
        d.m2();
        d.m3();
    }
}
