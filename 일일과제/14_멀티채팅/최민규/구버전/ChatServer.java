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
				System.out.println("�������� ����� port :" + port);
			while(true) {
				
				s = ss.accept();
				System.out.println(s.getInetAddress().getHostAddress() + "���� ���ӵǾ����ϴ�.");
				CreateSocket cs = new CreateSocket(s);
				cs.inThread.start();
				cs.outThread.start();
				userCount++;
				userList.put(cs, "user"+String.valueOf(userCount));	//��ǲ �ƿ�ǲ ������ ó���ϴ� CreateSocket�� ��ü�� ���� !?!?
				cs.setName(userList.get(cs));
				if(!(map.isEmpty())) {
					PrintWriter pw = null;
					String name = cs.getName();
					for(CreateSocket item : map.keySet()) {
						pw = new PrintWriter(item.s.getOutputStream(),true);
						pw.println(name + "���� ���� �ϼ̽��ϴ�.");
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
			System.out.println("Ŭ���̾�Ʈ"+ChatServer.map.get(this)+"�� ������ ������ϴ� !");
			try {
				for(CreateSocket item :ChatServer.map.keySet()) {
					pw = new PrintWriter(item.s.getOutputStream(),true);
					pw.println(ChatServer.map.get(this)+"���� ������ �����ϼ̽��ϴ�.!");
					
				}
			} catch (IOException e1) {
				System.out.println("�������� Ŭ���̾�Ʈ ���������� �����ϴ��� ������ �߻��߽��ϴ�.");
			}
			ChatServer.map.remove(this);
		} finally {
			try {
				if(dis!=null) dis.close();
				if(s.getInputStream()!=null) s.getInputStream().close();
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ ��Ŀ��Ʈ �Ϸ�");
			}
		}
	}
	
	void socketOut() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true) {
				String chatw = br.readLine();
				pw.println("�������� :" + chatw);
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