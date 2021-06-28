class B {
    
    
    String strs[] = {"쇼크","퓨전","아웃로즈","드래곤즈"}; //선언및 생성
    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
     }

    public static void main(String[] args) {
        B b = new B();
        
        b.out1();
    }
}


