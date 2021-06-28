import java.io.*;
import java.net.*;
//편지함, 편지봉투

public class UClient {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket ds; //메세지함(우체통)
    DatagramPacket dp; //메세지틀(편지봉투)
    String ip ;
    int port = 7000;

    UClient(){
        init(); //초기화하는 메소드, 반복호출하게 될 수도 있으니 아예 메소드로
    }

    void init(){ //키보드에서 읽어서 소켓에 쓴다
        
        inputIP();
        try {
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
         }
        catch (IOException ie){

        }finally{
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


    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args){
        new UClient();

    }
    
}
