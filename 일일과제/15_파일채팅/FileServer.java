import java.io.*;
import java.net.*;
import java.util.*;

public class FileServer extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;


    Vector<FileReceiver> v = new Vector<FileReceiver>();
    FileReceiver receiver;



    FileServer(){
        try {
            ss = new ServerSocket(port); 
            pln(port+"번 포트에서 서버 대기중...");
            
            //start(); //서버 메세지 전송 쓰레드 실행
            while(true){
                sc = ss.accept();
                //메세지 전송처리를 하는 스레드 생성 및 실행
                receiver = new FileReceiver(this);
                //this는 메인서버야. Receiver 클래스에 자신의 객체를 넘김(2번 용법)
                v.add(receiver);
                receiver.start();
            }
        } catch (IOException ie) {
            pln(port+"번 포트는 이미 사용중");
        } finally{
            try { //서버소켓 닫기
                if(sc !=null) sc.close(); 
                if(ss !=null) ss.close();
            } catch (IOException ie) {}
        }
    }


    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        String msg = "";
        try {
            while(true){
                msg = br.readLine();
                msg = msg.trim();
                if(v.size() !=0){ 
                    receiver = v.get(0);
                    receiver.sendMessage("server>> : " +msg);
                }else{
                    pln("현재 접속한 클라이언트가 없습니다");
                }
            }
        } catch (IOException ie) {
        }
    }



    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {
        new FileServer();
        
    }
    
}
