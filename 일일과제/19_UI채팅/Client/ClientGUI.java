import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import jdk.internal.platform.Container;

public class ClientGUI extends JFrame implements Runnable{//JFrame ���
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

        enterBtn = new JButton("����");
        
        
        
        
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
























    void connect(){     //�����ϰ�, Ű����� �Է��ؼ� socket���� ����
        try {
            p("����IP �Է�(�⺻:127.0.0.1) : ");
            ip = br.readLine();
            ip = ip.trim();
            if(ip.length()==0) ip = "127.0.0.1";
            p("PORT �Է�(�⺻ : 3000) : ");
            String strPort = br.readLine();
            strPort = strPort.trim();
            if(strPort.length()==0) strPort = "3000"; 
            port = Integer.parseInt(strPort);
            sc = new Socket(ip,port);
            pln("������ ����Ǿ����ϴ�.");
            //open Stream
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);


        } catch (UnknownHostException ue) {
            pln("�ش� ������ ã�� ����");
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
            pln("���� �ٿ�.. 2�� �Ŀ� ����˴ϴ�.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
        } finally{
            closeAll();
        }

    }

    void speak(){ //Ű����->socket �޼ҵ�
        p("ä��ID(�⺻ : Guest): ");
        try {
            name = br.readLine();
            name = name.trim();
            if(name.length() == 0) name = "Guest";
            dos.writeUTF(name);
            //ù���� �Է¹޾� ä��ID�� ����
            dos.flush();
            inputMSG();
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

    void inputMSG(){ //Ű���� �Է¹޴� �޼ҵ�
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
