import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame implements ActionListener{
    //ActionListener, Runnable 인터페이스의 완전한 객체를 구현해야 함
    Sender sender;

    //GUI쪽
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName, inputMsg;
    static JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n";
    Boolean connect = false;

    //서버연결부분
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    String chatId;
    String msg, msg1; 


    public ClientGUI(){

        cp = getContentPane();
        enterBtn = new JButton("입장");
        exitBtn = new JButton("퇴장");
        clearBtn = new JButton("clear");
        inputName = new JTextField(20); //닉네임 입력
        inputMsg = new JTextField("메세지를 입력하세요"); //메세지 입력
        northPad = new JPanel();
        southPad = new JPanel();


        chatLog = new JTextArea(); //메세지 출력
        chatLog.setMargin(new Insets(5,5,5,5));
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //메세지 출력창에 스크롤바 생성

        northPad.add(inputName);
        northPad.add(enterBtn);
        southPad.add(inputMsg);
        southPad.add(clearBtn);

        cp.add(northPad, BorderLayout.NORTH);
        cp.add(chatLog, BorderLayout.CENTER);
        cp.add(southPad, BorderLayout.SOUTH);

        inputMsg.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                    msg = inputMsg.getText();
                    sender.sendMsg(msg);
                    inputMsg.setText("");
                }
            }
        });

        enterBtn.addActionListener(this);
        setUI();

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

        // 클라이언트 객체 생성, 생성자 호출
        new ClientGUI();

    }

    public void actionPerformed(ActionEvent e){
        //입장버튼 클릭했을때
        if(e.getSource() == enterBtn){
            if(!connect){
                try {
                    sc = new Socket(ip,port);
                    System.out.println("서버에 연결되었습니다/");
                    chatLog.append("서버에연결되었습니다 \n");
                
                    sender = new Sender(sc,chatId);
                    Thread th2 = new ReceiverThread(sc);
                    th2.start();

                } catch (IOException ie) {
                    //TODO: handle exception
                }

            }
        }
    }

    //소켓생성 내부클래스
    public class Sender{
        PrintWriter pw;
        Socket sc;
        String name;

        Sender( Socket sc, String name){
            this.sc = sc;
            this.name = name;

            try {
                pw = new PrintWriter(sc.getOutputStream());
                pw.println(name);
                pw.flush();
            } catch (Exception e) {
                //TODO: handle exception
            }

        }

        public void sendMsg(String Msg){
            if(pw != null){
                try {
                    pw.println(msg);
                    pw.flush();
    
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    }

}

