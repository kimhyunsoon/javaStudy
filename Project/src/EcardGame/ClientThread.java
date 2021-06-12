package ecardGame;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

import ecardGame.ClientGUI;

public class ClientThread extends Thread{
    Sender sender;
    ClientGUI cg; //ClientGUI ��ü
    Socket sc; 
    int port = 4003;
    DataInputStream dis;
    DataOutputStream dos;
    Thread thisThread; //������ ����
    String chatID;
    String msg;
    String ip = "127.0.0.1"; // Login ���� ip�� �޾ƿ�
    boolean gameStart; 
    String playerName, playerScore, playerIdx; 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    //�� ó�� �Է��� ���ڿ�(�г���)�� �����ϴ� �迭

    
    public ClientThread(ClientGUI client){//ä�� ���� ����
        try {
            this.cg = client;
            sc = new Socket(ip,port);
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
            //chatID = br.readLine();

            ClientGUI.inputName.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent ke){
                    if(ke.getKeyCode() == KeyEvent.VK_ENTER){//���� ������ ����
                        ClientGUI.chatLog.append("����������Ǿ����ϴ� \n");
						chatID = ClientGUI.inputName.getText(); //�Է¹��� �ؽ�Ʈ�� ���̵�� ����
						sender = new Sender(sc, chatID);
                    }
                }
            });

            ClientGUI.inputMsg.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent ke2){
                    if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                        msg = ClientGUI.inputMsg.getText();
                        System.out.println(msg);
                        sender.send(msg); //����Ŭ������ �۽� �޼ҵ� ȣ��
                        ClientGUI.inputMsg.setText("");
                    }
                }
            });

            thisThread = this;
            start();


            ClientGUI.enterBtn.addActionListener(new Sender(sc, chatID));
            ClientGUI.clearBtn.addActionListener(new Sender(sc, chatID));
            ClientGUI.exitBtn.addActionListener(new Sender(sc, chatID));

            //cg = client; //��ü������ �Ҵ�

        } catch (UnknownHostException ue){
        } catch (IOException ie) {
        }
    }

    public void updateClientList(){
        if(Integer.parseInt(playerIdx)==0){
            pln("�÷��̾�1: "+playerName+" >>Ȳ���� �����մϴ�");
            pln("�÷��̾�1 ��ȣ: "+playerIdx);
            deleteClientList();
        }else if(Integer.parseInt(playerIdx) == 1){
            pln("�÷��̾�2: "+playerName+" >>�뿹�� �����մϴ�");
            pln("�÷��̾�2 ��ȣ: "+playerIdx);
        }

    }
    public void deleteClientList(){
        if(Integer.parseInt(playerIdx)==0){
            pln("1���� ��������");
        }
    }

    //�����ϴ� ������
    public void run(){
        try {
            Thread thread = Thread.currentThread();//currentThread()�� �����ϴ� Thread �ν��Ͻ��� ���۷����� ��ȯ
            while(thread==thisThread){
                String msg = dis.readUTF();
                //pln(msg);
                if(msg.startsWith("//SList")){
                    playerName = msg.substring(7, msg.indexOf(" "));
                    playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                    playerIdx = msg.substring(msg.indexOf("#") + 1);
                    updateClientList(); 
                }else if(msg.startsWith("//ReadyAll")){
                    pln("�� ������ ���۵˴ϴ�");
                    pln(msg);
                }else if(msg.startsWith("//Start")){
                    gameStart = true;
                    pln("Game Start");
                }else if(msg.startsWith("//Timer")){
                    pln(msg.substring(7));
                }else{
                    ClientGUI.chatLog.append(msg + "\n");
                }
                Thread.sleep(200);
            }//while�� ����(������ ����)
        } catch (InterruptedException ite) {
            System.out.println(ite);
            release();
        }catch(IOException e){
            System.out.println(e);
            release();
        }
    }
    public void release(){ };

    public void pln(String str){
        System.out.println(str);
    }

    //����Ŭ���� -- �г��Ӱ� ä�� �۽�
    public class Sender implements ActionListener{
        Socket sc;
        String chatID;
        String msg;

        Sender(Socket sc, String chatID){
            this.sc = sc;
            this.chatID = chatID;

            try {
                dos.writeUTF(chatID);
                dos.flush();
            } catch (Exception e) {
            }
           
        }
        //�޼��� �۽� �޼ҵ�
        public void send(String msg){
            if(dos !=null){
                try {
                    dos.writeUTF("//Chat "+chatID+">> "+msg);
                    dos.flush();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == ClientGUI.enterBtn){
                try {
                    dos.writeUTF("//Press"+"//King"+chatID);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource() == ClientGUI.clearBtn){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            //if(e.getSource() == cg.clearBtn) send("//Ready");
            if(e.getSource() == ClientGUI.exitBtn){
                try {
                    dos.writeUTF("//Press"+"//Slav"+chatID);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }





    }

   
}
