package EcardGame;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import EcardGame.EcardGUI;


public class EcardClient {
	Socket s;
	int port = 4004;
	String ip = "127.0.0.1";
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	Runnable r1 = new Listen(this);
	Thread t1 = new Thread(r1);
	EcardGUI eg;
	String playName;
	EcardClient(){
		try {
			//this.eg =eg;
			s= new Socket(ip,port);
			eg = new EcardGUI(this);
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			t1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void listen() {
		String msg="";
		while(true) {
			try {
				msg = dis.readUTF();
				String temp = msg.substring(0,7);
				if(temp.equals("//King ") || temp.equals("//Slav ")){
					filter(temp);
					//continue;
				}else {
					eg.text_chatLog.append("\n"+msg+"\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	void filter(String temp){
		String msg = temp;
		
       //String temp = msg.substring(0,7);
       //if(temp.startsWith("//King ")&& temp.startsWith("//Slav ")){
            if(msg.startsWith("//King ")) {
                msg = "//King ";
                System.out.println("황제");
                eg.btn_myKing.setVisible(true);
                eg.btn_yourSlav.setVisible(true);
                eg.btn_myBack.setVisible(false);
                eg.btn_yourBack.setVisible(false);
            }else if(msg.startsWith("//Slav ")) {
                msg = "//Slav ";
                System.out.println("노예");
                eg.btn_yourSlav.setVisible(true);
                eg.btn_myKing.setVisible(true);
                eg.btn_myBack.setVisible(false);
                eg.btn_yourBack.setVisible(false);
            }else {
            	System.out.println("sdfasdgasdgsda");
            }
        //}
    }
	void speak() {
		String msg = "";
		try {
			msg = eg.text_chatLog.getText();
			//eg.text_msg.setText("");
			dos.writeUTF(msg);
			dos.flush();
		}catch(IOException ie) {
		}
	}
	void speakchat() {
		String msg1 = "//Chat";
		String msg2 = "내용";
		try{
			msg2 = eg.text_msg.getText();
			dos.writeUTF(msg1+""+msg2);
			dos.flush();
			eg.text_chatLog.append(eg.text_msg.getText()+"\n");
		}catch(IOException ie) {
			
		}
	}
	void set() {
		
	}
	void speakready() {
		String msg = "//Ready";
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	void speakKing() {
		String msg = "//King";
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void speakSlav() {
		String msg = "//Slav";
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EcardClient ec = new EcardClient();
		//EcardGUI eg = new EcardGUI(ec);
		//EcardClient ec1 = new EcardClient(eg);
		//new CardChange(null, ec);
		Runnable r1 = new Listen(ec);
		Thread t1 = new Thread(r1);
		t1.start();
	}
}

class Listen implements Runnable{
	EcardClient ec;
	public Listen(EcardClient ec) {
		this.ec = ec;
	}
	@Override
	public void run() {
		ec.listen();
	}
}



class CardChange implements ActionListener {
	EcardGUI eg;
	EcardClient ec;
	CardChange(EcardGUI eg,EcardClient ec){
		this.eg = eg;
		this.ec = ec;
		//eg.btn_myKing.setVisible(true);
		eg.btn_myKing.addActionListener(eg);
	}
	void click() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==eg.btn_Ready) {
			eg.btn_myKing.setVisible(true);
		}
	}
}

class Test {
	EcardGUI eg;
	Test(EcardGUI eg){
		eg.btn_myKing.setVisible(true);
	} 
}

class Test2{
	EcardGUI eg;
	EcardClient ec;
	String msg;
}

	



