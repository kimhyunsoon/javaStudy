class EEE {
    void m1(int num1, int num2){ // void m1 �� ���� �Ű�����(int) num1, num2
        for(int i=1;i<=num2;i++){ // 1���� num2 ���� �ݺ���
            System.out.println(num1+"*"+i+"="+num1*i); // num1 * i ���
        }
    }
    public static void main(String[] args){
        EEE eee = new EEE();
        eee.m1(34,14);
    }
}
