import java.io.*;
import java.net.*;

//비연결지향
public class UUServer {
    int port = 7000;
    DatagramSocket ds; //메세지함(우체통)
    DatagramPacket dp; //메세지틀(편지봉투)

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
