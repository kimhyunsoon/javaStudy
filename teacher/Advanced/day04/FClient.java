import java.io.*;
import java.net.*;

class FClient  
{
	Socket s;
	String ip = "127.0.0.1"; //자신의 서버 
	//String ip = "192.168.1.15"; //대면 학생
	//String ip = "123.142.144.46"; //비대면 학생 
	int port = 3001;
	String path = "C:/SOO/Advanced/자료실/goodwarriors.mpeg";

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
			pln("해당 서버를 찾지 못함");
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
				pln("보내기중.. totalSize: " + totalSize);
			}
			bos.flush();
			pln("파일 전송 완료! ("+totalSize+"bytes)");
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
