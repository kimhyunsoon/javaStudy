class EEEE{
    String room11[] = {"������", "�̰���" };
    String room12[] = {"������", "�ó��"};
    String room21[] = {"����", "��ī��"};
    String room22[] = {"������", "����"};
    String room31[] = {"����", "���"};
    String room32[] = {"�Ƴ�Ų", "���"}; 

    String grade1[][] = {room11, room12};
    String grade2[][] = {room21, room22};
    String grade3[][] = {room31, room32};
    
    String school[][][] = {grade1, grade2, grade3};

    void m1(){
        for(int i=0;i<school.length;i++){ //���� �迭�� ��� ������ŭ ����

            for(int j=0;j<school[i].length;j++){ //grade �迭�� ��� ������ŭ ����

                for(int k=0;k<school[i][j].length;k++){
                    System.out.println( (i+1) + "�г� "+(j+1)+"�� "+(k+1)+"��: "+school[i][j][k]);
                }
            }
        }
    }
    



    public static void main(String[] args) {
        EEEE e = new EEEE();
        e.m1();

        
    }

}