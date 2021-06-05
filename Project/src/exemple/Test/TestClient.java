package Test;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class TestClient extends JFrame implements ActionListener{ 

    //GUI ����
    Container cp;
    JPanel btnPad, msgPad;
    JTextField inputMsg;
    static JTextArea chatLog;
    JButton enterBtn, btn01, btn02, btn03;
    static private final String newline = "\n"; //����

    //��������κ�
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    String chatId;
    String msg; 
    Sender sender;
    
    public TestClient(){

        setPanel();
        //�޼��� �Է�â Ű���� �Է��̺�Ʈ
        inputMsg.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke2){
                if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                    try {
                        sc = new Socket(ip,port);
                        chatLog.append("����������Ǿ����ϴ� \n");
                        chatId = inputMsg.getText();
                        sender = new Sender(sc,chatId);
                        Thread th1 = new TestReceiver(sc);
                        th1.start();
                        msg = inputMsg.getText();
                        System.out.println(msg);
                        sender.sendMsg(msg); //����Ŭ������ �۽� �޼ҵ� ȣ��
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
        enterBtn = new JButton("����");
        btn01 = new JButton("��");
        btn02 = new JButton("�뿹");
        btn03 = new JButton("�ù�");

        btnPad = new JPanel();
        msgPad = new JPanel();

        inputMsg = new JTextField("�г����� �Է��ϼ���"); //�޼��� �Է� �ؽ�Ʈ�ʵ�
        chatLog = new JTextArea(); //�޼��� ���â
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //�޼��� ���â�� ��ũ�ѹ� ����

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

        //������ �޼��� �ѱ�
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
