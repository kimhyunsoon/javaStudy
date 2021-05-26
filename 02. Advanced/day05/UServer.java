import java.io.*;
import java.net.*;
//UDP : 비연결지향
public class UServer { 
    DatagramSocket ds; //메세지함(우체통)
    DatagramPacket dp; //메세지틀(편지봉투)
    int port = 7000;

    UServer(){ //무조건 호출되지만 반복호출(재귀호출)이 어렵다. 객체가 매번 만들어지기 때문
        try {
            ds = new DatagramSocket(port); //서버소켓의 UDP 버전 , 소켓익셉션 발생
            pln(port+"번에서 UDP서버 대기중..");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length); //바이트배열과 길이
            //dp에 바이트배열이 저장되어 있다? 문자는 깨질수 있으니까 스트링으로 변환해야 한다
            while(true){ //소켓에서 읽어서 모니터에 쓴다
                ds.receive(dp); //accept의 UDP버전, IO익셉션 발생
                String msg= new String(buf);
                msg = msg.trim();
                pln("Client>>"+msg);

                for(int i = 0;i<buf.length;i++) buf[i] =0; //메세지 받을 때마다 초기화
            }
        } catch (SocketException se) {
        } catch (IOException ie){
        }finally{
            if(ds !=null) ds.close(); //패킷은 클로즈가 없다
        }
    }


    void pln(String str){
        System.out.println(str);
    }


    public static void main(String[] args){
        new UServer();

    }
    
}
