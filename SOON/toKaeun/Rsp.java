import java.io.*;
import java.util.*;

public class Rsp {
    Rsp(){
        input();
    }
    void input(){
        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("알파고) 안내면 진다...! 가위바위보!!!");
        System.out.println("");
        
        System.out.println("==== 어떤 걸 내실래요?? ====");
        System.out.println("1. 가위   2. 바위   3. 보");
        System.out.print(":");
        String select = s.next();
        String select2 = select.trim();
        transInput(select);
    }

    void transInput(String s){
        String myCard = "";
        HashMap<String, String> cardMap = new HashMap<>();
        cardMap.put("1", "가위");
        cardMap.put("2", "바위");
        cardMap.put("3", "보");
        cardMap.put("가위", "가위");
        cardMap.put("바위", "바위");
        cardMap.put("보", "보");


        if (cardMap.containsKey(s)) {
            myCard = cardMap.get(s);
            cpOutput(myCard);
        } else {
            System.out.println("");
            System.err.println("잘못 내셨어요 ㅠㅠ 다시 해보죠!!");
            input();
        }
    }
    void cpOutput(String myCard){
        String cpCard ="";
        Random r = new Random();
        int k = r.nextInt(90);
        k += 1;
        if (k >= 1 && k < 30) {
            cpCard = "가위";
        } else if (k >= 30 && k < 60) {
            cpCard = "바위";
        } else if (k >= 60 && k < 90) {
            cpCard = "보";
        }
        System.out.println("");
        System.out.println("알파고) " + cpCard + "..!!");
        System.out.println("나) " + myCard+ "!");
        resultAndRetry(myCard, cpCard);
    }
    void resultAndRetry(String myCard, String cpCard){
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("가위바위", "졌다......ㅠㅠ");
        resultMap.put("가위보", "이겼다...! 야호!!");
        resultMap.put("바위가위", "이겼다...! 야호!!");
        resultMap.put("바위보", "졌다......ㅠㅠ");
        resultMap.put("보가위", "졌다......ㅠㅠ");
        resultMap.put("보바위", "이겼다...! 야호!!");

        if(cpCard == myCard){
            System.out.println("비겼다..!! 한판더 하죠!!!");
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