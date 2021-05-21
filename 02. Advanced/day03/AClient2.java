import java.io.*;
import java.net.*;

public class AClient2 {
    Socket s;
    String ip = "127.0.0.1";
    int port = 2000;

    AClient2() {
        try {
            s = new Socket(ip, port);
            OutputStream os = s.getOutputStream();
            pln("서버와 접속 완료!");
            InputStream is = s.getInputStream();
            
            speak(os);
            listen(is);
        } catch (UnknownHostException e) {
            pln("해당 서버를 찾지 못함");
        } catch (IOException e) {
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak(OutputStream os){
        DataOutputStream dos = new DataOutputStream(os);
        try {
            while (true) {
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("speak() ie: "+ie);
        } finally{
            try {
                if(dos!=null ) dos.close();
                if(os!=null) os.close();
            } catch (IOException ie) {
            }
        }
    }

    void listen(InputStream is){

    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        
        AClient2 ac = new AClient2();

        
    }
    
}
