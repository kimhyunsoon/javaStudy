class EEE {
    String grade[] = {"1�г�", "2�г�", "3�г�"};
    String room[] = {"1��", "2��", "3��", "4��"};
    String num[] = {"1��", "2��", "3��", "4��", "5��" };

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
