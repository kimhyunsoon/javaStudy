import java.io.*;
import java.net.*;

class AClient {
	Socket s;
	//String ip = "127.0.0.1"; //자신의 서버 
	//String ip = "192.168.1.15"; //대면 학생
	String ip = "123.142.144.46"; //비대면 학생 
	int port = 3000;
	AClient(){
		try{
			s = new Socket(ip, port);
			OutputStream os = s.getOutputStream();
			pln("서버와 접속 완료!");
			speak(os);
		}catch(UnknownHostException ne){
			pln("해당 서버를 찾지 못함");
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
			pln("상대방이 나갔습니다");
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