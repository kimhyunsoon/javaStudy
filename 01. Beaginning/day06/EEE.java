class EEE {
    String grade[] = {"1학년", "2학년", "3학년"};
    String room[] = {"1반", "2반", "3반", "4반"};
    String num[] = {"1번", "2번", "3번", "4번", "5번" };

    String student[][]= {grade, room, num};
    void m(){//
        for(int i=0; i<student.length;i++){
            for(int j=0;j<student[i].length;j++){
                
                    System.out.println(student[i][j]);
                
            }
        }

    }

    public static void main(String[] args){
        EEE e = new EEE();
        e.m();
    }

    
}
