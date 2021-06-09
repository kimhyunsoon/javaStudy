package project;

import java.io.*;
import java.net.*;
import java.util.*;

import project.GameServer;
import project.GameThread;

public class GameThread extends Thread{
    private Socket gtsc;
    private DataInputStream dis;
    private DataOutputStream dos;

    public static final int maxclient = 2;
    public String pName; //플레이어 ID
    public int score;

    //배열
    private static LinkedHashMap<String, DataOutputStream> clientList = new LinkedHashMap<String, DataOutputStream>(GameServer.maxclient);
    private static LinkedHashMap<String, Integer> clientInfo = new LinkedHashMap<String,Integer>(GameServer.maxclient);
    private static Vector<Integer> readyPlayer = new Vector<Integer>(); 
    private static Vector<Integer> roundCount = new Vector<Integer>();

    
    private static String client1 = "";
    private static String client2 = "";
    private static String client1Card = "";
    private static String client2Card = "";

    public GameThread(Socket sc){ //생성자에서 스트림 오픈
        gtsc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    public void run(){//플레이어 맵에 저장, filter 메소드 실행, 플레이어 퇴장시 제거 
        //String pName = "";
        try {
            pName = dis.readUTF(); 
            if(!clientList.containsKey(pName)){ //닉네임 중복방지, 중복되면 소켓 닫음
                clientList.put(pName,dos); //맵에 플레이어의 이름, 입력해 오는걸 저장
                clientInfo.put(pName,score); //맵에 플레이어의 이름, 점수를 저장
            }
            if(clientList.size()> GameServer.maxclient){ //인원수 제한
                //sendMessage("//Full ");
                gtsc.close();
            }
            sendMessage("System>> "+pName+"님이 임장하셨습니다.");
            if (client1.equals("")) {//입장순서대로 client1,client2 변수에 저장 후 카드셋팅 예약어 보냄
                client1 = pName;
                sendMessage("//King "+client1);
            }else {
                client2 = pName;
                sendMessage("//Slav "+client2);
              //Round //Slav
            }
            while(true){
                String msg = dis.readUTF(); //클라이언트로부터 수신되는 메세지 읽음
                filter(msg); //메세지or게임진행 브로드캐스트
            }
        } catch (IOException ie) {
            clientList.remove(pName); //게임참여자 리스트에서 제거 
            clientInfo.remove(pName, this); 
            sendMessage("System>> "+pName+"님이 퇴장하셨습니다.");
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

    void filter(String msg){//클라이언트쪽에서 보내는 예약어로 게임플레이, 채팅 등 각기 다른 행위를 함
        
        String temp = msg.substring(0,7);
        if(temp.equals("//Chat ")){ //채팅을 입력받았을 경우
            sendMessage(msg.substring(7)); 
        }else if(temp.equals("//Ready")){ //준비버튼이 입력되었을 경우
            readyPlayer.addElement(1);
            System.out.println(readyPlayer.size());
            if(readyPlayer.size() == clientList.size()) { //준비버튼 배열의 사이즈와 클라이언트리스트 사이즈(최대:2) 같으면 실행
            	
                sendMessage("곧 게임이 시작됩니다");
                sendMessage("//ReadyAll");
                for(int i=3; i>0; i--){
                    try{
                        sendMessage("[ " + i + "초 후 게임을 시작합니다 .. ]");						 	
                        Thread.sleep(1000);
                    }catch(InterruptedException ie){}
                }
                sendMessage("//Start"); //Start 예약어 보냄	
                readyPlayer.removeAllElements();
            }
        }else if(temp.equals("//Click")) {
        	sendMessage("//Back ");
        }else if(temp.equals("//timee")) {
        	sendMessage("//TimeO 30초가 지났습니다... 10초후에 다시...");
        	System.out.println(msg);
        } if(temp.equals("//Timer")){//타이머가 종료되었을 경우
        	System.out.println(msg);
            String cardType = msg.substring(7,13); //선택한 카드 저장
            String member = msg.substring(13);     //플레이어 저장
            if(member.equals(client1)) {
                client1Card = cardType;
            }else if(member.equals(client2)) {
                client2Card = cardType;
            }
            System.out.println("1: "+client1+"님");
            System.out.println("카드: "+client1Card);
            System.out.println("2: " +client2+"님");
            System.out.println("카드: "+client2Card);

            if(!client2Card.equals("") && !client1Card.equals("")) {
                switch (client1Card) {//플레이어1
                    case "//Ctzn": //플레이어1이 시민카드 냈을때
                        if(client2Card.equals("//Slav")){//플레이어2 노예
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage("//Draw 무승부 다시 하세요");
                            sendScore();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//King")){
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//King": //플레이어1
                        if(client2Card.equals("//Slav")){//플레이어2 노예
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//Slav": //플레이어1
                        if(client2Card.equals("//King")){//플레이어2 왕
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    break;
                }
            }
        }
    }

    public void countRound(){
        if(roundCount.size() == 0){
            roundCount.add(2);
            sendMessage("//Round" + 2 +"//King "+client1); //이 예약어가 들어오면 라운드 표시? 안해도 상관 없을듯+
            sendMessage("//Round" + 2 +"//Slav "+client2);
        }else {
            int nextRound = roundCount.get(0) + 1;
            if(nextRound > 3) {
                sendMessage("//Slav " + client1); //카드 교체 로직이므로 이 예약어가 들어오면 카드를 교체해서 셋팅해주세요
                sendMessage("//King " + client2);
                roundCount.clear();
            }else {
                roundCount.set(0, nextRound);
                //sendMessage("//Round" + nextRound);
                System.out.println(nextRound+"//King"+client1);
                sendMessage("//Round"+ nextRound +"//King "+client1);
                sendMessage("//Round"+ nextRound +"//Slav "+client2);
            }
        }
    }

    public void sendScore(){ //예약어와 함께 플레이어 이름, 점수 송신
        sendMessage("//CList"+client1+"#&"+clientInfo.get(client1));
        sendMessage("//CList"+client2+"#&"+clientInfo.get(client2));
    }

    public void sendMessage(String msg){ //메세지 송신 메소드
        Iterator<String> iter = clientList.keySet().iterator();
        //맵의 key값에 저장되어 있는 플레이어들에게 메세지 송신
        while(iter.hasNext()){
            try {
                DataOutputStream dos = clientList.get(iter.next());
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



    

