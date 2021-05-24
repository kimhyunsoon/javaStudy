import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer2 extends Thread{
    ServerSocket ss;
    Socket sc;
    DataInputStream dis;
    DataOutputStream dos;
    int port = 3586;
    String ipClient;
    String msg = "";
    OutputStream os;
	InputStream is;
    public String name;
    public Map<String, Socket> map; //String : 대화명, Socket: 해당 유저의 소켓
    
    public MainServer2(){

    }
    
    public void serverStart(){
        try {
            ss = new ServerSocket(port); 
            pln(port+"번 포트에서 서버 대기중...");
            while(true){
                sc = ss.accept(); 
                ipClient = sc.getInetAddress().getHostAddress();
                pln(ipClient+"에서 접속되었습니다.");
                OneClientModule ocm = new OneClientModule();
                ocm.receiver(sc);
                ServerSpeak2 th2 = new ServerSpeak2(sc);
                th2.start();




            }
        } catch (IOException ie) {
        } finally{
            try {
                if(ss !=null) ss.close();
            } catch (IOException ie) {}
        }

    }

  

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        MainServer2 ms= new MainServer2();
        ms.serverStart();
        
    }
}


class ServerSpeak2 extends Thread{
    Socket sc;
    String line = "";
    DataOutputStream dos;
  

    ServerSpeak2(Socket sc){
        this.sc = sc;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        try {
            dos = new DataOutputStream(sc.getOutputStream());
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            System.out.println("speak() ie: "+ie);
        } finally{
            try {
                if(dos !=null) dos.close();
            } catch (Exception e) {
            }
        }
    }
}
