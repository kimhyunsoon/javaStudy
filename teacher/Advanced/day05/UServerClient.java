import java.io.*;
import java.net.*;

class UServerClient extends Thread  
{
	int port = 7000;
	String ip = "127.0.0.1";
	//String ip = "192.168.1.15"; //��� �л�
	//String ip = "123.142.144.46"; //���� �л�
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void init(){ // keyboard -> socket  
		DatagramSocket ds = null;
		DatagramPacket dp = null;

		inputIp();
		try{
			start(); 
			try{
				Thread.sleep(100);
			}catch(Exception e){}
			ds = new DatagramSocket();

			while(true){
				p("������ �޼���: ");
				String msg = br.readLine();
				byte[] buf = msg.getBytes();
				InetAddress ia = InetAddress.getByName(ip);
				dp = new DatagramPacket(buf, buf.length, ia, port);
				ds.send(dp);
				pln("���� �Ϸ�!!");
			}
		}catch(SocketException se){
		}catch(UnknownHostException ue){
			pln("��Ʈ���� �ش� ����("+ip+"�� ã�� �� ����)");
			init();
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
		}
	}
	void inputIp(){
		try{
			p("IP(�⺻:123.142.144.46): ");
			ip = br.readLine();
			if(ip != null) ip = ip.trim();
			if(ip.length() == 0) ip = "123.142.144.46";
		}catch(IOException ie){
			inputIp();
		}
	}

	public void run(){
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		try{
			ds = new DatagramSocket(port);
			pln(port+"������ UDP���� �����..");
			byte[] buf = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);
             
			while(true){ //socket -> monitor 
				ds.receive(dp);
				String msg = new String(buf);
				msg = msg.trim();
				pln("Client>> " + msg);
				for(int i=0; i<buf.length; i++) buf[i]=0;
			}
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			if(ds != null) ds.close();
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
		new UServerClient().init();
	}
}
