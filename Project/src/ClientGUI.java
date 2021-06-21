package ecardGame;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.util.LinkedList;
import ecardGame.ClientThread;

public class ClientGUI extends JFrame{

    public static ClientThread ccThread;
    public static ClientGUI clientGUI;

    
    //GUI ����
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    static JTextField inputName;
    static JTextField inputMsg;
    static JTextArea chatLog;
    static JButton clearBtn;
	static JButton enterBtn;
	static JButton exitBtn;
    static private final String newline = "\n"; //����

    String chatId;
    String msg;

    public ClientGUI(){

        setPanel();



        setUI();
        try {
            ccThread = new ClientThread(clientGUI);
            ccThread.start();
        } catch (Exception e) {
            //TODO: handle exception
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
        northPad.add(exitBtn);

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

        clientGUI = new ClientGUI();



    }
}

