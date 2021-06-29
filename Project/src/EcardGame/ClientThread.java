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
    Sender sender; //����Ŭ���� Sender    
    Listener listener; //����Ŭ���� Listener
    int port = 4003;
    DataInputStream dis;
    DataOutputStream dos;
    String chatID;
    String msg;
    String ip;
    boolean gameStart; 
    String playerName, playerScore, playerIdx; 
    Login login;
    public static LinkedList<String> cardHost = new LinkedList<String>();

    
    public void startChat(){//ä�� ���� ����
        disableBtn(); //ī�� ��ư ��Ȱ��ȭ
        chatID = Login.nickName; // Login ���� nickName �� �޾ƿ�.
		ip = Login.IP; // Login ���� ip�� �޾ƿ�

        try {
            Socket sc = new Socket(ip,port);
            sender = new Sender(sc, chatID);
            listener = new Listener(sc);
            new Thread(sender).start();
            new Thread(listener).start();

            //<-------�̺�Ʈ������-------->
            EcardGUI.text_msg.addKeyListener(new Sender(sc, chatID));
			EcardGUI.btn_exit.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_Ready.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myKing.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_mySlav.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn1.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn2.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn3.addActionListener(new Sender(sc, chatID));
			EcardGUI.btn_myCtzn4.addActionListener(new Sender(sc, chatID));
        } catch (UnknownHostException ue){
            pln("ȣ��Ʈ�� ã�� �� ����");
        } catch (IOException ie) {
            pln("������ �����ִ°� ����");
			System.exit(0);
        }
    }

    //Ŭ���̾�Ʈ ���� ������Ʈ
    public void updateClientList(){
        if(Integer.parseInt(playerIdx)==0){
            EcardGUI.myScore1.setText(playerScore);
            EcardGUI.yourScore2.setText(playerScore);
        }else if(Integer.parseInt(playerIdx) == 1){
            EcardGUI.myScore2.setText(playerScore);
            EcardGUI.yourScore1.setText(playerScore);
        }
    }

    public void pln(String str){
        System.out.println(str);
    }

    //��ư Ȱ��ȭ
    void enableBtn() {
        EcardGUI.btn_myKing.setEnabled(true);
        EcardGUI.btn_mySlav.setEnabled(true);
        EcardGUI.btn_myCtzn1.setEnabled(true);
        EcardGUI.btn_myCtzn2.setEnabled(true);
        EcardGUI.btn_myCtzn3.setEnabled(true);
        EcardGUI.btn_myCtzn4.setEnabled(true);
    }

    //��ư ��Ȱ��ȭ
    void disableBtn() {
        EcardGUI.btn_myKing.setEnabled(false);
        EcardGUI.btn_mySlav.setEnabled(false);
        EcardGUI.btn_myCtzn1.setEnabled(false);
        EcardGUI.btn_myCtzn2.setEnabled(false);
        EcardGUI.btn_myCtzn3.setEnabled(false);
        EcardGUI.btn_myCtzn4.setEnabled(false);
    }

    void invisibleCard(){
        EcardGUI.jKing.setVisible(false);
        EcardGUI.jSlave.setVisible(false);
    }

    //���� ������
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
                    //���� ���� �÷��̾�� �� ī�� ����
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
                    if(msg.startsWith("//Chnge")){
                        String temp = msg.substring(7,13);
                        String cName = msg.substring(msg.indexOf(" ")+1);
                        // invisibleCard();
                        EcardGUI.btn_Ready.setEnabled(false);
                        if(temp.equals("//King") && cName.equals(cardHost.get(0))){
                            EcardGUI.btn_mySlav.setVisible(false);
                            EcardGUI.btn_myKing.setVisible(true);
                            EcardGUI.jKing.setVisible(false);
                            EcardGUI.jSlave.setVisible(true);
                            
                        }else if(temp.equals("//Slav") && cName.equals(cardHost.get(0))){
                            EcardGUI.btn_myKing.setVisible(false);
                            EcardGUI.btn_mySlav.setVisible(true);
                            EcardGUI.jSlave.setVisible(false);
                            EcardGUI.jKing.setVisible(true);
                        }
                    


                    }
                    if(msg.startsWith("//SList")){ //�÷��̾� ���� �޾ƿ�
                        playerName = msg.substring(7, msg.indexOf(" "));
                        playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                        playerIdx = msg.substring(msg.indexOf("#") + 1);
                        updateClientList();
                        EcardGUI.btn_Ready.setEnabled(true); 
    
                    }else if(msg.startsWith("//Start")){
                        enableBtn();
                        gameStart = true;
                        EcardGUI.text_chatLog.append("Game Start"+ "\n");
                    }else if(msg.startsWith("//Timer")){
                        EcardGUI.jTimer.setText(msg.substring(7));
                    }else{
                        EcardGUI.text_chatLog.append(msg + "\n");
                    }
                } catch (IOException io) {
                    EcardGUI.text_chatLog.append("[ �������� ������ ���������ϴ�. ]\n[ 3�� �� ���α׷��� �����մϴ� .. ]");     
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


    //����Ŭ���� -- �г��Ӱ� ä�� �۽�
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

        public void keyPressed(KeyEvent ke){ //ä���Է�
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
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <King> ī���Դϴ� .. ] \n");
                    disableBtn();
                    dos.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource() == EcardGUI.btn_mySlav){
                try {
                    dos.writeUTF("//Press"+"//Slav"+chatID0);
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <Slave> ī���Դϴ� .. ] \n");
                    disableBtn();
                    dos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn1){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <citizen> ī���Դϴ� .. ] \n");
                    disableBtn();
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn2){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <citizen> ī���Դϴ� .. ] \n");
                    disableBtn();
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn3){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <citizen> ī���Դϴ� .. ] \n");
                    disableBtn();
                    dos.flush();
                } catch (IOException e1) {
                    //TODO: handle exception
                }
            }
            if(e.getSource()== EcardGUI.btn_myCtzn4){
                try {
                    dos.writeUTF("//Press"+"//Ctzn"+chatID0);
                    EcardGUI.text_chatLog.append("[ ����� ������ ī��� <citizen> ī���Դϴ� .. ] \n");
                    disableBtn();
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


