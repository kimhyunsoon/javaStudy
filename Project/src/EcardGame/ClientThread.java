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
    ClientGUI cg; //ClientGUI 객체
    Socket sc; 
    int port = 4003;
    DataInputStream dis;
    DataOutputStream dos;
    Thread thisThread; 
    String chatID;
    String msg;
    String ip = "127.0.0.1"; // Login 에서 ip를 받아옴
    boolean gameStart; 
    String playerName, playerScore, playerIdx; 
    
    public ClientThread(ClientGUI client){//채팅 소켓 생성
        try {
            this.cg = client;
            sc = new Socket(ip,port);
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
            
            //<-------이벤트리스너-------->
            ClientGUI.enterBtn.addActionListener(new Sender(sc, chatID));
            ClientGUI.clearBtn.addActionListener(new Sender(sc, chatID));
            ClientGUI.exitBtn.addActionListener(new Sender(sc, chatID));
            ClientGUI.inputName.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent ke){
                    if(ke.getKeyCode() == KeyEvent.VK_ENTER){//엔터 누르면 실행
                        ClientGUI.chatLog.append("서버에연결되었습니다 \n");
						chatID = ClientGUI.inputName.getText(); //입력받은 텍스트를 아이디로 저장
						sender = new Sender(sc, chatID);
                        
                    }
                }
            });
            ClientGUI.inputMsg.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent ke2){
                    if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                        msg = ClientGUI.inputMsg.getText();
                        System.out.println(msg);
                        sender.send(msg); //내부클래스의 송신 메소드 호출
                        ClientGUI.inputMsg.setText("");
                    }
                }
            });

            thisThread = this;
            start();
            //cg = client; //객체변수에 할당
        } catch (UnknownHostException ue){
        } catch (IOException ie) {
        }
    }

    public void updateClientList(){
        if(Integer.parseInt(playerIdx)==0){
            pln("플레이어1: "+playerName+" >>황제를 셋팅합니다");
            pln("플레이어1 번호: "+playerIdx);
            deleteClientList();
        }else if(Integer.parseInt(playerIdx) == 1){
            pln("플레이어2: "+playerName+" >>노예를 셋팅합니다");
            pln("플레이어2 번호: "+playerIdx);
        }
    }
    public void deleteClientList(){
        if(Integer.parseInt(playerIdx)==0){
            pln("1명이 들어와있음");
        }
    }

    //수신하는 쓰레드
    public void run(){
        try {
            //Thread thread = Thread.currentThread();//currentThread()를 실행하는 Thread 인스턴스의 레퍼런스를 반환
            while(dis != null){
                String msg = dis.readUTF();
                if(msg.startsWith("//SList")){
                    playerName = msg.substring(7, msg.indexOf(" "));
                    playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                    playerIdx = msg.substring(msg.indexOf("#") + 1);
                    updateClientList(); 
                }else if(msg.startsWith("//Start")){
                    gameStart = true;
                    ClientGUI.chatLog.append("Game Start"+ "\n");
                    pln("Game Start");
                }else if(msg.startsWith("//Timer")){
                    //label_Timer.setText(msg.substring(7));
                    pln(msg.substring(7));
                }else{
                    ClientGUI.chatLog.append(msg + "\n");
                }
            }//while문 종료(쓰레드 종료)
        }catch(IOException e){
            try{
                ClientGUI.chatLog.append("[ 서버와의 연결이 끊어졌습니다. ]\n[ 3초 후 프로그램을 종료합니다 .. ]");       
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

    //내부클래스 -- 닉네임과 채팅 송신
    public class Sender implements ActionListener{
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
        //채팅 송신 메소드
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
            if(e.getSource() ==  ClientGUI.clearBtn) {
                try {
                    dos.writeUTF("//Ready");
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
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
