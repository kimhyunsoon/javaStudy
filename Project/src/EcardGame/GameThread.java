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

    //�÷��̾� ����
    private static LinkedHashMap<String, DataOutputStream> playerList = new LinkedHashMap<String, DataOutputStream>(GameServer.maxclient);
    private static LinkedHashMap<String, Integer> playerInfo = new LinkedHashMap<String,Integer>(GameServer.maxclient);

    //private GameClient gtClient; //Ŭ���̾�Ʈ Ŭ���� ������ ����
    //private GameGUI gameroom; //Ŭ���̾�Ʈ GUI Ŭ���� ������ ����
    
    public String pName; //�÷��̾� ID
    public int score;
    private static GameThread client1 = null;
    private static GameThread client2 = null;
    private static String choose1 = null; //�÷��̾�1 ��ư ����
    private static String choose2 = null; //�÷��̾�2 ��ư ����
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


    public void run(){//Socket�� �ִ� ������ ->�����, ��ε�ĳ��Ʈ
        try {
            String pName = dis.readUTF(); //�г��� ����
            if(!playerList.containsKey(pName)){ //playerList�� pName�� �����ϰ� ���� ������
                playerList.put(pName,dos); //�ʿ� �÷��̾��� �̸�, �Է��� ���°� ����
                playerInfo.put(pName,score); //�ʿ� �÷��̾��� �̸�, ������ ����
            }else if(playerList.containsKey(pName)){ 
                sc.close();//�̹� �����ϴ� �̸��̸� ���� ����
            }
            sendMessage(pName+"�� ����!");
            pln(pName+"�� ����!");

            while(true){
                String msg = dis.readUTF(); //Ŭ���̾�Ʈ�κ��� ���ŵǴ� �޼��� ����
                filter(msg); //�޼���or�������� ��ε�ĳ��Ʈ
            }
        } catch (IOException ie) {
            playerList.remove(pName); //���������� ����Ʈ���� ���� 
            playerInfo.remove(pName, this); 
            sendMessage(pName+"�� ����!");
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

    void filter(String msg){//Ŭ���̾�Ʈ�ʿ��� ������ ��ư�Է�, �޼����Է� ������ ���� ���� �ٸ� ������ ��
        //���� : Ŭ���̾�Ʈ���� �Է��̺�Ʈ���� �߻��ϴ� ������ ������ � ������ ��������
        // 
        
        String temp = msg.substring(0,6); //
        if(temp.equals("//Chat ")){ //ä���� �Է¹޾��� ���
            sendMessage(msg.substring(7)); //7��° ��Ʈ������ ��ε�ĳ��Ʈ
        }else if(temp.equals("//King ") && temp.equals("//slave") && temp.equals("//ctzn ")){
            //�÷��̾ ī�带 ������ ���
            playGame();
        }


    }



    void playGame(){
        //�÷��̾� ��ư �׼����κ��� String���� ���� ���� ���������� ��ȯ
        if(choose1 == null){ //�÷��̾�1�� ��ư ���
            chooseInt1 = Integer.parseInt(choose1); //
        }
        else{
            chooseInt2 = Integer.parseInt(choose2);
        }
        if(choose1!=null&&choose2!=null){//Ÿ�̸� 30�ʰ� ������ ����Ǵ� ���� �־���� ��
            //�÷��̾�1�� ���̰�, �÷��̾�2�� �뿹�� ���̽���
            //�÷��̾�1�� �뿹��, �÷��̾�2�� ���� ���̽� 2���� �־�� ��
            //���������� ��,�뿹�� �������Ƿ� �÷��̾�1�� ��, �÷��̾�2�� �뿹��
            switch (chooseInt1) {
                case 1: //�÷��̾�1�� �ù�ī�� ������
                    if(chooseInt2==0){//�÷��̾�2 �뿹
                        sendMessage("�÷��̾�1 �� �÷��̾�2 ��");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }else if(chooseInt2==1){//�÷��̾�2 �ù�
                        sendMessage("���º� �ٽ� �ϼ���");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }
                case 2: //�÷��̾�1�� ��ī�� ������
                    if(chooseInt2==0){
                        sendMessage("�÷��̾�1 �� �÷��̾�2 ��");
                        choose1 = choose2 = null;
                        client1 = client2 = null;
                        break;
                    }else if(chooseInt2==1){
                        sendMessage("�÷��̾�1 �� �÷��̾�2 ��");
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
        //���� key���� ����Ǿ� �ִ� �÷��̾�鿡�� �޼��� �۽�
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




    // //�÷��̾� ID ���ϱ�
    // private String getPlayreID(){
    //     String ids;
    //     Enumeration<String> enu = playerVector.elements();
    //     while(enu.hasMoreElements()){
    //         pName.pln(enu.nextElement());
    //     }
    // }


    // //�÷��̾� ID, ������ �迭�� ����
    // void addUser(String pName, GameThread client){
    //     if(checkID(pName)!= null){ //�Է¹��� ������ ����, ����ó�� ���� �ȵ�
    //         System.out.println("error");
    //     }
    //     playerList.put(pName, dos); //����� ID �߰�
    //     //������ ���� ������ ���� ��Ҹ� �߰��Ͽ� ũ�Ⱑ 1�� ���� 
    //     playerInfo.put(pName,score);//����� ID �� Ŭ���̾�Ʈ�� ����� ������ ����
    //     client.pName = pName;
    // }
    


    

