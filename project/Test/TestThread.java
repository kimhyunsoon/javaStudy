package Test;

import java.io.*;
import java.net.*;
import java.util.*;

import Test.TestServer;
import Test.TestThread;




public class TestThread extends Thread{
    TestServer ts;
    Socket gtsc;
    DataInputStream gtis;
    DataOutputStream gtos;


    //플레이어 저장
    private static Vector<String> playerVector = new Vector<String>();
    //private static Hashtable<String, TestThread> playerHash = new Hashtable<String,TestThread>(TestServer.maxclient);

    //private GameClient gtClient; //클라이언트 클래스 변수로 선언
    //private GameGUI gameroom; //클라이언트 GUI 클래스 변수로 선언
    
    public String gtID; //플레이어 ID
    private static TestThread client1 = null;
    private static TestThread client2 = null;
    private static String choose1 = null; //플레이어1 버튼 선택
    private static String choose2 = null; //플레이어2 버튼 선택
    private static int chooseInt1=0; 
    private static int chooseInt2=0;


    public TestThread(TestServer ts){
        try {
            this.ts = ts;
            this.gtsc = ts.sc;
            gtis = new DataInputStream(gtsc.getInputStream());
            gtos = new DataOutputStream(gtsc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    //서버에 연결된 여러 개의 클라이언트 쓰레드
    public void run(){//Socket에 있는 정보를 ->모니터, 브로드캐스트
        try {
            String gtID = gtis.readUTF(); //클라이언트가 입력하는 첫줄은 닉네임으로 받음
            sendMessage(gtID+"님 입장!");
            pln(gtID+"님 입장!");
            addUser(gtID, this); //배열에 클라이언트 정보 추가
            while(true){
                String msg = gtis.readUTF(); //메세지 읽음
                sendMessage(msg);

                //게임 결과 계산하기
                //hashtable에서 플레이어1, 플레이어2 찾기
                if(client1 == null) {  //참여자1 hashtable에서 찾기(왕)
                    client1 = (TestThread) playerHash.get(gtID);
                }
                else{  //참여자2 hashtable에서 찾기(노예)
                    client2 = (TestThread) playerHash.get(gtID);
                }

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
        } catch (IOException ie) {
            playerVector.removeElement(gtID); //게임참여자 리스트에서 제거 
            playerHash.remove(gtID, this); 
            sendMessage(gtID+"님 퇴장!");
            pln(gtID+"님 퇴장!");
        } finally{
            try {
                if(gtis != null) gtis.close(); 
                if(gtos != null) gtos.close(); 
                if(gtsc != null) gtsc.close();
            } catch (IOException ie) {
                //TODO: handle exception
            }
        }
    }



    
    //플레이어 ID, 스레드 배열에 저장
    void addUser(String gtID, TestThread client){
        if(checkID(gtID)!= null){ //입력받지 않으면 에러, 예외처리 아직 안됨
            System.out.println("error");
        }
        playerVector.addElement(gtID); //사용자 ID 추가
        //벡터의 끝에 지정된 구성 요소를 추가하여 크기가 1씩 증가 
        playerHash.put(gtID,this);//사용자 ID 및 클라이언트와 통신할 스레드 저장
        client.gtID = gtID;
    }

    //ID 중복확인
    //반환값이 null이라면 요구한 ID로 게임방 입장이 가능함
    private static TestThread checkID(String gtID){
        TestThread notValid = null; 
        notValid = (TestThread)playerHash.get(gtID);//지정된 키에 맵핑된 value값을 반환
        return notValid;
    }

    //브로드캐스트
    //playerVector에 저장된 구성요소(player)가 다 소진될 때까지 
    //playerHash에 있는 key값에 해당되는 value값을 client 변수에 저장하고 
    //이 변수가 sendMessage 메소드 실행

    void broadcast(String msg){

        //벡터의 구성요소를 반환, 반환된 Enumeration 개체는 이 벡터의 모든 항목을 생성한다
        try {
            TestThread client;
            Enumeration<String> enu = playerVector.elements();
            while(enu.hasMoreElements()){
                client = (TestThread)playerHash.get(enu.nextElement());
                client.sendMessage(msg);
            }
        } catch (NoSuchElementException ne) {
        }
    }


    public void sendMessage(String msg){
        try {
            gtos.writeUTF(msg);
            gtos.flush();
        } catch (IOException ie) {
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
    //         gtID.pln(enu.nextElement());
    //     }
    // }

    


    

