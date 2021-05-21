import java.io.*;
import java.net.*;

class AClient 
{
	Socket s;
	String ip = "192.168.1.15";
	int port = 2000;
	AClient(){
		try{
			s = new Socket(ip, port);
			pln("서버와 접속 완료!");
		}catch(UnknownHostException ne){
			pln("해당 서버를 찾지 못함");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		AClient c = new AClient();
	}
}
