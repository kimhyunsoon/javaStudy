import java.io.*;
import java.net.*;

public class MainClient {
    Socket sc;
    String ip = "127.0.0.1";
    String tport;
    int port;
    DataOutputStream dos;
	DataInputStream dis;
    String name;
    
    public void start(){
        BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("서버IP(기본:127.0.0.1): ");
            ip = brkey.readLine();
            System.out.print("PORT(기본:3000) : ");
            tport = brkey.readLine();
            port = Integer.parseInt(tport);
            sc = new Socket(ip,port);
            pln("서버에 연결되었습니다.");
            dos = new DataOutputStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
            System.out.print("채팅ID(기본: GUEST): ");
            name = brkey.readLine();
            dos.writeUTF(name);
            ClientSpeak th1 = new ClientSpeak(sc,name);
            th1.start();
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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  

    public ClientSpeak(Socket sc, String name){
        this.sc = sc;
        this.name = name;
        try {
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (Exception e) {}
    }

    
    public void run(){
        try {
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
