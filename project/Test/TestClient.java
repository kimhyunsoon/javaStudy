package Test;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class TestClient extends JFrame implements ActionListener{ 

    //GUI 관련
    Container cp;
    JPanel btnPad, msgPad;
    JTextField inputMsg;
    static JTextArea chatLog;
    JButton enterBtn, btn01, btn02, btn03;
    static private final String newline = "\n"; //개행

    //서버연결부분
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    String chatId;
    String msg; 
    Sender sender;
    
    public TestClient(){

        setPanel();
        //메세지 입력창 키보드 입력이벤트
        inputMsg.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke2){
                if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                    try {
                        sc = new Socket(ip,port);
                        chatLog.append("서버에연결되었습니다 \n");
                        chatId = inputMsg.getText();
                        sender = new Sender(sc,chatId);
                        Thread th1 = new TestReceiver(sc);
                        th1.start();
                        msg = inputMsg.getText();
                        System.out.println(msg);
                        sender.sendMsg(msg); //내부클래스의 송신 메소드 호출
                        inputMsg.setText("");
                        
                    } catch (Exception e) {
                        //TODO: handle exception
                    }

                }
            }
        });

        setUI();

        enterBtn.addActionListener(this);
        btn01.addActionListener(this);
        btn02.addActionListener(this);
        btn03.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btn01){
            

        }

    }

    
    void setPanel(){
        cp = getContentPane();
        enterBtn = new JButton("전송");
        btn01 = new JButton("왕");
        btn02 = new JButton("노예");
        btn03 = new JButton("시민");

        btnPad = new JPanel();
        msgPad = new JPanel();

        inputMsg = new JTextField("닉네임을 입력하세요"); //메세지 입력 텍스트필드
        chatLog = new JTextArea(); //메세지 출력창
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //메세지 출력창에 스크롤바 생성

        btnPad.add(btn01);
        btnPad.add(btn02);
        btnPad.add(btn03);

        
        msgPad.setLayout(new BorderLayout());
        msgPad.add(inputMsg,BorderLayout.NORTH);
        msgPad.add(enterBtn,BorderLayout.SOUTH);
        msgPad.add(chatLog,BorderLayout.CENTER);


        setLayout(new GridLayout(1,2));
        cp.add(btnPad);
        cp.add(msgPad);

        setUI();
    }

    void setUI(){
		setTitle("FileChooser");
		setSize(600, 300);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args ) {
        new TestClient();
        
    }

    public class Sender{

        Socket sc;
        String name;
        DataOutputStream dos;

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
                    dos.writeUTF(chatId+">> "+msg);
                    dos.flush();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }

        }
    }
    
}
