package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import project.EcardGUI;


public class EcardClient {
	Socket s;
	int port = 4005;
	String ip = "127.0.0.1";
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	Runnable r1 = new Listen(this);
	Thread t1 = new Thread(r1);
	EcardGUI eg;
	EcardClient(){
		try {
			//this.eg =eg;
			s= new Socket(ip,port);
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
	String msg1;
	public EcardClient(EcardGUI eg) {
		this.eg =eg;
		//this.msg1 = msg1;
		//cardChang();
		
		eg.btn_myKing.setVisible(true);
		new CardChange(eg,msg1);
		
	}
	void listen() {
		String msg="";
		while(true) {
			try {
				msg = dis.readUTF();
				if(msg.indexOf("//King")!=-1) {
					msg = "//King";
					
					//new EcardClient(null);
				}else
					System.out.println("노예를 받는다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		//try {
			//EcardClient ec = new EcardClient();
			//EcardGUI eg = new EcardGUI(ec);
			//EcardClient ec1 = new EcardClient(eg);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
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

class CardChange {
	EcardGUI eg;
	String msg1;
	CardChange(EcardGUI eg,String msg1){
		this.eg = eg;
		this.msg1 = msg1;
		//eg.text_chatLog.setText("ㅆㅃ!!!!!!!쫌 넘아가 제발 ㅠㅠㅠㅠㅠㅠㅠ");
		//eg.btn_myKing.setVisible(true);
		System.out.println(msg1);
	}
}

	



