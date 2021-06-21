package ecardGame;
import ecardGame.EcardGUI;
import ecardGame.Login;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ClientThread extends Thread{
    //Sender sender; //����Ŭ���� Sender
    EcardGUI eg; //EcardGUI ��ü
    //ClientGUI cg; //ClientGUI ��ü
    //Socket sc; 
    int port = 4003;
    DataInputStream dis;
    DataOutputStream dos;
    Thread thisThread; 
    String chatID;
    String msg;
    String ip;
    //String ip = "127.0.0.1"; // Login ���� ip�� �޾ƿ�
    boolean gameStart; 
    String playerName, playerScore, playerIdx; 
    Login login;
    
    public ClientThread(){//ä�� ���� ����
        String chatID = Login.nickName; // Login ���� nickName �� �޾ƿ�.
		String ip = Login.IP; // Login ���� ip�� �޾ƿ�
        
        try {
            //this.login = client;
            Socket sc = new Socket(ip,port);
            Sender sender = new Sender(sc, chatID);
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
            
            //<-------�̺�Ʈ������-------->
            EcardGUI.text_msg.addKeyListener(new Sender(sc,chatID));
			EcardGUI.btn_exit.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_Ready.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myKing.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_mySlav.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn1.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn2.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn3.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn4.addActionListener(new Sender(sc, chatID));

            thisThread = this;
            start();
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
            //Thread thread = Thread.currentThread();//currentThread()�� �����ϴ� Thread �ν��Ͻ��� ���۷����� ��ȯ
            while(dis != null){
                String msg = dis.readUTF();
                if(msg.startsWith("//SList")){
                    playerName = msg.substring(7, msg.indexOf(" "));
                    playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                    playerIdx = msg.substring(msg.indexOf("#") + 1);
                    updateClientList(); 
                }else if(msg.startsWith("//Start")){
                    gameStart = true;
                    //ClientGUI.chatLog.append("Game Start"+ "\n");
                    //pln("Game Start");
                }else if(msg.startsWith("//Timer")){
                    //label_Timer.setText(msg.substring(7));
                    pln(msg.substring(7));
                }else{
                    //ClientGUI.chatLog.append(msg + "\n");
                }
            }//while�� ����(������ ����)
        }catch(IOException e){
            try{
                //ClientGUI.chatLog.append("[ �������� ������ ���������ϴ�. ]\n[ 3�� �� ���α׷��� �����մϴ� .. ]");       
                Thread.sleep(3000);         
                //release();}
            }catch (InterruptedException ite) {
                System.out.println(ite);
            }
            //release();
        }
    }
    public void release(){ };
    public void pln(String str){
        System.out.println(str);
    }

    //����Ŭ���� -- �г��Ӱ� ä�� �۽�
    public class Sender implements ActionListener, KeyListener{
        Socket sc;
        String chatID0;
        String msg;

        Sender(Socket sc, String chatID){
            this.sc = sc;
            this.chatID0 = chatID;
            try {
                dos.writeUTF(chatID);
            } catch (Exception e) {
            }           
        }
        //ä�� �۽� �޼ҵ�
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
            if(e.getSource() == EcardGUI.btn_myKing){
                System.out.println("//Press"+"//King"+chatID);
                try {
                    dos.writeUTF("//Press"+"//King"+chatID);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            // if(e.getSource() == ClientGUI.clearBtn){
            //     try {
            //         dos.writeUTF("//Press"+"//Ctzn"+chatID);
            //         dos.flush();
            //     } catch (IOException e1) {
            //         e1.printStackTrace();
            //     }
            // }
            if(e.getSource() ==  EcardGUI.btn_Ready) {
                try {
                    dos.writeUTF("//Ready");
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource() == EcardGUI.btn_mySlav){
                try {
                    dos.writeUTF("//Press"+"//Slav"+chatID);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
    }




}



// EcardGUI.enterBtn.addActionListener(new Sender(sc, chatID));
// EcardGUI.clearBtn.addActionListener(new Sender(sc, chatID));
// EcardGUI.exitBtn.addActionListener(new Sender(sc, chatID));


// EcardGUI.inputName.addKeyListener(new KeyAdapter(){
//     public void keyPressed(KeyEvent ke){
//         if(ke.getKeyCode() == KeyEvent.VK_ENTER){//���� ������ ����
//             ClientGUI.chatLog.append("����������Ǿ����ϴ� \n");
//             chatID = ClientGUI.inputName.getText(); //�Է¹��� �ؽ�Ʈ�� ���̵�� ����
//             sender = new Sender(sc, chatID);
            
//         }
//     }
// });


// ClientGUI.inputMsg.addKeyListener(new KeyAdapter(){
//     public void keyPressed(KeyEvent ke2){
//         if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
//             msg = ClientGUI.inputMsg.getText();
//             System.out.println(msg);
//             sender.send(msg); //����Ŭ������ �۽� �޼ҵ� ȣ��
//             ClientGUI.inputMsg.setText("");
//         }
//     }
// });