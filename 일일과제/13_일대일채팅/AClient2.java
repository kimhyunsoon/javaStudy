import java.io.*;
import java.net.*;

public class AClient2 {
    Socket client;
    String ip = "127.0.0.1";
    int port = 3586;

    public void start() {
        try {
            client = new Socket(ip, port);
            Speak2 speak = new Speak2(client);
            speak.start();
            pln("서버와 접속 완료!");


            Listen2 listen = new Listen2(client);


            listen.start();
        } catch (UnknownHostException e) {
            pln("해당 서버를 찾지 못함");
        } catch (IOException e) {
        }
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        
        new AClient2().start();

        
    }
    
}


class Speak2 extends Thread{
    Socket client;
    DataOutputStream dos;

    

    Speak2(Socket client){
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

class Listen2 extends Thread{
    Socket client;
    DataInputStream dis;
    String msg = "";

    Listen2(Socket client){
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
