import java.io.*;
import java.net.*;

public class AServer extends Thread{
    ServerSocket ss; 
        //서버 역할을 하는 소켓 객체, 클라이언트의 연결요청을 기다리면서 연결 요청에 대한 수락을 담당한다.
    Socket sc; //클라이언트와 서버 간의 통신을 직접 담당
    int port = 3000;
    String ipClient;
    OutputStream os; //byte 데이터 입출력을 하기 위한 IO클래스
    InputStream is;

    AServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 서버 대기중..");
            sc = ss.accept(); //연결을 기다리며, 연결이 될 때까지 block상태가 됨
            ipClient = sc.getInetAddress().getHostAddress();
            
            //InetAddress(); : IP 주소를 표현할 때 사용하는 클래스
            //getHostAddress(); : IP주소를 반환
            //getHostName(); :  호스트 이름을 문자열로 변환

            is = sc.getInputStream(); //소켓을 위한 input stream을 반환
            os = sc.getOutputStream(); //소켓을 위한 output stream을 반환
            start();
            listen();

        } catch (IOException ie) {
            pln(""+ie);
        } finally{
            try {
                if(sc != null) sc.close();
                if(ss != null) ss.close();
            } catch (IOException ie) {}
        }
    }

    void listen(){ //Socket->monitor
        DataInputStream dis = null; 
        try {
            dis = new DataInputStream(is);
            String msg = "";
            while(true){
                msg = dis.readUTF(); 
                System.out.println("client("+ipClient+")>> "+msg);
            }
        } catch (IOException ie) {
            pln(ipClient+"님이 나갔습니다. 2초 후에 종료합니다");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie2) {}
            System.exit(0);
        } finally{
            try {
                if(dis !=null) dis.close();
                if(is !=null) is.close();
            } catch (IOException ie) {}
        }
    }

    public void run(){
        speak();
    }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak(){ //keyboard ->socket
        DataOutputStream dos = new DataOutputStream(os);
        try {
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("speak(): "+ie);
        } finally{
            try {
                if(dos !=null) dos.close();
                if(os !=null) os.close();
            } catch (IOException ie) {}
        }
    }

    
    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args ) {
        new AServer();
        
    }
    
}
