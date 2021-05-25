import java.io.*;
import java.net.*;

public class MainClient {
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3586;
    String name;

    public void start(){
        try {
            
            sc = new Socket(ip,port);
            ClientSpeak th1 = new ClientSpeak(sc,name);
            th1.start();
            
            pln("서버와 접속 완료");

            ClientReceive th2 = new ClientReceive(sc);

            th2.start();

        } catch (UnknownHostException ne) {
            pln("해당 서버를 찾지 못함");
        } catch (IOException ie){

        }
    }
    
    
    
    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new MainClient().start();
    }
    
}


class ClientSpeak extends Thread{
    Socket sc;
    String line = "";
    DataOutputStream dos;
    String name;
  

    public ClientSpeak(Socket sc, String name){
        this.sc = sc;
        this.name = name;
        try {
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (Exception e) {}
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        try {
            System.out.println("대화명: ");
            String name = br.readLine();
            dos.writeUTF(name);
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            System.out.println("speak() ie: "+ie);
        } finally{
            try {
                if(dos !=null) dos.close();
            } catch (Exception e) {}
        }
    }
}

class ClientReceive extends Thread{
    Socket sc;
    String msg = "";
    DataInputStream dis;

    ClientReceive(Socket sc){
        this.sc = sc;
        try{
            dis = new DataInputStream(sc.getInputStream());
        }catch (Exception e) {}
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
