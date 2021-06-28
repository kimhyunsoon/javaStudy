import java.io.*;
import java.net.*;

public class UUClient {
    DatagramSocket ds;
    DatagramPacket dp;
    String ip;
    int port = 7000;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    UUClient(){
        init();
    }

    void init(){
        inputIP();
        try {
            ds = new DatagramSocket();
            String msg = br.readLine();
            byte[] buf = msg.getBytes(); 
            InetAddress ia = InetAddress.getByName(ip);
            dp = new DatagramPacket(buf, buf.length, ia, port);
            ds.send(dp);
            pln("전송완료!");
        } catch (SocketException se) {
        } catch(UnknownHostException ue){
            pln("해당 서버를 찾을 수 없음");
            inputIP();
        } catch(IOException ie){
        } finally{
            if(ds != null) ds.close();
        }
    }

    void inputIP(){
        try {
            p("IP입력(기본 : 127.0.0.1): ");
            ip = br.readLine();
            if(ip != null) ip = ip.trim();
            if(ip.length() == 0) ip = "127.0.0.1";
        } catch (IOException ie) {
            inputIP();
        }
    }
    
    void pln(String str){
        System.out.println(str);
    }

    void p(String str){
        System.out.print(str);
    }

    

    public static void main(String[] args) {
        new UUClient();
        
    }
}
