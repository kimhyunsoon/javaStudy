package EcardGame;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame implements ActionListener{

    Sender sender;
    DataOutputStream dos;

    //GUI 관련
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName;
    JTextField inputMsg;
    static JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n"; //개행

    //서버연결부분
    Socket sc;
    String ip = "127.0.0.1";
    int port = 4500;

    String chatId;
    String msg; 


    public ClientGUI(){

        setPanel();

        //닉네임 입력창 키보드 입력이벤트
        inputName.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){//엔터 누르면 실행
                    try {
                        northPad.add(exitBtn);
                        //enterBtn.setEnabled(false);
                        sc = new Socket(ip,port);
                        chatLog.append("서버에연결되었습니다 \n");
                        chatId = inputName.getText(); //입력받은 텍스트를 아이디로 저장
                        sender = new Sender(sc,chatId); //내부클래스 생성하여 소켓과 아이디 넘김
                        Thread th1 = new ReceiverThread(sc); //서버로부터 수신받는 쓰레드 호출
                        th1.start();


                        inputName.setEditable(false); //비활성화시킴
                        inputMsg.requestFocus(); //포커스를 메세지입력창으로 이동시킴

                    } catch (IOException ie) {
                        //TODO: handle exception
                    }
                }
            }
        });

        //메세지 입력창 키보드 입력이벤트
        inputMsg.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke2){
                if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                    msg = inputMsg.getText();
                    System.out.println(msg);
                    sender.sendMsg(msg); //내부클래스의 송신 메소드 호출
                    inputMsg.setText("");
                }
            }
        });

        //텍스트필드 포커스 이벤트
        inputMsg.addFocusListener(new FocusAdapter(){
            //텍스트필드에 포커스가 왔을 때 필드를 공백으로
            public void focusGained(FocusEvent e){
                inputMsg.setText("");
            }
        });

        setUI();
        enterBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        
        



    }

    

    //버튼 액션이벤트
    public void actionPerformed(ActionEvent e){
        //1. 입장버튼 이벤트
        if(e.getSource() == enterBtn){
            try {
                dos.writeUTF("//Timer"+"//King"+chatId);
                dos.flush();
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
        //2. 클리어버튼 이벤트
        if(e.getSource() == clearBtn){
            try {
                dos.writeUTF("//Timer"+"//Ctzn"+chatId);
                dos.flush();
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
        //3. 퇴장버튼 이벤트
        if(e.getSource() == exitBtn){
            try {
                dos.writeUTF("//Timer"+"//Slav"+chatId);
                dos.flush();
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }



    void setPanel(){
        cp = getContentPane();
        enterBtn = new JButton("황제");
        exitBtn = new JButton("노예");
        clearBtn = new JButton("시민");
        inputName = new JTextField(20); //닉네임 입력 텍스트필드
        inputMsg = new JTextField("메세지를 입력하세요",30); //메세지 입력 텍스트필드
        northPad = new JPanel();
        southPad = new JPanel();
        label = new JLabel("MY ID ");

        chatLog = new JTextArea(); //메세지 출력창
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //메세지 출력창에 스크롤바 생성

        northPad.add(label);
        northPad.add(inputName);
        northPad.add(enterBtn);

        southPad.add(inputMsg);
        southPad.add(clearBtn);

        cp.add(northPad, BorderLayout.NORTH);
        cp.add(chatLog, BorderLayout.CENTER);
        cp.add(southPad, BorderLayout.SOUTH);
    }

    void setUI(){
		setTitle("FileChooser");
		setSize(500, 800);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


    public static void main(String[] args) {

        new ClientGUI();

    }
    public class Sender{

        Socket sc;
        String name;


        Sender( Socket sc, String name){
            this.sc = sc;
            this.name = name;

            try {
                dos = new DataOutputStream(sc.getOutputStream());

                dos.writeUTF(name);
                dos.flush();
            } catch (Exception e) {
            }

        }

        //서버로 메세지 넘김
        public void sendMsg(String Msg){
            if(dos !=null){
                try {
                    dos.writeUTF("//Chat "+chatId+">> "+msg);
                    
                    dos.flush();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }

        }
    }

}

