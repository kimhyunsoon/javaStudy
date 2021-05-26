import java.io.*;
import java.net.*;
//편지함, 편지봉투

public class UServerClient extends Thread{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ip ;
    int port = 7000;

    UServerClient(){
        init(); //초기화하는 메소드, 반복호출하게 될 수도 있으니 아예 메소드로
    }

    void init(){ //키보드에서 읽어서 소켓에 쓴다
        DatagramSocket ds = null; //메세지함(우체통)
        DatagramPacket dp = null; //메세지틀(편지봉투)

        inputIP();
        try {
            start(); //JVM이 쓰레드를 생성해서 런을 호출, 시간이 걸림
            try {
                Thread.sleep(10); //슬립 호출해서 서버 여는것부터 먼저 실행되게
            } catch (Exception e) {
            }
        ds = new DatagramSocket();
        while(true){
            p("전달할 메세지: ");
            String msg = br.readLine(); //스트링을 바이트배열로 바꿔야 함 getBytes();
            byte[] buf = msg.getBytes();
            InetAddress ia = InetAddress.getByName(ip); //아파트 동
            dp = new DatagramPacket(buf, buf.length, ia, port); //편지봉투에 주소를 써야한다
            ds.send(dp);
            pln("전송완료!!");
        }
        } catch (SocketException se) {
        } catch (UnknownHostException ue){
            pln("네트워크 상에 해당 서버를 찾을 수 없음");
            init();
        } catch (IOException ie){
        } finally{
            if(ds != null) ds.close();
        }
    }

    void inputIP(){
        try {
            p("IP입력: ");
            ip = br.readLine();
            if(ip !=null) ip = ip.trim();
            if(ip.length()==0) ip = "123.142.144.46";
        } catch (IOException ie) {
            inputIP(); //재귀호출
        }
    }

    public void run(){
        DatagramSocket ds = null; //메세지함(우체통)
        DatagramPacket dp = null; //메세지틀(편지봉투)
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
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args){
        new UServerClient().init();

    }
    
}
