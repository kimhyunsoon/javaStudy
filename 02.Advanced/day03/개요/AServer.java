import java.io.*;
import java.net.*;

//Well-Known port : 0~1023번. 사용하지 마셈.시스템 내부에서 사용할 수 있기 때문
public class AServer {
    
    ServerSocket ss;
    Socket sc; // 데이터의 이동 통로
    int port = 2000; //서비스의 통로, 아파트의 호수

    
    AServer(){
        
        try {
            ss = new ServerSocket(port); //서비스할 포트만 정해주면 됨
            pln(port+"번 포트에서 서버 대기중...");
            sc = ss.accept(); //멈춰, 대기
            pln("클라이언트("+sc.getInetAddress().getHostAddress()+")와 접속 완료!");
            
        } catch (IOException ie) {
            pln(""+ie);

        }
        


    }

    void pln(String str){
        System.out.println(str);

    }

    public static void main(String[] args) {
        AServer as = new AServer();
        
        
    }
}
