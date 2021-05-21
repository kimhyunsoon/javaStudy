import java.io.*;
import java.net.*;

public class AServer2 {
    ServerSocket ss;
    Socket s;
    int port = 2000;
    String ipClient;

    AServer2(){

        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 서버 대기중...");
            s = ss.accept();
            ipClient = s.getInetAddress().getHostAddress();
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            listen(is);
            speak(os);
        } catch (IOException ie) {
            pln(""+ie)  ;
        }
    }

    void listen(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        String msg = "";
        try {
            while (true) {
                msg = dis.readUTF();
                pln(msg);
            }
        } catch (IOException ie) {
            pln("listen() ie: "+ie);
        } finally{
            try {
                if(dis !=null) dis.close();
                if(is !=null) is.close();
            } catch (Exception e) {
            }
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak(OutputStream os){
        DataOutputStream dos = new DataOutputStream(os);
        try {
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("speak() ie: "+ie);
        } finally{
            try {
                if(dos!=null) dos.close();
                if(os!=null) os.close();
            } catch (Exception e) {
            }
        }
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new AServer2();

        
    }
}
