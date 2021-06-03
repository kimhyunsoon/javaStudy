package project.EcardGame;

import java.io.*;
import java.net.*;
import java.util.*;

import project.EcardGame.GameServer;
import project.EcardGame.GameThread;

public class GameThread extends Thread{
    private Socket gtsc;
    private DataInputStream gtis;
    private DataOutputStream gtos;

    //�÷��̾� ����
    private static Vector<String> playerVector = new Vector<String>(GameServer.maxclient);
    private static Hashtable<String, GameThread> playerHash = new Hashtable<String,GameThread>(GameServer.maxclient);

    //private GameClient gtClient; //Ŭ���̾�Ʈ Ŭ���� ������ ����
    //private GameGUI gameroom; //Ŭ���̾�Ʈ GUI Ŭ���� ������ ����
    
    public String gtID; //�÷��̾� ID
    private static GameThread client1 = null;
    private static GameThread client2 = null;
    private static String choose1 = null; //�÷��̾�1 ��ư ����
    private static String choose2 = null; //�÷��̾�2 ��ư ����
    private static int chooseInt1=0; 
    private static int chooseInt2=0;


    public GameThread(Socket sc){
        try {
            gtsc = sc;
            gtis = new DataInputStream(sc.getInputStream());
            gtos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    //������ ����� ���� ���� Ŭ���̾�Ʈ ������
    public void run(){//Socket�� �ִ� ������ ->�����, ��ε�ĳ��Ʈ
        try {
            String gtID = gtis.readUTF(); //Ŭ���̾�Ʈ�� �Է��ϴ� ù���� �г������� ����
            sendMessage(gtID+"�� ����!");
            pln(gtID+"�� ����!");
            addUser(gtID, this); //�迭�� Ŭ���̾�Ʈ ���� �߰�
            while(true){
                String msg = gtis.readUTF(); //�޼��� ����
                sendMessage(msg);

                //���� ��� ����ϱ�
                //hashtable���� �÷��̾�1, �÷��̾�2 ã��
                if(client1 == null) {  //������1 hashtable���� ã��(��)
                    client1 = (GameThread) playerHash.get(gtID);
                }
                else{  //������2 hashtable���� ã��(�뿹)
                    client2 = (GameThread) playerHash.get(gtID);
                }

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
        } catch (IOException ie) {
            playerVector.removeElement(gtID); //���������� ����Ʈ���� ���� 
            playerHash.remove(gtID, this); 
            sendMessage(gtID+"�� ����!");
            pln(gtID+"�� ����!");
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



    
    //�÷��̾� ID, ������ �迭�� ����
    void addUser(String gtID, GameThread client){
        if(checkID(gtID)!= null){ //�Է¹��� ������ ����, ����ó�� ���� �ȵ�
            System.out.println("error");
        }
        playerVector.addElement(gtID); //����� ID �߰�
        //������ ���� ������ ���� ��Ҹ� �߰��Ͽ� ũ�Ⱑ 1�� ���� 
        playerHash.put(gtID,this);//����� ID �� Ŭ���̾�Ʈ�� ����� ������ ����
        client.gtID = gtID;
    }

    //ID �ߺ�Ȯ��
    //��ȯ���� null�̶�� �䱸�� ID�� ���ӹ� ������ ������
    private static GameThread checkID(String gtID){
        GameThread notValid = null; 
        notValid = (GameThread)playerHash.get(gtID);//������ Ű�� ���ε� value���� ��ȯ
        return notValid;
    }

    //��ε�ĳ��Ʈ
    //playerVector�� ����� �������(player)�� �� ������ ������ 
    //playerHash�� �ִ� key���� �ش�Ǵ� value���� client ������ �����ϰ� 
    //�� ������ sendMessage �޼ҵ� ����

    void broadcast(String msg){

        //������ ������Ҹ� ��ȯ, ��ȯ�� Enumeration ��ü�� �� ������ ��� �׸��� �����Ѵ�
        try {
            GameThread client;
            Enumeration<String> enu = playerVector.elements();
            while(enu.hasMoreElements()){
                client = (GameThread)playerHash.get(enu.nextElement());
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




    // //�÷��̾� ID ���ϱ�
    // private String getPlayreID(){
    //     String ids;
    //     Enumeration<String> enu = playerVector.elements();
    //     while(enu.hasMoreElements()){
    //         gtID.pln(enu.nextElement());
    //     }
    // }

    


    

