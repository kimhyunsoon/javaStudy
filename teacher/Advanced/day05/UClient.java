import java.io.*;
import java.net.*;

//udp socket IN ( 5001-7000 ) 
class UClient  
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket ds; //�޼�����(��ü��)
	DatagramPacket dp; //�޼���Ʋ(��������)
	String ip;
	//String ip = "192.168.1.15"; //��� �л�
	//String ip = "123.142.144.46"; //���� �л� 
	int port = 7000;

	UClient(){
		init();
	}
	void init(){ //�ֱ�ȭ  
		inputIp();
		try{
			ds = new DatagramSocket();
			String msg = br.readLine();
			byte[] buf = msg.getBytes();
			InetAddress ia = InetAddress.getByName(ip);
			dp = new DatagramPacket(buf, buf.length, ia, port);
			ds.send(dp);
			pln("���� �Ϸ�!!");
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
