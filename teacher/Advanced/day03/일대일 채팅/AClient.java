import java.io.*;
import java.net.*;

class AClient extends Thread {
	Socket s;
	String ip = "127.0.0.1"; //�ڽ��� ���� 
	//String ip = "192.168.1.15"; //��� �л�
	// String ip = "123.142.144.46"; //���� �л� 
	int port = 3000;
	OutputStream os;
	InputStream is;

	AClient(){
		try{
			s = new Socket(ip, port);
			is = s.getInputStream();
			os = s.getOutputStream();
			pln("������ ���� �Ϸ�!");
			start();
			listen();
		}catch(UnknownHostException ne){
			pln("�ش� ������ ã�� ����");
		}catch(IOException ie){
		}finally{
			try{
				if(s != null) s.close();
			}catch(IOException ie){}
		}
	}
	public void run(){
		speak();
	}
	void listen(){ //socket -> monitor 
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(is);
			String msg = "";
			while(true){
				msg = dis.readUTF(); //IO���
				System.out.println("server>> " + msg);
			}
		}catch(IOException ie){
			//pln("listen() ie: " + ie);
			pln("Server ����(�ٿ��!).. 2�� �Ŀ� �����ϰڽ��ϴ�!!");
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
		AClient c = new AClient();
	}
}