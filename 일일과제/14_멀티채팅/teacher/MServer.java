import java.io.*;
import java.net.*;
import java.util.*;

class MServer extends Thread {
	ServerSocket ss;
	Socket s;
	int port = 3000;
	Vector<OneClientModul> v = new Vector<OneClientModul>();
	OneClientModul ocm;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	MServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 멀티서버 대기중...");
			start();
			while(true){
				s = ss.accept();
				ocm = new OneClientModul(this);
				v.add(ocm);
				ocm.start();
			}
		}catch(IOException ie){
			pln(port+"번 포트는 이미 사용중임");
		}finally{
		    try{
				if(ss != null) ss.close();
			}catch(IOException ie){}
		}
	}
	public void run(){ // keyboard -> socket
		String msg = "";
		try{
			while(true){
				msg = br.readLine();
				msg = msg.trim();
				if(v.size() != 0){
					OneClientModul ocm = v.get(0);
					ocm.broadcast("관리자>> : " + msg);
				}else {
					pln("클리언트가 1명도 없음");
				}
			}
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new MServer();
	}
}
