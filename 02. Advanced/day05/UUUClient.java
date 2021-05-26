import java.io.*;
import java.net.*;

public class UUUClient {
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 7000;
    String ip = "127.0.0.1";
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 

    UUUClient(){
        init();
    }

    void init(){
        inputIP();
        try {
            ds = new DatagramSocket();
            while(true){ //메세지 계속 보내고 싶을때 반복문
                p("보낼 메세지: ");
                String msg = br.readLine(); //스트링을 바이트배열로 바꿔서 넣어줘야 함
                byte[] buf = msg.getBytes();
                InetAddress ia = InetAddress.getByName(ip);
                dp = new DatagramPacket(buf, buf.length, ia, port);
                ds.send(dp);
                pln("전송완료!");
            }
        } catch (SocketException se) {
        } catch (UnknownHostException ue){
            pln("서버를 찾을 수 없음");
            init();
        }catch (IOException ie){
        } finally{
            try {
                if(ds !=null) ds.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }

    void inputIP(){
        try {
            p("IP입력(기본: 127.0.0.1) : ");
            ip = br.readLine();
            if(ip != null)ip = ip.trim();
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
    
    public static void main(String[] args ){
        new UUUClient();

    }
}
