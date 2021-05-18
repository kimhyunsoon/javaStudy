class EEE {
    void m1(int num1, int num2){ // void m1 에 대한 매개변수(int) num1, num2
        for(int i=1;i<=num2;i++){ // 1부터 num2 까지 반복함
            System.out.println(num1+"*"+i+"="+num1*i); // num1 * i 출력
        }
    }
    public static void main(String[] args){
        EEE eee = new EEE();
        eee.m1(34,14);
    }
}
