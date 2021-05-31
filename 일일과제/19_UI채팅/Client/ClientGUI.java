import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame implements ActionListener{
    //ActionListener, Runnable �������̽��� ������ ��ü�� �����ؾ� ��
    Sender sender;

    //GUI��
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName, inputMsg;
    static JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n";
    Boolean connect = false;

    //��������κ�
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    String chatId;
    String msg, msg1; 


    public ClientGUI(){

        cp = getContentPane();
        enterBtn = new JButton("����");
        exitBtn = new JButton("����");
        clearBtn = new JButton("clear");
        inputName = new JTextField(20); //�г��� �Է�
        inputMsg = new JTextField("�޼����� �Է��ϼ���"); //�޼��� �Է�
        northPad = new JPanel();
        southPad = new JPanel();


        chatLog = new JTextArea(); //�޼��� ���
        chatLog.setMargin(new Insets(5,5,5,5));
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog); //�޼��� ���â�� ��ũ�ѹ� ����

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

        // Ŭ���̾�Ʈ ��ü ����, ������ ȣ��
        new ClientGUI();

    }

    public void actionPerformed(ActionEvent e){
        //�����ư Ŭ��������
        if(e.getSource() == enterBtn){
            if(!connect){
                try {
                    sc = new Socket(ip,port);
                    System.out.println("������ ����Ǿ����ϴ�/");
                    chatLog.append("����������Ǿ����ϴ� \n");
                
                    sender = new Sender(sc,chatId);
                    Thread th2 = new ReceiverThread(sc);
                    th2.start();

                } catch (IOException ie) {
                    //TODO: handle exception
                }

            }
        }
    }

    //���ϻ��� ����Ŭ����
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

