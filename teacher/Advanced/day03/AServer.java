import java.io.*;
import java.net.*;

//well-known port: 0~1023�� 
class AServer 
{
	ServerSocket ss;
	Socket s;
	int port = 2000;

	AServer(){
		try{
			ss = new ServerSocket(port); //0~65535�� 
			pln(port+"�� ��Ʈ���� ���� �����..");
			while(true){
				s = ss.accept();
				pln("Ŭ���̾�Ʈ("+s.getInetAddress().getHostAddress()+")�� ���� �Ϸ�!");
			}
		}catch(IOException ie){
			pln(""+ie);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		AServer s = new AServer();
	}
}
