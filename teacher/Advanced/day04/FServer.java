import java.io.*;
import java.net.*;

public class FServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    String ipClient;
    InputStream is;
    BufferedInputStream bis;
    String file;
    FileOutputStream fos;
    
    
    FServer(){

        try {
            ss = new ServerSocket(port);
            pln(port+"에서 대기중");
            sc = ss.accept();
            ipClient = sc.getInetAddress().getHostAddress();
            pln(ipClient+"에서 접속되었습니다.");

            receive();
            
        } catch (IOException ie) {
            //TODO: handle exception
        } finally{

        }
    }

    void makeStream(){
        is = s.getInputStream();
        bis = new BufferedInputStream(is,2048);
        fos = new FileOutputStream(file);
        bos = new BufferedOutputStream(fos);
    }

    void receive(){
        byte bs = new byte[512];
        int cnt;
        try {
            while((cnt = bis.read(bs)) != -1){
                bos.write(bs,0,cnt);
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        }


        }
    }

    void pln(String str){
        System.out.println(str);

    }
    


    public static void main(String[] args) {
        new FServer();
    }
    
}
