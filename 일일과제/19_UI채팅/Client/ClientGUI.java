import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame implements ActionListener{//JFrame ���

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

        inputName = new JTextField("�г����� �Է��� �ּ���",20);
        inputName.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt) {
                String name = inputName.getText();
                mc = new MainClient(this);
                MyRunnable runnable = new MyRunnable();
                Thread th1 = new Thread(runnable);
                th1.start();

                //chatLog.append ();
                // inputName.selectAll ();
                inputName.setEditable (false); //�Է¹��� �Ŀ� ���� �Ұ��ϰ� �ٲ�
            }
        });


        enterBtn = new JButton("����");
        enterBtn.addActionListener(this);
        exitBtn = new JButton("����");
        exitBtn.addActionListener(this);
        clearBtn = new JButton("clear");
        clearBtn.addActionListener(this);

        inputMsg = new JTextField("�޼����� �Է��ϼ���");


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
        //Handle ���� Button action.
        if(e.getSource() == enterBtn){


        }
        //Handle ���� Button action
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