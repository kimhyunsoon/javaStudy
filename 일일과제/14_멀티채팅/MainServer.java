import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    ArrayList<Receiver> list = new ArrayList<Receiver>();
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
                list.add(receiver);
                receiver.start();
            }
        } catch (IOException ie) {
            //TODO: handle exception
        }
       
    }

    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        String msg = "";
        try {
            while(true){
                msg = br.readLine();

            }
        } catch (IOException ie) {
            //TODO: handle exception
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
