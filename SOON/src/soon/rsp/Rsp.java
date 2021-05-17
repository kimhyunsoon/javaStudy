package soon.rsp;
import soon.lib.*;
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
        System.out.println("====== 가위바위보 게임 ======");
        System.out.print("몇판 하실래요??? : ");
        

        if(!s.hasNextInt()) {
            s.next();
            System.out.println("");
            System.out.println("게임 수는 1~10 사이의 숫자로 입력해주세요.");
            inputRound();
        } else {
            totalRound = s.nextInt();
            System.out.println("");
            if (totalRound == 0 || totalRound > 10 ){
                System.out.println("최소 1게임에서 최대 10게임 까지 가능해요..! 다시 입력해주세요.");
                inputRound();
            }
        }
    }
    void input(){
        if(roundCount < totalRound ) {
            Scanner s = new Scanner(System.in);
            System.out.println("");
            System.out.println("========= ROUND "+roundCount+"/"+totalRound+" =========");
            System.out.println("현재 전적 : " + win+ "승 / "+ draw + "무 / " + lose + "패");
            System.out.println("");
            System.out.println("알파고) 안내면 진다...! 가위바위보!!!");
            System.out.println("");
            
            System.out.println("나) 무엇을 낼까..?");
            System.out.println("1. 가위   2. 바위   3. 보");
            System.out.print(":");
            String select = s.next();
            String select2 = select.trim();
            transInput(select);
        } else if (roundCount == totalRound) {
            Scanner s = new Scanner(System.in);
            System.out.println("");
            System.out.println("====== Final ROUND "+roundCount+"/"+totalRound+" ======");
            System.out.println("현재 전적 : " + win+ "승 / "+ draw + "무 / " + lose + "패");
            System.out.println("");
            System.out.println("알파고) 안내면 진다...! 가위바위보!!!");
            System.out.println("");
            
            System.out.println("나) 무엇을 낼까..?");
            System.out.println("1. 가위   2. 바위   3. 보");
            System.out.print(":");
            String select = s.next();
            String select2 = select.trim();
            transInput(select);
        } else {
            System.out.println("");
            System.out.println("최종 전적 : " + win+ "승 / "+ draw + "무 / " + lose + "패");
            if(win > lose){
                System.out.println(win-lose + "점 차이로 알파고에게 승리...!!!");
            } else if (lose > win) {
                System.out.println(lose-win + "점 차이로 알파고에게 패배...ㅜㅜ");
            } else if (win == lose) {
                System.out.println("무승부에요...!!");
            }
        }
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
            roundCount += 1;
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
        resultMap.put("가위바위", "lose");
        resultMap.put("가위보", "win");
        resultMap.put("가위가위", "draw");
        resultMap.put("바위가위", "win");
        resultMap.put("바위보", "lose");
        resultMap.put("바위바위", "draw");
        resultMap.put("보가위", "lose");
        resultMap.put("보바위", "win");
        resultMap.put("보보", "draw");

        String result = myCard+cpCard;
        System.out.println("");
        if (resultMap.get(result) == "win"){
            System.out.println("이겼다..!!");
            win += 1;
        } else if (resultMap.get(result) == "lose") {
            System.out.println("졌다.....ㅠㅠ");
            lose += 1;
        } else if (resultMap.get(result) == "draw") {
            System.out.println("비겼잖아??!!");
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
