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
            pln(port+"�� ��Ʈ���� ���� �����..");
            sc = ss.accept();
            ipClient = sc.getInetAddress().getHostAddress();
            InputStream is = sc.getInputStream();
            listen(is);

        } catch (IOException ie) {
            pln("���ܹ߻�"+ie);
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
            pln("������ �������ϴ�");
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
