import java.io.*;
import java.util.*;

public class Rsp {
    int totalRound;
    int roundCount = 1;
    int win = 0;
    int draw = 0;
    int lose = 0;
    Rsp(){
        inputRound();
        input();
    }
    void inputRound(){
        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("====== ���������� ���� ======");
        System.out.print("���� �ϽǷ���??? : ");
        

        if(!s.hasNextInt()) {
            s.next();
            System.out.println("");
            System.out.println("���� ���� 1~10 ������ ���ڷ� �Է����ּ���.");
            inputRound();
        } else {
            totalRound = s.nextInt();
            System.out.println("");
            if (totalRound == 0 || totalRound > 100 ){
                System.out.println("�ּ� 1���ӿ��� �ִ� 100���� ���� �����ؿ�..! �ٽ� �Է����ּ���.");
                inputRound();
            }
        }
    }
    void input(){
        if(roundCount < totalRound ) {
            Scanner s = new Scanner(System.in);
            System.out.println("");
            System.out.println("========= ROUND "+roundCount+"/"+totalRound+" =========");
            System.out.println("���� ���� : " + win+ "�� / "+ draw + "�� / " + lose + "��");
            System.out.println("");
            System.out.println("���İ�) �ȳ��� ����...! ����������!!!");
            System.out.println("");
            
            System.out.println("��) ������ ����..?");
            System.out.println("1. ����   2. ����   3. ��");
            System.out.print(":");
            String select = s.next();
            String select2 = select.trim();
            transInput(select);
        } else if (roundCount == totalRound) {
            Scanner s = new Scanner(System.in);
            System.out.println("");
            System.out.println("====== Final ROUND "+roundCount+"/"+totalRound+" ======");
            System.out.println("���� ���� : " + win+ "�� / "+ draw + "�� / " + lose + "��");
            System.out.println("");
            System.out.println("���İ�) �ȳ��� ����...! ����������!!!");
            System.out.println("");
            
            System.out.println("��) ������ ����..?");
            System.out.println("1. ����   2. ����   3. ��");
            System.out.print(":");
            String select = s.next();
            String select2 = select.trim();
            transInput(select);
        } else {
            System.out.println("");
            System.out.println("���� ���� : " + win+ "�� / "+ draw + "�� / " + lose + "��");
            if(win > lose){
                System.out.println(win-lose + "�� ���̷� ���İ��� �¸�...!!!");
            } else if (lose > win) {
                System.out.println(lose-win + "�� ���̷� ���İ��� �й�...�̤�");
            } else if (win == lose) {
                System.out.println("���ºο���...!!");
            }
        }
    }

    void transInput(String s){
        String myCard = "";
        HashMap<String, String> cardMap = new HashMap<>();
        cardMap.put("1", "����");
        cardMap.put("2", "����");
        cardMap.put("3", "��");
        cardMap.put("����", "����");
        cardMap.put("����", "����");
        cardMap.put("��", "��");


        if (cardMap.containsKey(s)) {
            myCard = cardMap.get(s);
            roundCount += 1;
            cpOutput(myCard);
        } else {
            System.out.println("");
            System.err.println("�߸� ���̾�� �Ф� �ٽ� �غ���!!");
            input();
        }
    }
    void cpOutput(String myCard){
        String cpCard ="";
        Random r = new Random();
        int k = r.nextInt(90);
        k += 1;
        if (k >= 1 && k < 30) {
            cpCard = "����";
        } else if (k >= 30 && k < 60) {
            cpCard = "����";
        } else if (k >= 60 && k < 90) {
            cpCard = "��";
        }
        System.out.println("");
        System.out.println("���İ�) " + cpCard + "..!!");
        System.out.println("��) " + myCard+ "!");
        resultAndRetry(myCard, cpCard);
    }
    void resultAndRetry(String myCard, String cpCard){
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("��������", "lose");
        resultMap.put("������", "win");
        resultMap.put("��������", "draw");
        resultMap.put("��������", "win");
        resultMap.put("������", "lose");
        resultMap.put("��������", "draw");
        resultMap.put("������", "lose");
        resultMap.put("������", "win");
        resultMap.put("����", "draw");

        String result = myCard+cpCard;
        System.out.println("");
        if (resultMap.get(result) == "win"){
            System.out.println("�̰��..!!");
            win += 1;
        } else if (resultMap.get(result) == "lose") {
            System.out.println("����.....�Ф�");
            lose += 1;
        } else if (resultMap.get(result) == "draw") {
            System.out.println("����ݾ�??!!");
            draw += 1;
        }
        
        System.out.println("=============================");
        System.out.println("");
        input();

    }

    public static void main(String[] args){
        Rsp rspGame = new Rsp();
    }
}