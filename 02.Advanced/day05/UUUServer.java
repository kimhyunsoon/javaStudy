import java.io.*;
import java.net.*;
//UDP : 비연결지향

public class UUUServer {
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 7000;

    UUUServer(){ //
        try {
            ds = new DatagramSocket(port); //서버소켓의 UDP버전, 소켓익셉션 발생
            pln(port+"번 포트에서 서버연결 대기중");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length);
            //dp에 바이트배열이 저장되어 있다. 문자는 깨질 수 있으니 스트링으로 변환해야됨
            //메세지 계속 받고 싶으면

            while(true){ 
                ds.receive(dp); //accept의 UDP버전, IO익셉션 발생
                pln("연결성공");
                String msg = new String(buf);
                msg = msg.trim();
                pln("Client>> "+msg);
                for(int i = 0;i<buf.length;i++) buf[i] =0; //메세지 받을 때마다 초기화
            }
        } catch (SocketException se) {
        } catch(IOException ie){
        } finally{
            if(ds !=null) ds.close(); //패킷은 클로즈가 없다
        }

    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new UUUServer();
        
    }
    
}
