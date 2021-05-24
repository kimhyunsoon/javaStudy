import java.io.*;
import java.net.*;


public class ChatClient {
	Socket s;
	String ip = "127.0.0.1";
	int port = 3000;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Thread inTh = new Thread(new Runnable() {
		public void run() {
			in();
		}
		
	});
	Thread outTh = new Thread(new Runnable() {
		public void run() {
			out();
		}
	});
	void connectServer() {
		try {
			s = new Socket(ip,port);
			System.out.println(ip + "에 성공적으로 연결되었습니다.");
			inTh.start();
			outTh.start();
			try {
				inTh.join();
				outTh.join();
			} catch (InterruptedException e) {
				System.out.println("서버와 연결이 끊겼습니다.");
				System.exit(0);
			}
		} catch (UnknownHostException e) {
			System.out.println("서버와 연결이 끊겼습니다.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 끊겼습니다.");
			System.exit(0);
		}
	}
	void in() {
		//DataInputStream dis = null;
		BufferedReader brServer = null;
		try {
			brServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String chat = "";
			while(true) {
				chat = brServer.readLine();
				System.out.println(chat);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("서버와 연결이 끊겼습니다.");
			System.exit(0);
		} finally {
			try {
				if (s.getInputStream() != null) s.getInputStream().close();
				if (brServer != null) brServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("서버와 연결이 끊겼습니다..in");
				System.exit(0);
			}
		}
		
	}
	void out() {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(s.getOutputStream());
			while(true) {
				String chat = br.readLine();
				dos.writeUTF(chat);
				dos.flush();
			}
		} catch (IOException e) {
			System.out.println("서버와 연결이 끊겼습니다..out");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		ChatClient cc = new ChatClient();
		cc.connectServer();
		
		
	}
}
