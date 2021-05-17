import java.io.*;
import java.util.*;

public class Rsp {
    Rsp(){
        input();
    }
    void input(){
        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("���İ�) �ȳ��� ����...! ����������!!!");
        System.out.println("");
        
        System.out.println("==== � �� ���Ƿ���?? ====");
        System.out.println("1. ����   2. ����   3. ��");
        System.out.print(":");
        String select = s.next();
        String select2 = select.trim();
        transInput(select);
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
        resultMap.put("��������", "����......�Ф�");
        resultMap.put("������", "�̰��...! ��ȣ!!");
        resultMap.put("��������", "�̰��...! ��ȣ!!");
        resultMap.put("������", "����......�Ф�");
        resultMap.put("������", "����......�Ф�");
        resultMap.put("������", "�̰��...! ��ȣ!!");

        if(cpCard == myCard){
            System.out.println("����..!! ���Ǵ� ����!!!");
            System.out.println("============================");
            input();
        }else {
            String result = myCard+cpCard;
            System.out.println("");
            System.out.println(resultMap.get(result));
            System.out.println("============================");
        }

    }

    public static void main(String[] args){
        Rsp rspGame = new Rsp();
    }
}