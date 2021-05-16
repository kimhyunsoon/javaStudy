class BBB{ //외부클래스 class는 public, default
    private String fit = "어깨";

    class BBBinner1 {
        String fit1 = "하체";
        void m1(){
            System.out.println(fit+"하는 날");
        }
    }

    static class BBBinner2{
        String fit2 = "유산소";
        void m2(){
            System.out.println(fit2+"하는 날");
        }

    }
}

class BBBUser{

    public static void main(String[] args) { 
        // BB1 bb1 = new BB1();
        // BB1.BB1Inner1 inner1 = bb1.new BB1Inner1();
        BBB.BBBinner1 in1 = new BBB().new BBBinner1(); //static 클래스가 아닐 때
        in1.m1();
        
        BBB.BBBinner2 in2 = new BBB.BBBinner2(); //static 클래스일 때
        in2.m2();


    }
}