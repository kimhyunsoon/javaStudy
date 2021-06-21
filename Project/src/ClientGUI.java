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

    
    //GUI 관련
    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    static JTextField inputName;
    static JTextField inputMsg;
    static JTextArea chatLog;
    static JButton clearBtn;
	static JButton enterBtn;
	static JButton exitBtn;
    static private final String newline = "\n"; //개행

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

