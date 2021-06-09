package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/*import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {
	Socket s;
	OutputStream os;
	InputStream is;
	DataOutputStream dos;
	DataInputStream dis;
	int port = 4003;
	//String IP;
	ClientTest(EcardGUI eg){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void startChat() {
		String nickName = Login.nickName;
		String ip = Login.IP1;
		
		try {
			Socket s = new Socket(ip,port);
			Sender sender = new Sender(s, nickName);
			Listener listener = new Listener(s);
			new Thread(sender).start();
			
		}catch(IOException ie) {}
	}
}


class Sender extends Thread{
	Sender(Socket s, String nickName) {
	}
}*/