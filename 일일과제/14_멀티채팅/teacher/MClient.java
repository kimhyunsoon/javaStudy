import java.io.*;
import java.net.*;

class MClient extends Thread {
	Socket s;
	String ip = "127.0.0.1"; //�ڽ��� ���� 
	//String ip = "192.168.1.15"; //��� �л�
	//String ip = "123.142.144.46"; //���� �л� 
	int port = 3000;
	OutputStream os;
	InputStream is;
	DataInputStream dis;
	DataOutputStream dos;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String chatId;

	MClient(){
		connect();
	}
	void connect(){
		try{
			p("����IP(�⺻:127.0.0.1): ");
			String ip = br.readLine();
			ip = ip.trim();
			if(ip.length() == 0) ip = "127.0.0.1";

			p("PORT(�⺻:3000): ");
			String portStr = br.readLine();
			portStr = portStr.trim();
			if(portStr.length() == 0) portStr="3000";
			int port = Integer.parseInt(portStr);
			if(port<0 || port>65535){
				pln("������ ��ȿ���� ���� ��Ʈ �Ф�");
				connect();
				return;
			}

			s = new Socket(ip, port);
			pln("������ ���� ����!!");
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			start();
			speak();
		}catch(UnknownHostException ne){
			pln("�ش� ������ ã�� ����");
			connect();
		}catch(IOException ie){
			connect();
		}catch(NumberFormatException ne){
			pln("���� ������ ��Ʈ�� �ƴ� �Ф�");
			connect();
		}
	}
	public void run(){ //listen ( socket -> monitor ) 
		try{
			while(true){
				String msg = dis.readUTF();
				pln(msg);
			}
		}catch(IOException ie){
			pln("���� �ٿ�.. 2�� �Ŀ� ����˴ϴ�.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
		}finally{
            closeAll();
		}
	}
	void speak(){ //speak ( keyboard -> socket ) 
        p("ä��ID(�⺻:GUEST): ");
		try{
			chatId = br.readLine();
			chatId = chatId.trim();
			if(chatId.length() == 0) chatId = "GUEST";
			dos.writeUTF(chatId);
			dos.flush();

			inputMsg();
		}catch(IOException ie){
			pln("speak() ie: " + ie);
		}
	}
	void inputMsg(){
		try{
			while(true){
				String msg = br.readLine();
				dos.writeUTF(chatId+">> "+msg);
				dos.flush();
			}
		}catch(IOException ie){
		}finally{
			closeAll();
		}
	}
	void closeAll(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(s != null) s.close();
		}catch(IOException ie){}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new MClient();
	}
}