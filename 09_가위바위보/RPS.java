import java.io.*;
import java.util.*;

public class RPS {
    int totalRound; //�� ����
    int roundCount = 1;
    int win = 0;
    int draw = 0;
    int lose = 0;
    RPS(){
        inputRound();
        play();
    }

    void inputRound(){
        Scanner s = new Scanner(System.in);
        pln("========���������� ����========");
        pln("���ϴ� ���� ���� �Է����ּ��� : ");

        totalRound = s.nextInt();
    }

    void play(){
        
        if(roundCount<=totalRound){
            System.out.println("���� ���� ��");
            Scanner sc = new Scanner(System.in);
            Random ran = new Random();

            int com = ran.nextInt(3);
            String user = sc.next();
            game(com,user);


            
        }
        else{
            System.out.println("��������: "+win+"�� "+draw+"�� "+lose+"��");
        }

        
    }

    void game(int com, String user){
        if(user.equals("����")){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ����!");
                    pln("draw!");
                    draw++;    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ����!");
                    pln("��...��...�Ф�");
                    lose++;    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("�̰��!!");
                    win++;    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }

        else if(user.equals("����")){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ����!");
                    pln("�̰��!!");
                    win++;    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ����!");
                    pln("draw!");
                    draw++;    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("��...��...�Ф�");
                    lose++;    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }

        else if(user.equals("��")){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ��!");
                    pln("��...��...�Ф�");
                    lose++;    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ��!");
                    pln("�̰��!!");
                    win++;    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("draw!");
                    draw++;    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }
        roundCount++;
        play();
    }



    void pln(String str){
        System.out.println(str);
    }


    public static void main(String[] args) {
        new RPS();
    }
}
