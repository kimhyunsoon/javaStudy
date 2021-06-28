class EEEE{
    String room11[] = {"김현순", "이가은" };
    String room12[] = {"렌고쿠", "시노부"};
    String room21[] = {"에렌", "미카사"};
    String room22[] = {"바코쿠", "데쿠"};
    String room31[] = {"죠죠", "디오"};
    String room32[] = {"아나킨", "요다"}; 

    String grade1[][] = {room11, room12};
    String grade2[][] = {room21, room22};
    String grade3[][] = {room31, room32};
    
    String school[][][] = {grade1, grade2, grade3};

    void m1(){
        for(int i=0;i<school.length;i++){ //스쿨 배열의 요소 갯수만큼 실행

            for(int j=0;j<school[i].length;j++){ //grade 배열의 요소 갯수만큼 실행

                for(int k=0;k<school[i][j].length;k++){
                    System.out.println( (i+1) + "학년 "+(j+1)+"반 "+(k+1)+"번: "+school[i][j][k]);
                }
            }
        }
    }
    



    public static void main(String[] args) {
        EEEE e = new EEEE();
        e.m1();

        
    }

}