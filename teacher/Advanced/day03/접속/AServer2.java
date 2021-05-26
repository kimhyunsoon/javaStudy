import java.io.*;
import java.net.*;

//well-known port: 0~1023�� 
class AServer {
	ServerSocket ss;
	Socket s;
	int port = 3000;
	String ipClient;

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
			InputStream is = s.getInputStream();
            listen(is);
		}catch(IOException ie){
			pln(""+ie);
		}
	}
	void listen(InputStream is){ //socket -> monitor 
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(is);
			String msg = "";
			while(true){
				msg = dis.readUTF();
				System.out.println("client("+ipClient+")>> " + msg);
			}
		}catch(IOException ie){
			pln("listen() ie: " + ie);
		}finally{
			try{
				if(dis != null) dis.close();
				if(is != null) is.close();
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
