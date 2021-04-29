class C { //적금으로 얼마나 벌었는가
    int 국민은행 = 500000;
    int 웰컴뱅크 = 300000;
    int 우리은행 = 100000;
    double 소득세 = 0.165f;

    void cal1(){ //국민은행 이자계산(단리)
        double 이자율 = 0.05; 
        int 일년저금액 = 국민은행*12;
        double 이자 = 국민은행*이자율*12;
        double 세전금액 = 일년저금액+이자;
        String money = String.format("%,d", Math.round(세전금액-세전금액*소득세));
        System.out.println("만기환급금액: " + money + "원");
    }

    public static void main(String[] args) {
        C c= new C();

        c.cal1();
    }

}