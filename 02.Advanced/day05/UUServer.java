import java.io.*;
import java.net.*;

//�񿬰�����
public class UUServer {
    int port = 7000;
    DatagramSocket ds; //�޼�����(��ü��)
    DatagramPacket dp; //�޼���Ʋ(��������)

    UUServer(){
        try {
            ds = new DatagramSocket(port);
            pln(port+"������ UDP ���� �����");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            String msg = new String (buf);
            msg = msg.trim();
            pln("Client>> "+msg);
        } catch (SocketException se) {
        } catch (IOException ie){
        } finally{
            if(ds !=null) ds.close();
        }
    }


    void pln(String str){
        System.out.println(str);
    }

    
    public static void main(String[] args) {
        new UUServer();
        
    }
}
