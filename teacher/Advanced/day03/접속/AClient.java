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
			pln("������ ���� �Ϸ�!");
		}catch(UnknownHostException ne){
			pln("�ش� ������ ã�� ����");
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
