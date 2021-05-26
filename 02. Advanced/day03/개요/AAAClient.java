import java.io.*;
import java.net.*;

public class AAAClient {
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    AAAClient(){
        try {
            sc = new Socket(ip,port);
            OutputStream os = sc.getOutputStream();
            pln("서버와 접속 완료!");
            speak(os);
        } catch (UnknownHostException ne) {
            pln("해당 서버를 찾지 못하였습니다");
        } catch(IOException ie){}
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
        } catch (Exception e) {
            pln("상대방이 나갔습니다");
        } finally{
            try {
                if(dos !=null) dos.close();
                if(os !=null) os.close();
            } catch (Exception e) {
            }
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    
    public static void main(String [] args) {
        new AAAClient();
        
    }
}
