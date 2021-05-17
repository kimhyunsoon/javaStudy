import java.io.*;
import java.util.*;

public class RPS {
    int totalRound; //�� ����
    int roundCount = 1;
    int win = 0;
    int draw = 0;
    int lose = 0;
    RPS(){
        play();
    }

    void inputRound(){
        Scanner s = new Scanner(System.in);
        pln("========���������� ����========");
        pln("���ϴ� ���� ���� �Է����ּ��� : ");

        totalRound = s.nextInt();
    }

    void play(){
        
        System.out.println("���� ���� ��");
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int users = null;
        int com = ran.nextInt(3);

        int user = sc.nextInt();


        if(user == 0){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ����!");
                    pln("draw!");    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ����!");
                    pln("��...��...�Ф�");    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("�̰��!!");    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }

        else if(user == 1){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ����!");
                    pln("�̰��!!");    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ����!");
                    pln("draw!");    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("��...��...�Ф�");    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }

        else if(user == 2){
            switch (com) {
                case 0:
                    pln("���İ�) ����!, ��) ��!");
                    pln("��...��...�Ф�");    
                    break;
                case 1:
                    pln("���İ�) ����!, ��) ��!");
                    pln("�̰��!!");    
                    break;
                case 2:
                    pln("���İ�) ��!, ��) ����!");
                    pln("draw!");    
                    break;
                default: pln("����, ����, ���� �Է����ּ���");
            }
        }
        
    }



    void pln(String str){
        System.out.println(str);
    }


    public static void main(String[] args) {
        new RPS();
    }
}
