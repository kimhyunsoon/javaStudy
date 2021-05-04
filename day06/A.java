class A {
    String strs[]; //선언
    A(){
        strs = new String[4]; //생성

    }
    void in(){ // 초기화
        strs[0] = "봄";
        strs[1] = "여름";
        strs[2] = "가을";
        strs[3] = "겨울";


    }
    void out(){ //원할때 사용 
        System.out.println("strs[0]: "+strs[0]);
        System.out.println("strs[0]: "+strs[1]);
        System.out.println("strs[0]: "+strs[2]);
        System.out.println("strs[0]: "+strs[3]);

    }

    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
            
    }

    public static void main(String[] args) {
        A a = new A();
        a.in();
        a.out1();
    }
    
}
