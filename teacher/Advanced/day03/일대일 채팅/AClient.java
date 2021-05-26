import java.io.*;
import java.net.*;

class AClient extends Thread {
	Socket s;
	String ip = "127.0.0.1"; //자신의 서버 
	//String ip = "192.168.1.15"; //대면 학생
	// String ip = "123.142.144.46"; //비대면 학생 
	int port = 3000;
	OutputStream os;
	InputStream is;

	AClient(){
		try{
			s = new Socket(ip, port);
			is = s.getInputStream();
			os = s.getOutputStream();
			pln("서버와 접속 완료!");
			start();
			listen();
		}catch(UnknownHostException ne){
			pln("해당 서버를 찾지 못함");
		}catch(IOException ie){
		}finally{
			try{
				if(s != null) s.close();
			}catch(IOException ie){}
		}
	}
	public void run(){
		speak();
	}
	void listen(){ //socket -> monitor 
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(is);
			String msg = "";
			while(true){
				msg = dis.readUTF(); //IO블록
				System.out.println("server>> " + msg);
			}
		}catch(IOException ie){
			//pln("listen() ie: " + ie);
			pln("Server 퇴장(다운됨!).. 2초 후에 종료하겠습니다!!");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie2){}
			System.exit(0);
		}finally{
			try{
				if(dis != null) dis.close();
				if(is != null) is.close();
			}catch(IOException ie){}
		}
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void speak(){ //keyboard -> socket
		DataOutputStream dos = new DataOutputStream(os);
		try{
			while(true){
				String line = br.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
			pln("speak() ie: " + ie);
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