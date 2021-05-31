import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame implements ActionListener{//JFrame 상속

    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName, inputMsg;
    JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n";
    MainClient mc;


    ClientGUI(){
        setPanel();
    }


    void setPanel(){
        cp = getContentPane();
        chatLog = new JTextArea();
        chatLog.setMargin(new Insets(5,5,5,5));
        chatLog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog);

        inputName = new JTextField("닉네임을 입력해 주세요",20);
        inputName.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt) {
                String name = inputName.getText();
                mc = new MainClient(this);
                MyRunnable runnable = new MyRunnable();
                Thread th1 = new Thread(runnable);
                th1.start();

                //chatLog.append ();
                // inputName.selectAll ();
                inputName.setEditable (false); //입력받은 후에 수정 불가하게 바꿈
            }
        });


        enterBtn = new JButton("입장");
        enterBtn.addActionListener(this);
        exitBtn = new JButton("퇴장");
        exitBtn.addActionListener(this);
        clearBtn = new JButton("clear");
        clearBtn.addActionListener(this);

        inputMsg = new JTextField("메세지를 입력하세요");


        northPad = new JPanel();
        southPad = new JPanel();

        northPad.add(inputName);
        northPad.add(enterBtn);
        southPad.add(inputMsg);
        southPad.add(clearBtn);



        
        
        //northPad.add(exitBtn);

        cp.add(northPad, BorderLayout.NORTH);
        cp.add(chatLog, BorderLayout.CENTER);
        cp.add(southPad, BorderLayout.SOUTH);
        setUI();
         
    }

    
    
    
    public void actionPerformed(ActionEvent e){
        //Handle 입장 Button action.
        if(e.getSource() == enterBtn){


        }
        //Handle 퇴장 Button action
        if(e.getSource() == exitBtn){

        }
    }

    void setUI(){
		setTitle("Chat GUI Test Ver 1.0");
		setSize(400, 450);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
    
}

class MyRunnable implements Runnable{

    ClientGUI cg;
    
    void init(ClientGUI cg){
        this.cg = cg;
    }
    
    public void run(){
        new MainClient();

    }




}