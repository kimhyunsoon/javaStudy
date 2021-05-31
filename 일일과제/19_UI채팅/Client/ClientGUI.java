import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ClientGUI extends JFrame{//JFrame 상속

    Container cp;
    JLabel label;
    JPanel northPad, southPad;
    JTextField inputName, inputMsg;
    JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;
    static private final String newline = "\n";
    String name;

    //서버연결부분
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

        inputName = new JTextField("닉네임을 입력해 주세요",20);
        inputName.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt) {
                name = inputName.getText();
                pln(name);
                try {
                    sc = new Socket(ip,port);
                    pln("서버에 연결되었습니다.");

                } catch (UnknownHostException ue) {
                    pln("해당 서버를 찾지 못함");
                } catch(IOException ie){}

        

                // inputName.selectAll ();
                inputName.setEditable (false); //입력받은 후에 수정 불가하게 바꿈
            }


        });


        
        Listen listen = new Listen(this,sc);
        listen.start();
        Send send = new Send(this,name,sc);
        send.start();




        enterBtn = new JButton("입장");
        enterBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                enterBtn.setText("퇴장");
                pln("sdf");
                
            }
        });




        clearBtn = new JButton("clear");
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
                pln("sdfasdf");
            }
        });

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

class Listen extends Thread{ //수신쓰레드
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
            System.out.println("서버 다운.. 2초 후에 종료됩니다.");
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