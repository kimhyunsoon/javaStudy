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
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    
    public static void main(String[] args) {
        new UUServer();
        
    }
}
