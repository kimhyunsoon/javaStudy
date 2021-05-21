import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AClient {
    Socket sc;
    // String ip1 = "127.0.0.1"; //자기자신
    String ip2 = "192.168.1.15";
    String ip3 = "123.142.144.46"; //비대면일때
    int port = 2000;
    int port1 = 3000; //PC방화벽 포트
    
    
    AClient() {

        try {
            sc = new Socket(ip3, port);
            pln("서버와 접속 완료");
        } catch (UnknownHostException ue) {
            pln("해당 서버를 찾지 못함");
        } catch(IOException ie){}

    }

    void pln(String str){
        System.out.println(str);

    }

    public static void main(String[] args ) {
        AClient ac = new AClient();
        
    }
    
}
