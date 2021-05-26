import java.io.*;
import java.net.*;

class AClient {
	Socket s;
	//String ip = "127.0.0.1"; //�ڽ��� ���� 
	//String ip = "192.168.1.15"; //��� �л�
	String ip = "123.142.144.46"; //���� �л� 
	int port = 3000;
	AClient(){
		try{
			s = new Socket(ip, port);
			OutputStream os = s.getOutputStream();
			pln("������ ���� �Ϸ�!");
			speak(os);
		}catch(UnknownHostException ne){
			pln("�ش� ������ ã�� ����");
		}catch(IOException ie){
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(OutputStream os){ //keyboard -> socket
		DataOutputStream dos = new DataOutputStream(os);
		try{
			while(true){
				String line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
			pln("������ �������ϴ�");
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