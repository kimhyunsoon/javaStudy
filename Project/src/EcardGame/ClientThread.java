package ecardGame;
// import ecardGame.EcardGUI;
// import ecardGame.Login;

// import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
// import javax.swing.JOptionPane;


public class ClientThread extends Thread implements ActionListener{
    Sender sender; //내부클래스 Sender
    
    EcardGUI eg; //EcardGUI 객체
    //ClientGUI cg; //ClientGUI 객체
    //Socket sc; 
    int port = 4003;
    DataInputStream dis;
    DataOutputStream dos;
    Thread thisThread; 
    String chatID;
    String msg;
    String ip;
    //String ip = "127.0.0.1"; // Login 에서 ip를 받아옴
    boolean gameStart; 
    String playerName, playerScore, playerIdx; 
    Login login;
    public static LinkedList<String> cardHost = new LinkedList<String>();

    
    public void startChat(){//채팅 소켓 생성
        //EcardGUI eg = new EcardGUI();
        disableBtn();
        String chatID = Login.nickName; // Login 에서 nickName 를 받아옴.
		ip = Login.IP; // Login 에서 ip를 받아옴
        
        
        try {
            //this.login = client;
            Socket sc = new Socket(ip,port);
            sender = new Sender(sc, chatID); //송신메소드 시작
            Listener listener = new Listener(sc);
            new Thread(sender).start();
            new Thread(listener).start();
            // dis = new DataInputStream(sc.getInputStream());
            start(); //수신 스레드 시작


            
            //<-------이벤트리스너-------->
            EcardGUI.text_msg.addKeyListener(new Sender(sc, chatID));
			EcardGUI.btn_exit.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_Ready.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myKing.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_mySlav.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn1.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn2.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn3.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn4.addActionListener(new Sender(sc, chatID));

            // EcardGUI.text_msg.addKeyListener(new KeyAdapter(){
            //     public void keyPressed(KeyEvent ke2){
            //         if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
            //             msg = EcardGUI.text_msg.getText();
            //             System.out.println(msg);
            //             sender.send(msg); //내부클래스의 송신 메소드 호출
            //             EcardGUI.text_msg.setText("");
            //         }
            //     }
            // });
            //thisThread = this;
            //cg = client; //객체변수에 할당
        } catch (UnknownHostException ue){
            pln("호스트를 찾을 수 없음");
        } catch (IOException ie) {
            pln("서버가 닫혀있는거 같음");
			System.exit(0);
        }
    }

    public void updateClientList(){
        if(Integer.parseInt(playerIdx)==0){

            EcardGUI.myScore1.setText(playerScore);
            EcardGUI.yourScore2.setText(playerScore);
            deleteClientList();
        }else if(Integer.parseInt(playerIdx) == 1){
            EcardGUI.myScore2.setText(playerScore);
            EcardGUI.yourScore1.setText(playerScore);
            deleteClientList();
        }
    }
    public void deleteClientList(){
        if(Integer.parseInt(playerIdx)==0){
            pln("1명이 들어와있음");

        }
    }

    public void pln(String str){
        System.out.println(str);
    }

    void enableBtn() {
        EcardGUI.btn_myKing.setEnabled(true);
        EcardGUI.btn_mySlav.setEnabled(true);
        EcardGUI.btn_myCtzn1.setEnabled(true);
        EcardGUI.btn_myCtzn2.setEnabled(true);
        EcardGUI.btn_myCtzn3.setEnabled(true);
        EcardGUI.btn_myCtzn4.setEnabled(true);
    }

    void disableBtn() {
        EcardGUI.btn_myKing.setEnabled(false);
        EcardGUI.btn_mySlav.setEnabled(false);
        EcardGUI.btn_myCtzn1.setEnabled(false);
        EcardGUI.btn_myCtzn2.setEnabled(false);
        EcardGUI.btn_myCtzn3.setEnabled(false);
        EcardGUI.btn_myCtzn4.setEnabled(false);
    }

    //수신하는 쓰레드
    class Listener extends Thread{
        Socket sc;
        DataInputStream dis;

        Listener(Socket sc){
            this.sc = sc;
            try {
                dis = new DataInputStream(sc.getInputStream());
            } catch (IOException ie) {
            }
        }

