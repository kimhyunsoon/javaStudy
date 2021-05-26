import java.io.*;
import java.net.*;

//udp socket IN ( 5001-7000 ) 
class UClient  
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket ds; //메세지함(우체통)
	DatagramPacket dp; //메세지틀(편지봉투)
	String ip;
	//String ip = "192.168.1.15"; //대면 학생
	//String ip = "123.142.144.46"; //비대면 학생 
	int port = 7000;

	UClient(){
		init();
	}
	void init(){ //최기화  
		inputIp();
		try{
			ds = new DatagramSocket();
			String msg = br.readLine();
			byte[] buf = msg.getBytes();
			InetAddress ia = InetAddress.getByName(ip);
			dp = new DatagramPacket(buf, buf.length, ia, port);
			ds.send(dp);
			pln("전송 완료!!");
		}catch(SocketException se){
		}catch(UnknownHostException ue){
			pln("네트웍상에 해당 서버("+ip+"를 찾을 수 없음)");
			init();
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	void inputIp(){
		try{
			p("IP(기본:123.142.144.46): ");
			ip = br.readLine();
			if(ip != null) ip = ip.trim();
			if(ip.length() == 0) ip = "123.142.144.46";
		}catch(IOException ie){
			inputIp();
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		new UClient();
	}
}
