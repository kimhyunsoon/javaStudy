public class AA {
    String strs[] = new String[4]; //선언 및 생성

    void in(){ // 초기화
        strs[0] = "아침";
        strs[1] = "점심";
        strs[2] = "저녁";
        strs[3] = "야식";
    }

    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
            
    }

    public static void main(String[] args) {
        AA a = new AA();
        a.in();
        a.out1();
    }
    
}
    

