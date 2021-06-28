import java.io.*;
import java.net.*;

public class AAAServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    String ipClient;

    AAAServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"�� ��Ʈ���� ���� �����..");
            sc = ss.accept();
            ipClient = sc.getInetAddress().getHostAddress();
            InputStream is = sc.getInputStream();
            listen(is);

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    void listen(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        try {
            String msg = "";
            while(true){
                msg = dis.readUTF();
                System.out.println("("+ipClient+")���� ��ȭ>> "+msg);
            }
        } catch (IOException ie) {
            pln(ipClient+"���� �������ϴ�");
        } finally{
            try {
                if(dis !=null) dis.close();
                if(is !=null) is.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    
    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args ) {
        new AAAServer();
        
    }
    
}
