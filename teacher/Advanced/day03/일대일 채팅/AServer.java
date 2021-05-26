import java.io.*;
import java.net.*;

//well-known port: 0~1023��  
class AServer extends Thread {
	ServerSocket ss;
	Socket s;
	int port = 3000;
	String ipClient;
	OutputStream os;
	InputStream is;

	AServer(){
		try{
			ss = new ServerSocket(port); //0~65535�� 
			pln(port+"�� ��Ʈ���� ���� �����..");
			/*while(true){
				s = ss.accept();
				pln("Ŭ���̾�Ʈ("+s.getInetAddress().getHostAddress()+")�� ���� �Ϸ�!");
			}*/

            s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			is = s.getInputStream();
			os = s.getOutputStream();
			start(); 
            listen();
		}catch(IOException ie){
			pln(""+ie);
		}finally{
			try{
				if(s != null) s.close();
				if(ss != null) ss.close();
			}catch(IOException ie){}
		}
	}
	void listen(){ //socket -> monitor 
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(is);
			String msg = "";
			while(true){
				msg = dis.readUTF(); //IO���
				System.out.println("client("+ipClient+")>> " + msg);
			}
		}catch(IOException ie){
			//pln("listen() ie: " + ie);
			pln("Client ����.. 2�� �Ŀ� �����ϰڽ��ϴ�!!");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie2){}
			System.exit(0);
		}finally{
			try{
				if(dis != null) dis.close();
				if(is != null) is.close();
			}catch(IOException ie){}
		}
	}
	public void run(){
		speak();
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){ //keyboard -> socket
		DataOutputStream dos = new DataOutputStream(os);
		try{
			while(true){
				String line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
			pln("speak() ie: " + ie);
		}finally{
			try{
				if(dos !=null) dos.close();
				if(os != null) os.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		AServer s = new AServer();
	}
}

//PC ��ȭ�� ��� ��Ʈ : 3000-5000
