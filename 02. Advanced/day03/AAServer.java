import java.io.*;
import java.net.*;

public class AAServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    String ipClient;

    AAServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 서버 대기중..");
            sc = ss.accept();
            ipClient = sc.getInetAddress().getHostAddress();
            InputStream is = sc.getInputStream();
            listen(is);

        } catch (IOException ie) {
            pln("예외발생"+ie);
        }
    }

    void listen(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        try {
            while (true) {
                String msg = "";
                msg = dis.readUTF();
                System.out.println("client("+ipClient+")>> "+msg);
                
            }
        } catch (IOException ie) {
            pln("상대방이 나갔습니다");
        } finally{
            try {
                if(dis !=null) dis.close();
                if(is !=null) is.close();
            } catch (Exception e) {}
        }
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        AAServer aas = new AAServer();
        
    }
    
}
