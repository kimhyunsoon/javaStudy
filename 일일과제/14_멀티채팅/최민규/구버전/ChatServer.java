import java.io.*;
import java.util.*;
import java.net.*;
public class ChatServer{
	Socket s;
	int port = 3000;
	ServerSocket ss;
	int userCount;
	static Hashtable<CreateSocket, String> userList = new Hashtable<CreateSocket, String>();
	static Map<CreateSocket, String> map = Collections.synchronizedMap(userList);
	ChatServer() {
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void serverOn() {
		try {
				System.out.println("서버접속 대기중 port :" + port);
			while(true) {
				
				s = ss.accept();
				System.out.println(s.getInetAddress().getHostAddress() + "에서 접속되었습니다.");
				CreateSocket cs = new CreateSocket(s);
				cs.inThread.start();
				cs.outThread.start();
				userCount++;
				userList.put(cs, "user"+String.valueOf(userCount));	//인풋 아웃풋 모든것을 처리하는 CreateSocket의 객체를 담음 !?!?
				cs.setName(userList.get(cs));
				if(!(map.isEmpty())) {
					PrintWriter pw = null;
					String name = cs.getName();
					for(CreateSocket item : map.keySet()) {
						pw = new PrintWriter(item.s.getOutputStream(),true);
						pw.println(name + "님이 입장 하셨습니다.");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		Thread th = new Thread(new Runnable(){
			public void run() {
				server.serverOn();
			}
		});
		th.start();
	}
}
class CreateSocket {
	private String name = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Socket s;
	Thread inThread = new Thread(new Runnable() {
		public void run() {
			socketIn();
		}
	});

	Thread outThread = new Thread(new Runnable() {
		public void run() {
			socketOut();
		}
	});

	CreateSocket(Socket s) {
		this.s = s;
	}
	void socketIn() {
		DataInputStream dis = null;
		PrintWriter pw = null;
		try {
			dis = new DataInputStream(s.getInputStream());
			
			String chatr = "";
			while(true) {
				chatr = dis.readUTF();
				System.out.println(ChatServer.userList.get(this)+" : "+chatr);
				//
				for(CreateSocket item :ChatServer.map.keySet()) {
					pw = new PrintWriter(item.s.getOutputStream(),true);
					if(!(ChatServer.map.get(item).equals(this.name))) {
						pw.println(ChatServer.userList.get(this) + ":" + chatr);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("클라이언트"+ChatServer.map.get(this)+"의 연결이 끊겼습니다 !");
			try {
				for(CreateSocket item :ChatServer.map.keySet()) {
					pw = new PrintWriter(item.s.getOutputStream(),true);
					pw.println(ChatServer.map.get(this)+"님이 접속을 종료하셨습니다.!");
					
				}
			} catch (IOException e1) {
				System.out.println("유저에게 클라이언트 접속해제를 전달하는중 에러가 발생했습니다.");
			}
			ChatServer.map.remove(this);
		} finally {
			try {
				if(dis!=null) dis.close();
				if(s.getInputStream()!=null) s.getInputStream().close();
			} catch (IOException e) {
				System.out.println("클라이언트 디스커넥트 완료");
			}
		}
	}
	
	void socketOut() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true) {
				String chatw = br.readLine();
				pw.println("공지사항 :" + chatw);
			}
		} catch (IOException e) {
			
		} finally {
			try {
				if(pw!=null) pw.close();
				if(s.getOutputStream()!=null) s.getOutputStream().close();
			} catch (IOException e) {
				
			}
		}
	}
	
	
}