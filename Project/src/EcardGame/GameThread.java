package EcardGame;

import java.io.*;
import java.net.*;
import java.util.*;

import EcardGame.GameServer;
import EcardGame.GameThread;

public class GameThread extends Thread{
    private Socket gtsc;
    private DataInputStream dis;
    private DataOutputStream dos;

    //플레이어 저장
    private static LinkedHashMap<String, DataOutputStream> playerList = new LinkedHashMap<String, DataOutputStream>(GameServer.maxclient);
    private static LinkedHashMap<String, Integer> playerInfo = new LinkedHashMap<String,Integer>(GameServer.maxclient);

    //private GameClient gtClient; //클라이언트 클래스 변수로 선언
    //private GameGUI gameroom; //클라이언트 GUI 클래스 변수로 선언
    
    public String pName; //플레이어 ID
    public int score;
    private static GameThread client1 = null;
    private static GameThread client2 = null;
    private static String choose1 = null; //플레이어1 버튼 선택
    private static String choose2 = null; //플레이어2 버튼 선택
    private static int chooseInt1=0; 
    private static int chooseInt2=0;


    public GameThread(Socket sc){
        gtsc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }


    public void run(){//Socket에 있는 정보를 ->모니터, 브로드캐스트
        try {
            String pName = dis.readUTF(); //닉네임 저장
            if(!playerList.containsKey(pName)){ //playerList가 pName을 포함하고 있지 않으면
                playerList.put(pName,dos); //맵에 플레이어의 이름, 입력해 오는걸 저장
                playerInfo.put(pName,score); //맵에 플레이어의 이름, 점수를 저장
            }else if(playerList.containsKey(pName)){ 
                sc.close();//이미 존재하는 이름이면 소켓 닫음
            }
            sendMessage(pName+"님 입장!");
            pln(pName+"님 입장!");

            while(true){
                String msg = dis.readUTF(); //클라이언트로부터 수신되는 메세지 읽음
                filter(msg); //메세지or게임진행 브로드캐스트
            }
        } catch (IOException ie) {
            playerList.remove(pName); //게임참여자 리스트에서 제거 
            playerInfo.remove(pName, this); 
            sendMessage(pName+"님 퇴장!");
            pln(pName+"님 퇴장!");
        } finally{
            try {
                if(dis != null) dis.close(); 
                if(dos != null) dos.close(); 
                if(gtsc != null) gtsc.close();
            } catch (IOException ie) {
                //TODO: handle exception
            }
        }
    }

    void filter(String msg){//클라이언트쪽에서 보내는 버튼입력, 메세지입력 종류에 따라 각기 다른 행위를 함
        //전략 : 클라이언트쪽의 입력이벤트에서 발생하는 구분자 종류로 어떤 행위를 선택할지
        // 
        
        String temp = msg.substring(0,6); //
        if(temp.equals("//Chat ")){ //채팅을 입력받았을 경우
            sendMessage(msg.substring(7)); //7번째 스트링부터 브로드캐스트
        }else if(temp.equals("//King ") && temp.equals("//slave") && temp.equals("//ctzn ")){
            //플레이어가 카드를 눌렀을 경우
            playGame();
        }


    }



    void playGame(){
        //플레이어 버튼 액션으로부터 String으로 받은 값을 정수형으로 변환
        if(choose1 == null){ //플레이어1의 버튼 결과
            chooseInt1 = Integer.parseInt(choose1); //
        }
        else{
            chooseInt2 = Integer.parseInt(choose2);
        }
        if(choose1!=null&&choose2!=null){//타이머 30초가 끝나면 실행되는 변수 넣어줘야 함
            //플레이어1이 왕이고, 플레이어2가 노예인 케이스와
            //플레이어1이 노예고, 플레이어2가 왕인 케이스 2개가 있어야 함
            //입장순서대로 왕,노예가 정해지므로 플레이어1이 왕, 플레이어2가 노예다
            switch (chooseInt1) {
                case 1: //플레이어1이 시민카드 냈을때
                    if(chooseInt2==0){//플레이어2 노예
                        sendMessage("플레이어1 승 플레이어2 패");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }else if(chooseInt2==1){//플레이어2 시민
                        sendMessage("무승부 다시 하세요");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }
                case 2: //플레이어1이 왕카드 냈을때
                    if(chooseInt2==0){
                        sendMessage("플레이어1 패 플레이어2 승");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }else if(chooseInt2==1){
                        sendMessage("플레이어1 승 플레이어2 패");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }
                break;
            }
        }
    }






    public void sendMessage(String msg){
        Iterator<String> iter = playerList.keySet().iterator();
        //맵의 key값에 저장되어 있는 플레이어들에게 메세지 송신
        while(iter.hasNext()){
            try {

                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException ie) {
            }
        }
    }

    void pln(String str){
        System.out.println(str);
    }





    
}




    // //플레이어 ID 구하기
    // private String getPlayreID(){
    //     String ids;
    //     Enumeration<String> enu = playerVector.elements();
    //     while(enu.hasMoreElements()){
    //         pName.pln(enu.nextElement());
    //     }
    // }


    // //플레이어 ID, 스레드 배열에 저장
    // void addUser(String pName, GameThread client){
    //     if(checkID(pName)!= null){ //입력받지 않으면 에러, 예외처리 아직 안됨
    //         System.out.println("error");
    //     }
    //     playerList.put(pName, dos); //사용자 ID 추가
    //     //벡터의 끝에 지정된 구성 요소를 추가하여 크기가 1씩 증가 
    //     playerInfo.put(pName,score);//사용자 ID 및 클라이언트와 통신할 스레드 저장
    //     client.pName = pName;
    // }
    


    

