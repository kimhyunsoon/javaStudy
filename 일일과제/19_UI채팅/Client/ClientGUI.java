import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import jdk.internal.platform.Container;

public class ClientGUI extends JFrame implements Runnable{//JFrame 상속
    Socket sc;
    String ip;
    int port;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String name;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    Container cp;
    JPanel jp;
    JTextField jtf;
    JTextArea chatLog;
    JButton clearBtn, enterBtn, exitBtn;

    
    void setPanel(){
        cp = getContentPane();
        jp = new JPanel();
        chatLog = new JTextArea();
        chatLog.setMargin(new Insert(5,5,5,5));
        chatlog.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatLog);

        enterBtn = new JButton("입장");
        
        
        
        
    }






    ClientGUI(){
        connect();
        start();
        speak();
    }



    void setUI(){
		setTitle("Chat GUI Test Ver 1.0");
		setSize(700, 450);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
























    void connect(){     //접속하고, 키보드로 입력해서 socket으로 보냄
        try {
            p("서버IP 입력(기본:127.0.0.1) : ");
            ip = br.readLine();
            ip = ip.trim();
            if(ip.length()==0) ip = "127.0.0.1";
            p("PORT 입력(기본 : 3000) : ");
            String strPort = br.readLine();
            strPort = strPort.trim();
            if(strPort.length()==0) strPort = "3000"; 
            port = Integer.parseInt(strPort);
            sc = new Socket(ip,port);
            pln("서버에 연결되었습니다.");
            //open Stream
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);


        } catch (UnknownHostException ue) {
            pln("해당 서버를 찾지 못함");
            connect();
        } catch(IOException ie){
            connect();
        }

    }

    public void run(){ //socket -> monitor
        try {
            while(true){
                String msg = dis.readUTF();
                pln(msg);
            }
        } catch (IOException ie) {
            pln("서버 다운.. 2초 후에 종료됩니다.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
        } finally{
            closeAll();
        }

    }

    void speak(){ //키보드->socket 메소드
        p("채팅ID(기본 : Guest): ");
        try {
            name = br.readLine();
            name = name.trim();
            if(name.length() == 0) name = "Guest";
            dos.writeUTF(name);
            //첫줄을 입력받아 채팅ID로 저장
            dos.flush();
            inputMSG();
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

    void inputMSG(){ //키보드 입력받는 메소드
        try {
            while(true){
                String msg = br.readLine();
                dos.writeUTF(name+">> "+msg);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

    void closeAll(){
        try {
            if(dis != null) dis.close();
            if(dos !=null) dos.close();
            if(is != null) is.close();
            if(os != null) os.close();
            if(sc != null) sc.close();
        } catch (IOException ie) {}
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
