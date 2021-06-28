class AAAAA {
    int j=4;
    String strs[] = new String[j];

    void in(){ //초기화
        strs[0] = "렌고쿠 쿄주로";
        strs[1] = "토미오카 기유";
        strs[2] = "카마도 탄지로";
        strs[3] = "코쵸우 시노부";

    }
    
    void out(){
        for(int i=0;i<strs.length;i++){
            System.out.println("strs["+i+"]: "+strs[i]);
        }

    }

    public static void main(String[] args){
        AAAAA a = new AAAAA();
        a.in();
        a.out();
    }
}
