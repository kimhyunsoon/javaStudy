import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame{//JFrame ���

    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName, inputMsg;
    JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n";
    String name;

    //��������κ�
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;



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
                name = inputName.getText();
                pln(name);
                try {
                    sc = new Socket(ip,port);
                    pln("������ ����Ǿ����ϴ�.");

                } catch (UnknownHostException ue) {
                    pln("�ش� ������ ã�� ����");
                } catch(IOException ie){}

        

                // inputName.selectAll ();
                inputName.setEditable (false); //�Է¹��� �Ŀ� ���� �Ұ��ϰ� �ٲ�
            }


        });


        
        Listen listen = new Listen(this,sc);
        listen.start();
        Send send = new Send(this,name,sc);
        send.start();




        enterBtn = new JButton("����");
        enterBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                enterBtn.setText("����");
                pln("sdf");
                
            }
        });




        clearBtn = new JButton("clear");
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
                pln("sdfasdf");
            }
        });

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

class Listen extends Thread{ //���ž�����
    InputStream is;
    DataInputStream dis;

    ClientGUI cg;
    Socket sc;

    Listen(ClientGUI cg,Socket sc){
        this.cg = cg;
        this.sc = cg.sc;
    }

    public void run(){
        try {
            dis = new DataInputStream(sc.getInputStream());
            while(true){
                String msg = dis.readUTF();
                System.out.println(msg);

            }
        } catch (IOException ie) {
            System.out.println("���� �ٿ�.. 2�� �Ŀ� ����˴ϴ�.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
        } finally{
            try {
                if(dis != null) dis.close();

            } catch (IOException ie) {
                //TODO: handle exception
            }
        }
    }
}

class Send extends Thread{

    OutputStream os;
    DataOutputStream dos;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    ClientGUI cg;
    String name;
    Socket sc;

    Send(ClientGUI cg, String name, Socket sc){
        this.cg = cg;
        this.name = cg.name;
    }

    public void run(){
        try {
            dos = new DataOutputStream(sc.getOutputStream());
            while(true){
                String msg = br.readLine();
                dos.writeUTF(name+">> "+msg);
                cg.chatLog.append (msg);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
        
    }
    void closeAll(){
        try {

            if(dos !=null) dos.close();
            if(sc != null) sc.close();
        } catch (IOException ie) {}
    }

    
    

}