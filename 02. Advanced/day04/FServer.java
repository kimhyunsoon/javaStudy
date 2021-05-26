import java.io.*;
import java.net.*;

public class FServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    
    FServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 연결 대기중");
            sc = ss.accept();
            is = s.getInputStream();
            dis = new DataInputStream(is);
            os = s.getOutputStream();
            dos = new DataOutputStream();

        } catch (IOException ie) {
        } 

    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args ) {
        new FServer();
        
    }
    
}
