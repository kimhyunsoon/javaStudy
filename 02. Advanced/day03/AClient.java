import java.io.*;
import java.net.*;

public class AClient extends Thread{
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;
    OutputStream os;
    InputStream is;

    AClient(){
        try {
            sc = new Socket(ip,port);
            is = sc.getInputStream();
            os = sc.getOutputStream();
            pln("서버와 접속 완료");
            start();
            listen();
        } catch (UnknownHostException he) { 
            pln("해당 서버를 찾지 못했음");
        } catch(IOException io){
        } finally{
            try {
                if(sc != null) sc.close();
            } catch (IOException ie) {}
        }
    }

    public void run(){
        speak();
    }

    void listen(){ //Socket->monitor
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(is);
            String msg = "";
            while(true){
                msg = dis.readUTF(); //IO블록
                System.out.println("server>> "+msg);
            }
        } catch (IOException ie) {
            pln("Server 다운됨..2초 후에 종료하겠습니다.");
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

    public static void main(String[] args) {
        new AClient();       
    }
}