        public void run(){
            while(dis !=null){
                try {
                    String msg = dis.readUTF();
                    System.out.println(msg);
                    //먼저 들어온 플레이어에게 왕 카드 셋팅
                    if(msg.startsWith("//King ") && msg.indexOf(cardHost.get(0)) != -1){
                        EcardGUI.btn_mySlav.setVisible(false);
                        EcardGUI.btn_myKing.setVisible(true);
                        EcardGUI.jKing.setVisible(false);
                        EcardGUI.jSlave.setVisible(true);
                        EcardGUI.myScore2.setVisible(false);
                        EcardGUI.myScore1.setVisible(true);
                        EcardGUI.yourScore2.setVisible(false);
                        EcardGUI.yourScore1.setVisible(true);
                        
                        
                    }else if(msg.startsWith("//Slav ") && msg.indexOf(cardHost.get(0)) != -1){
                        EcardGUI.btn_myKing.setVisible(false);
                        EcardGUI.btn_mySlav.setVisible(true);
                        EcardGUI.jSlave.setVisible(false);
                        EcardGUI.jKing.setVisible(true);
                        EcardGUI.myScore1.setVisible(false);
                        EcardGUI.myScore2.setVisible(true);
                        EcardGUI.yourScore1.setVisible(false);
                        EcardGUI.yourScore2.setVisible(true);
                        
                    }
                    if(msg.startsWith("//SList")){
                        playerName = msg.substring(7, msg.indexOf(" "));
                        playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                        playerIdx = msg.substring(msg.indexOf("#") + 1);
                        updateClientList();
                        EcardGUI.btn_Ready.setEnabled(true); 
    
                    }else if(msg.startsWith("//Start")){
                        enableBtn();
                        gameStart = true;
                        EcardGUI.text_chatLog.append("Game Start"+ "\n");
                        pln("Game Start");
                    }else if(msg.startsWith("//Timer")){
                        EcardGUI.jTimer.setText(msg.substring(7));
                        //pln(msg.substring(7));
                    }else{
                        EcardGUI.text_chatLog.append(msg + "\n");
                    }
                } catch (IOException io) {
                    EcardGUI.text_chatLog.append("[ 서버와의 연결이 끊어졌습니다. ]\n[ 3초 후 프로그램을 종료합니다 .. ]");     
                    try{
                        Thread.sleep(3000);         
                        System.exit(0);
                    }catch (InterruptedException ite) {
                        System.out.println(ite);
                    }
                }
            }
       
        }
        
    }


    //내부클래스 -- 닉네임과 채팅 송신
    public class Sender extends Thread implements KeyListener, ActionListener{
        Socket sc;
        String chatID0;
        String msg;

        Sender(Socket sc, String chatID){
            this.sc = sc;
            this.chatID0 = chatID;
            try {
                dos = new DataOutputStream(this.sc.getOutputStream());
            } catch (Exception e) {
            }           
        }

        public void run(){
            try {
                dos.writeUTF(chatID0);
                cardHost.add(chatID0);
            } catch (IOException ie) {
            }
        }

        public void keyPressed(KeyEvent ke){
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                msg = EcardGUI.text_msg.getText();
                System.out.println(msg);
                EcardGUI.text_msg.setText("");
                try {
                    dos.writeUTF("//Chat "+chatID0+">> "+msg);
                    dos.flush();
                } catch (IOException ie) {
                }
            }
        }
        public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}

        public void actionPerformed(ActionEvent e){
            if(e.getSource() ==  EcardGUI.btn_Ready) {
                try {
                    dos.writeUTF("//Ready");
                    dos.flush();
                    EcardGUI.btn_Ready.setEnabled(false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource() == EcardGUI.btn_myKing){
                try {
                    dos.writeUTF("//Press"+"//King"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <King> 카드입니다 .. ] \n");
                    EcardGUI.btn_myKing.setEnabled(false);
                    dos.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource() == EcardGUI.btn_mySlav){
                try {
                    dos.writeUTF("//Press"+"//Slav"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <Slave> 카드입니다 .. ] \n");
                    EcardGUI.btn_mySlav.setEnabled(false);
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn1){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <citizen> 카드입니다 .. ] \n");
                    EcardGUI.btn_myCtzn1.setEnabled(false);
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn2){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <citizen> 카드입니다 .. ] \n");
                    EcardGUI.btn_myCtzn2.setEnabled(false);
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn3){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <citizen> 카드입니다 .. ] \n");
                    EcardGUI.btn_myCtzn3.setEnabled(false);
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn4){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ 당신이 선택한 카드는 <citizen> 카드입니다 .. ] \n");
                    EcardGUI.btn_myCtzn4.setEnabled(false);
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }




}



// EcardGUI.enterBtn.addActionListener(new Sender(sc, chatID));
// EcardGUI.clearBtn.addActionListener(new Sender(sc, chatID));
// EcardGUI.exitBtn.addActionListener(new Sender(sc, chatID));


// EcardGUI.inputName.addKeyListener(new KeyAdapter(){
//     public void keyPressed(KeyEvent ke){
//         if(ke.getKeyCode() == KeyEvent.VK_ENTER){//엔터 누르면 실행
//             ClientGUI.chatLog.append("서버에연결되었습니다 \n");
//             chatID = ClientGUI.inputName.getText(); //입력받은 텍스트를 아이디로 저장
//             sender = new Sender(sc, chatID);
            
//         }
//     }
// });


// ClientGUI.inputMsg.addKeyListener(new KeyAdapter(){
//     public void keyPressed(KeyEvent ke2){
//         if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
//             msg = ClientGUI.inputMsg.getText();
//             System.out.println(msg);
//             sender.send(msg); //내부클래스의 송신 메소드 호출
//             ClientGUI.inputMsg.setText("");
//         }
//     }
// });