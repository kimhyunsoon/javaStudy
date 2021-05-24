import java.io.*;
import java.net.*;

public class AServer2 {
    ServerSocket server;
    Socket client;
    DataInputStream dis;
    DataOutputStream dos;
    int port = 3586;
    String ipClient;
    String msg = "";
    
    public void start(){
        try {
            server = new ServerSocket(port);
            pln(port+"번 포트에서 서버 대기중...");
            client = server.accept();
            pln("클라이언트 연결 성공");
            
            Speak speak = new Speak(client);
            Listen listen = new Listen(client);

            speak.start();
            listen.start();

        } catch (IOException ie) {
        }
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new AServer2().start();
        
    }
}

class Speak extends Thread{
    Socket client;
    DataOutputStream dos;

    

    Speak(Socket client){
        this.client = client;
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException ie) {
            System.out.println("speak() ie: "+ie);
        } 
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    public void run(){
        try {
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (Exception e) {}
    }
}

class Listen extends Thread{
    Socket client;
    DataInputStream dis;
    String msg = "";

    Listen(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (Exception e) {
        }
    }

    public void run(){
        try {
            while(true){
                msg = dis.readUTF();
                System.out.println(msg);
            }
        } catch (Exception e) {
        }
    }
}


