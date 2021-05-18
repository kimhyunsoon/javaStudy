import java.io.*;
import java.util.*;

public class RPS {
    int totalRound; //총 게임
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
        pln("========가위바위보 게임========");
        pln("원하는 게임 수를 입력해주세요 : ");

        totalRound = s.nextInt();
    }

    void play(){
        
        if(roundCount<=totalRound){
            System.out.println("가위 바위 보");
            Scanner sc = new Scanner(System.in);
            Random ran = new Random();

            int com = ran.nextInt(3);
            String user = sc.next();
            game(com,user);


            
        }
        else{
            System.out.println("최종전적: "+win+"승 "+draw+"무 "+lose+"패");
        }

        
    }

    void game(int com, String user){
        if(user.equals("가위")){
            switch (com) {
                case 0:
                    pln("알파고) 가위!, 나) 가위!");
                    pln("draw!");
                    draw++;    
                    break;
                case 1:
                    pln("알파고) 바위!, 나) 가위!");
                    pln("졌...다...ㅠㅠ");
                    lose++;    
                    break;
                case 2:
                    pln("알파고) 보!, 나) 가위!");
                    pln("이겼다!!");
                    win++;    
                    break;
                default: pln("가위, 바위, 보로 입력해주세요");
            }
        }

        else if(user.equals("바위")){
            switch (com) {
                case 0:
                    pln("알파고) 가위!, 나) 바위!");
                    pln("이겼다!!");
                    win++;    
                    break;
                case 1:
                    pln("알파고) 바위!, 나) 바위!");
                    pln("draw!");
                    draw++;    
                    break;
                case 2:
                    pln("알파고) 보!, 나) 가위!");
                    pln("졌...다...ㅠㅠ");
                    lose++;    
                    break;
                default: pln("가위, 바위, 보로 입력해주세요");
            }
        }

        else if(user.equals("보")){
            switch (com) {
                case 0:
                    pln("알파고) 가위!, 나) 보!");
                    pln("졌...다...ㅠㅠ");
                    lose++;    
                    break;
                case 1:
                    pln("알파고) 바위!, 나) 보!");
                    pln("이겼다!!");
                    win++;    
                    break;
                case 2:
                    pln("알파고) 보!, 나) 가위!");
                    pln("draw!");
                    draw++;    
                    break;
                default: pln("가위, 바위, 보로 입력해주세요");
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
