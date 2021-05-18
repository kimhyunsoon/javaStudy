class AAAA {
    
    /* String strs[]; //선언
    A(){
        strs = new String[4]; //생성

    }*/
    
    String strs[] = new String[4]; //선언 및 생성

    void in(){//초기화
        strs[0] = "봄";
        strs[1] = "여름";
        strs[2] = "가을";
        strs[3] = "겨울";
    }

    void out(){
        for(int i=0; i<strs.length; i++){
            System.out.println("strs["+i+"]: "+strs[i]);
        }
    }

    public static void main(String[] args){
        AAAA a = new AAAA();
        a.in();
        a.out();
    }
    
}
