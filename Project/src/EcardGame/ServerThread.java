package ecardGame;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import ecardGame.ServerGUI;
import ecardGame.ServerThread;

public class ServerThread extends Thread{
    private Socket gtsc;
    private DataInputStream dis;
    private DataOutputStream dos;

    public static final int maxclient = 2;
    public String pName; //플레이어 ID
    public int score;
    boolean gameStart;
    

    //배열
    private static LinkedHashMap<String, DataOutputStream> clientList = new LinkedHashMap<String, DataOutputStream>(ServerGUI.maxclient);
    private static LinkedHashMap<String, Integer> clientInfo = new LinkedHashMap<String,Integer>(ServerGUI.maxclient);
    private static Vector<Integer> readyPlayer = new Vector<Integer>(); 
    private static Vector<Integer> roundCount = new Vector<Integer>();
     
    private static String client1 = "";
    private static String client2 = "";
    private static String client1Card = "";
    private static String client2Card = "";

    public ServerThread(Socket sc){ //생성자에서 스트림 오픈
        gtsc = sc;        
        try {
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
    

    public void run(){//플레이어 맵에 저장, filter 메소드 실행, 플레이어 퇴장시 제거 
        try {
            pName = dis.readUTF(); 
            if(!clientList.containsKey(pName)){ //닉네임 중복방지, 중복되면 소켓 닫음
                clientList.put(pName,dos); //맵에 플레이어의 이름, 입력해 오는걸 저장
                clientInfo.put(pName,score); //맵에 플레이어의 이름, 점수를 저장
            }
            if(clientList.size()> ServerGUI.maxclient){ //인원수 제한
                System.out.println("풀방");
                //sendMessage("//Full ");
                gtsc.close();
            }
            if(client1 == "") { //client1이 비어있으면 최초로 로그인한 사람 저장
                client1 = pName;
            } else {
                client2 = pName;
            }
            System.out.println("System>> "+pName+"님이 입장하셨습니다."+clientList.size()+"명");
            sendMessage("System>> "+pName+"님이 입장하셨습니다.");
            setClientInfo();
            while(true){
                String msg = dis.readUTF(); //클라이언트로부터 수신되는 메세지 읽음
                filter(msg); //메세지or게임진행 브로드캐스트
            }
        } catch (IOException ie) {
            clientList.remove(pName); //게임참여자 리스트에서 제거 
            clientInfo.remove(pName, this); 
            sendMessage("System>> "+pName+"님이 퇴장하셨습니다.");
            pln(pName+"님 퇴장!");
            readyPlayer.removeElement(1);
            System.out.println(readyPlayer.size());
        } 
        finally{
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
        StopWatch tm = new StopWatch(); 
        String temp = msg.substring(0,7);
        
        if(temp.equals("//Chat ")){ //채팅을 입력받았을 경우
            pln(msg.substring(7));
            sendMessage(msg.substring(7)); 
        }else if(temp.equals("//Ready")){ //준비버튼이 입력되었을 경우
            readyPlayer.addElement(1);
            System.out.println(readyPlayer.size());
            if(readyPlayer.size()>=2&&readyPlayer.size() == clientList.size()) { //준비버튼 배열의 사이즈와 클라이언트리스트 사이즈(최대:2) 같으면 실행
                sendMessage("[곧 게임이 시작됩니다]");
                for(int i=3; i>0; i--){
                    try{
                        sendMessage("[ " + i + "초 후 게임을 시작합니다 .. ]");						 	
                        Thread.sleep(1000);
                    }catch(InterruptedException ie){}
                }
                gameStart = true;
                tm.start();
                sendMessage("//Start"); //Start 예약어 보냄	
                //readyPlayer.removeAllElements();
            }
        }else if(temp.equals("//Press")){//플레이어가 카드를 눌렀을 경우
            String cardType = msg.substring(7,13); //선택한 카드 저장
            String member = msg.substring(13);     //플레이어 저장
            pln(msg);
            if(member==client1) {
                client1Card = cardType;
                
            }else if(member==client2) {
                client2Card = cardType;
            }
            if(!client2Card.equals("") && !client1Card.equals("")) {
                switch (client1Card) {//플레이어1
                    case "//Ctzn": //플레이어1이 시민카드 냈을때
                        if(client2Card.equals("//Slav")){//플레이어2 노예
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage("무승부 다시 하세요");
                            sendScore();
                            showCard();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//King")){
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//King": //플레이어1
                        if(client2Card.equals("//Slav")){//플레이어2 노예
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//Slav": //플레이어1
                        if(client2Card.equals("//King")){//플레이어2 왕
                            sendMessage(client1 +" 승 "+client2+" 패 ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //승자 점수 추가
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//플레이어2 시민
                            sendMessage(client1 +" 패 "+client2+" 승 ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //승자 점수 추가
                            sendScore();
                            showCard();
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
            sendMessage("//Round" + 2); //이 예약어가 들어오면 라운드 표시? 안해도 상관 없을듯
        }else {
            int nextRound = roundCount.get(0) + 1;
            if(nextRound > 3) {
                sendMessage("//Slav " + client1); //카드 교체 로직이므로 이 예약어가 들어오면 카드를 교체해서 셋팅해주세요
                sendMessage("//King " + client2);
                // roundCount.clear();
            }else {
                roundCount.set(0, nextRound);
                sendMessage("//Round" + nextRound);
            }
        }
    }

    public void setClientInfo(){ //clientInfo  key값은 플레이어명, value값은 스코어
        String[] keys = new String[clientInfo.size()];
        int[] values = new int[clientInfo.size()];
        String[] client = new String[2];
        int index = 0;
        for(Map.Entry<String, Integer> mapEntry : clientInfo.entrySet()){
            keys[index] = mapEntry.getKey();
            values[index] = mapEntry.getValue();
            index++;
        }
        for(int i=0; i<clientList.size(); i++){
            sendMessage("//SList" + keys[i] + " " + values[i] + "#" + i); 
            System.out.println("//SList" + keys[i] + " " + values[i] + "#" + i);
            client[i] = keys[i];
            //System.out.println(client[i]);
        }

    }

    public void sendScore(){ //예약어와 함께 플레이어 이름, 점수 송신
        sendMessage("//CList"+client1+" "+clientInfo.get(client1));
        sendMessage("//CList"+client2+" "+clientInfo.get(client2));
        sendMessage("//Times"+client1);
        sendMessage("//Times"+client2);
    }

    public void showCard(){
        sendMessage("//Wcard"+client1+" "+client1Card);
        sendMessage("//Wcard"+client2+" "+client2Card);
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

    class StopWatch extends Thread {
		long preTime = System.currentTimeMillis();
		
		public void run() {
			
            try{
                
				while(gameStart == true){
					sleep(10);
					long time = System.currentTimeMillis() - preTime;
					sendMessage("//Timer" + (toTime(time)));
                    pln("//Timer" + (toTime(time)));
                    sleep(1000);
					if(toTime(time).equals("00 : 00")){
						sendMessage("//GmEnd"); // 시간 초과시, 게임 종료
						readyPlayer.removeAllElements();
						gameStart = false;
						break;
					}else if(readyPlayer.size() == 0){
						break;
					}
				}
			}catch (Exception e){}

		}
		
		String toTime(long time){
			int s = (int)(33-(time % (1000.0 * 60) / 1000.0));
			return String.format("%02d", s);
		}
	}


}



    

// Set<Map.Entry<String, DataOutputStream>> entries = clientList.entrySet();
// Set<String> keySet = clientList.keySet();
// Collection<DataOutputStream> values = clientList.values();
// Stream<Map.Entry<String, DataOutputStream>> entriesStream = entries.stream();
// Stream<DataOutputStream> valuesStream = values.stream();
// Stream<String> keysStream = keySet.stream();
// clientList.entrySet().stream().forEach(entry-> {
//     System.out.println("[key]:" + entry.getKey() + ", [value]:"+entry.getValue());
// });
