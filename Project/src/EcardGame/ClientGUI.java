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

    //GUI ����
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName;
    JTextField inputMsg;
    static JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n"; //����

    //��������κ�
    Socket sc;
    String ip = "127.0.0.1";
    int port = 4500;

    String chatId;
    String msg; 


    public ClientGUI(){

        setPanel();

        //�г��� �Է�â Ű���� �Է��̺�Ʈ
        inputName.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){//���� ������ ����
                    try {
                        northPad.add(exitBtn);
                        //enterBtn.setEnabled(false);
                        sc = new Socket(ip,port);
                        chatLog.append("����������Ǿ����ϴ� \n");
                        chatId = inputName.getText(); //�Է¹��� �ؽ�Ʈ�� ���̵�� ����
                        sender = new Sender(sc,chatId); //����Ŭ���� �����Ͽ� ���ϰ� ���̵� �ѱ�
                        Thread th1 = new ReceiverThread(sc); //�����κ��� ���Ź޴� ������ ȣ��
                        th1.start();


                        inputName.setEditable(false); //��Ȱ��ȭ��Ŵ
                        inputMsg.requestFocus(); //��Ŀ���� �޼����Է�â���� �̵���Ŵ

                    } catch (IOException ie) {
                        //TODO: handle exception
                    }
                }
            }
        });

        //�޼��� �Է�â Ű���� �Է��̺�Ʈ
        inputMsg.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke2){
                if(ke2.getKeyCode()== KeyEvent.VK_ENTER){
                    msg = inputMsg.getText();
                    System.out.println(msg);
                    sender.sendMsg(msg); //����Ŭ������ �۽� �޼ҵ� ȣ��
                    inputMsg.setText("");
                }
            }
        });

        //�ؽ�Ʈ�ʵ� ��Ŀ�� �̺�Ʈ
        inputMsg.addFocusListener(new FocusAdapter(){
            //�ؽ�Ʈ�ʵ忡 ��Ŀ���� ���� �� �ʵ带 ��������
            public void focusGained(FocusEvent e){
                inputMsg.setText("");
            }
        });

        setUI();
        enterBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        
        



    }

    

    //��ư �׼��̺�Ʈ
    public void actionPerformed(ActionEvent e){
        //1. �����ư �̺�Ʈ
        if(e.getSource() == enterBtn){
            try {
                dos.writeUTF("//Timer"+"//King"+chatId);
                dos.flush();
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
        //2. Ŭ�����ư �̺�Ʈ
        if(e.getSource() == clearBtn){
            try {
                dos.writeUTF("//Timer"+"//Ctzn"+chatId);
                dos.flush();
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
        //3. �����ư �̺�Ʈ
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
        enterBtn = new JButton("Ȳ��");
        exitBtn = new JButton("�뿹");
        clearBtn = new JButton("�ù�");
        inputName = new JTextField(20); //�г��� �Է� �ؽ�Ʈ�ʵ�
        inputMsg = new JTextField("�޼����� �Է��ϼ���",30); //�޼��� �Է� �ؽ�Ʈ�ʵ�
        northPad = new JPanel();
        southPad = new JPanel();
        label = new JLabel("MY ID ");

        chatLog = new JTextArea(); //�޼��� ���â
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //�޼��� ���â�� ��ũ�ѹ� ����

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

        //������ �޼��� �ѱ�
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

