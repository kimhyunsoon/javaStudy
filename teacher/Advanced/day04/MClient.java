import java.io.*;
import java.net.*;

//tcp socket IN [방화벽 & 포트포워딩] => ( 3000-5000 )
//udp socket IN [방화벽 & 포트포워딩] => ( 5001-7000 )
class MClient extends Thread {
	Socket s;
	String ip = "127.0.0.1"; //자신의 서버 
	//String ip = "192.168.1.15"; //대면 학생
	//String ip = "123.142.144.46"; //비대면 학생 
	int port = 3000;
	OutputStream os;
	InputStream is;
	DataInputStream dis;
	DataOutputStream dos;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String chatId;

	MClient(){
		connect();
	}
	void connect(){
		try{
			p("서버IP(기본:127.0.0.1): ");
			String ip = br.readLine();
			ip = ip.trim();
			if(ip.length() == 0) ip = "127.0.0.1";

			p("PORT(기본:3000): ");
			String portStr = br.readLine();
			portStr = portStr.trim();
			if(portStr.length() == 0) portStr="3000";
			int port = Integer.parseInt(portStr);
			if(port<0 || port>65535){
				pln("범위가 유효하지 않은 포트 ㅠㅠ");
				connect();
				return;
			}

			s = new Socket(ip, port);
			pln("서버와 연결 성공!!");
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			start();
			speak();
		}catch(UnknownHostException ne){
			pln("해당 서버를 찾지 못함");
			connect();
		}catch(IOException ie){
			connect();
		}catch(NumberFormatException ne){
			pln("숫자 형태의 포트가 아님 ㅠㅠ");
			connect();
		}
	}
	public void run(){ //listen ( socket -> monitor ) 
		try{
			while(true){
				String msg = dis.readUTF();
				pln(msg);
			}
		}catch(IOException ie){
			pln("서버 다운.. 2초 후에 종료됩니다.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
		}finally{
            closeAll();
		}
	}
	void speak(){ //speak ( keyboard -> socket ) 
        p("채팅ID(기본:GUEST): ");
		try{
			chatId = br.readLine();
			chatId = chatId.trim();
			if(chatId.length() == 0) chatId = "GUEST";
			dos.writeUTF(chatId);
			dos.flush();

			inputMsg();
		}catch(IOException ie){
			pln("speak() ie: " + ie);
		}
	}
	void inputMsg(){
		try{
			while(true){
				String msg = br.readLine();
				dos.writeUTF(chatId+">> "+msg);
				dos.flush();
			}
		}catch(IOException ie){
		}finally{
			closeAll();
		}
	}
	void closeAll(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(s != null) s.close();
		}catch(IOException ie){}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new MClient();
	}
}