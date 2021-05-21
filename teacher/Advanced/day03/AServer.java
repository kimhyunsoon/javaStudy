import java.io.*;
import java.net.*;

//well-known port: 0~1023번 
class AServer 
{
	ServerSocket ss;
	Socket s;
	int port = 2000;

	AServer(){
		try{
			ss = new ServerSocket(port); //0~65535번 
			pln(port+"번 포트에서 서버 대기중..");
			while(true){
				s = ss.accept();
				pln("클라이언트("+s.getInetAddress().getHostAddress()+")와 접속 완료!");
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
