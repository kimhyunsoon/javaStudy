import java.io.*;
import java.net.*;

class FClient  
{
	Socket s;
	String ip = "127.0.0.1"; //�ڽ��� ���� 
	//String ip = "192.168.1.15"; //��� �л�
	//String ip = "123.142.144.46"; //���� �л� 
	int port = 3001;
	String path = "C:/SOO/Advanced/�ڷ��/goodwarriors.mpeg";

	FileInputStream fis;
	BufferedInputStream bis;
	OutputStream os;
	BufferedOutputStream bos;

	FClient(){
		try{
			s = new Socket(ip, port);
			makeStream();
			send();
		}catch(UnknownHostException ne){
			pln("�ش� ������ ã�� ����");
		}catch(IOException ie){
		}finally{
			try{
				if(s != null) s.close();
			}catch(IOException ie){}
		}

	}
	void makeStream(){
		try{
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis, 2048);
			os = s.getOutputStream();
			bos = new BufferedOutputStream(os, 2048);
		}catch(FileNotFoundException fe){
		}catch(IOException ie){}
	}
	void send(){ //File -> Socket 
		int cnt = 0;
		long totalSize = 0; 
		byte bs[] = new byte[512];
		try{
			while((cnt = bis.read(bs)) != -1){
				bos.write(bs, 0, cnt);
				totalSize += cnt;
				pln("��������.. totalSize: " + totalSize);
			}
			bos.flush();
			pln("���� ���� �Ϸ�! ("+totalSize+"bytes)");
		}catch(IOException ie){
		}finally{
			try{
				if(bos != null) bos.close();
				if(bis != null) bis.close();
				if(os != null) os.close();
				if(fis != null) fis.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new FClient();
	}
}
