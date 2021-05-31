import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    //ArrayList<Receiver> list = new ArrayList<Receiver>();
    Vector<Receiver> v = new Vector<Receiver>();
    Receiver receiver;
    
    //배열에 Receiver 클래스에서 나온 데이타를 넣음
    
    MainServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 서버 대기중...");
            start();
            while(true){
                sc = ss.accept();
                receiver = new Receiver(this);
                //this는 메인서버야. Receiver 클래스에 자신의 객체를 넘김(2번 용법)
                v.add(receiver);
                receiver.start();
            }
        } catch (IOException ie) {
            pln(port+"번 포트는 이미 사용중");
        } finally{
            try {
                if(ss !=null) ss.close();
            } catch (IOException ie) {

            }
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
        new MainServer();
        
    }
    
}
