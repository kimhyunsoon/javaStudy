import java.io.*;
import java.net.*;

//비연결지향 
class UServer {
	int port = 7000;
	DatagramSocket ds; //메세지함(우체통)
	DatagramPacket dp; //메세지틀(편지봉투)
	UServer(){
		try{
			ds = new DatagramSocket(port);
			pln(port+"번에서 UDP서버 대기중..");
			byte[] buf = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);
             
			ds.receive(dp);
		    String msg = new String(buf);
			msg = msg.trim();
			pln("Client>> " + msg);
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new UServer();
	}
}
