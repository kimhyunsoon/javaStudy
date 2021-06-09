package ecardGame;

import java.io.*;
import java.net.*;
import java.util.*;

import ecardGame.GameServer;
import ecardGame.GameThread;

public class GameThread extends Thread{
    private Socket gtsc;
    private DataInputStream dis;
    private DataOutputStream dos;

    public static final int maxclient = 2;
    public String pName; //�÷��̾� ID
    public int score;

    //�迭
    private static LinkedHashMap<String, DataOutputStream> clientList = new LinkedHashMap<String, DataOutputStream>(GameServer.maxclient);
    private static LinkedHashMap<String, Integer> clientInfo = new LinkedHashMap<String,Integer>(GameServer.maxclient);
    private static Vector<Integer> readyPlayer = new Vector<Integer>(); 
    private static Vector<Integer> roundCount = new Vector<Integer>();
 
    private static String client1 = "";
    private static String client2 = "";
    private static String client1Card = "";
    private static String client2Card = "";

    public GameThread(Socket sc){ //�����ڿ��� ��Ʈ�� ����
        gtsc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    public void run(){//�÷��̾� �ʿ� ����, filter �޼ҵ� ����, �÷��̾� ����� ���� 
        //String pName = "";
        try {
            pName = dis.readUTF(); 
            if(!clientList.containsKey(pName)){ //�г��� �ߺ�����, �ߺ��Ǹ� ���� ����
                clientList.put(pName,dos); //�ʿ� �÷��̾��� �̸�, �Է��� ���°� ����
                clientInfo.put(pName,score); //�ʿ� �÷��̾��� �̸�, ������ ����
            }
            if(clientList.size()> GameServer.maxclient){ //�ο��� ����
                //sendMessage("//Full ");
                gtsc.close();
            }
            
            sendMessage("System>> "+pName+"���� �����ϼ̽��ϴ�.");
            if (client1.equals("")) {//���������� client1,client2 ������ ���� �� ī����� ����� ����
                client1 = pName;
                sendMessage("//King "+client1);
            }else {
                client2 = pName;
                sendMessage("//Slav "+client2);
            }
            while(true){
                String msg = dis.readUTF(); //Ŭ���̾�Ʈ�κ��� ���ŵǴ� �޼��� ����
                filter(msg); //�޼���or�������� ��ε�ĳ��Ʈ
            }
        } catch (IOException ie) {
            clientList.remove(pName); //���������� ����Ʈ���� ���� 
            clientInfo.remove(pName, this); 
            sendMessage("System>> "+pName+"���� �����ϼ̽��ϴ�.");
            pln(pName+"�� ����!");
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

    

    void filter(String msg){//Ŭ���̾�Ʈ�ʿ��� ������ ������ �����÷���, ä�� �� ���� �ٸ� ������ ��
        
        String temp = msg.substring(0,7);
        if(temp.equals("//Chat ")){ //ä���� �Է¹޾��� ���
            sendMessage(msg.substring(7)); 
        }else if(temp.equals("//Ready")){ //�غ��ư�� �ԷµǾ��� ���
            readyPlayer.addElement(1);
            System.out.println(readyPlayer.size());
            if(readyPlayer.size() == clientList.size()) { //�غ��ư �迭�� ������� Ŭ���̾�Ʈ����Ʈ ������(�ִ�:2) ������ ����
                sendMessage("�� ������ ���۵˴ϴ�");
                sendMessage("//ReadyAll");
                for(int i=3; i>0; i--){
                    try{
                        sendMessage("[ " + i + "�� �� ������ �����մϴ� .. ]");						 	
                        Thread.sleep(1000);
                    }catch(InterruptedException ie){}
                }
                sendMessage("//Start"); //Start ����� ����	
                readyPlayer.removeAllElements();
            }
        }else if(temp.equals("//Timer")){//Ÿ�̸Ӱ� ����Ǿ��� ���
            String cardType = msg.substring(7,13); //������ ī�� ����
            String member = msg.substring(13);     //�÷��̾� ����
            if(member.equals(client1)) {
                client1Card = cardType;
            }else if(member.equals(client2)) {
                client2Card = cardType;
            }

            if(!client2Card.equals("") && !client1Card.equals("")) {
                switch (client1Card) {//�÷��̾�1
                    case "//Ctzn": //�÷��̾�1�� �ù�ī�� ������
                        if(client2Card.equals("//Slav")){//�÷��̾�2 �뿹
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //���� ���� �߰�
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//�÷��̾�2 �ù�
                            sendMessage("���º� �ٽ� �ϼ���");
                            sendScore();
                            showCard();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//King")){
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //���� ���� �߰�
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//King": //�÷��̾�1
                        if(client2Card.equals("//Slav")){//�÷��̾�2 �뿹
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //���� ���� �߰�
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//�÷��̾�2 �ù�
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //���� ���� �߰�
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }
                    case "//Slav": //�÷��̾�1
                        if(client2Card.equals("//King")){//�÷��̾�2 ��
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client1, clientInfo.get(client1)+1); //���� ���� �߰�
                            sendScore();
                            showCard();
                            countRound();
                            client1Card = client2Card = "";
                            break;
                        }else if(client2Card.equals("//Ctzn")){//�÷��̾�2 �ù�
                            sendMessage(client1 +" �� "+client2+" �� ");
                            clientInfo.put(client2, clientInfo.get(client2)+1); //���� ���� �߰�
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
            sendMessage("//Round" + 2); //�� ���� ������ ���� ǥ��? ���ص� ��� ������
        }else {
            int nextRound = roundCount.get(0) + 1;
            if(nextRound > 3) {
                sendMessage("//Slav " + client1); //ī�� ��ü �����̹Ƿ� �� ���� ������ ī�带 ��ü�ؼ� �������ּ���
                sendMessage("//King " + client2);
                roundCount.clear();
            }else {
                roundCount.set(0, nextRound);
                sendMessage("//Round" + nextRound);
            }
        }
    }

    public void sendScore(){ //������ �Բ� �÷��̾� �̸�, ���� �۽�
        sendMessage("//CList"+client1+" "+clientInfo.get(client1));
        sendMessage("//CList"+client2+" "+clientInfo.get(client2));
        sendMessage("//Times"+client1);
        sendMessage("//Times"+client2);
    }

    public void showCard(){
        sendMessage("//Wcard"+client1+" "+client1Card);
        sendMessage("//Wcard"+client2+" "+client2Card);
    }

    public void sendMessage(String msg){ //�޼��� �۽� �޼ҵ�
        Iterator<String> iter = clientList.keySet().iterator();
        //���� key���� ����Ǿ� �ִ� �÷��̾�鿡�� �޼��� �۽�
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



    

