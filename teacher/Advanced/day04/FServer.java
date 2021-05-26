import java.io.*;
import java.net.*;

class FServer 
{
	ServerSocket ss;
	Socket s;
	int port = 3000; 
	String ipClient;
	String fName = "goodwarriors.mpeg";

    InputStream is;
	BufferedInputStream bis;
	FileOutputStream fos;
	BufferedOutputStream bos;

	FServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 파일 서버 대기중..");
			s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			pln("클라이언트("+ipClient+") 연결됨");
			makeStream();
			receive();
		}catch(IOException ie){
		}finally{
			try{
				if(s != null) s.close();
				if(ss != null) ss.close();
			}catch(IOException ie){}
		}
	}
	void makeStream(){
		try{
			is = s.getInputStream();
			bis = new BufferedInputStream(is, 2048);
			fos = new FileOutputStream(fName);
			bos = new BufferedOutputStream(fos, 2048);
		}catch(IOException ie){}
	}
	void receive(){ //Socket -> File 
		int cnt = 0;
		long totalSize = 0; 
		byte bs[] = new byte[512];
		try{
			while((cnt = bis.read(bs)) != -1){
				bos.write(bs, 0, cnt);
				totalSize += cnt;
				//pln("받기중.. totalSize: " + totalSize);
			}
			bos.flush();
			pln("파일("+fName+") 받기 완료! ("+totalSize+"bytes)");
		}catch(IOException ie){
		}finally{
			try{
				if(bis != null) bis.close();
				if(is != null) is.close();
				if(bos != null) bos.close();
				if(fos != null) fos.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new FServer();
	}
}
