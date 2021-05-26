import java.io.*;
import java.net.*;

public class AAClient {
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;

    AAClient(){
        try {
            sc = new Socket(ip,port);
            OutputStream os = sc.getOutputStream();
            pln("������ ���� �Ϸ�");
            speak(os);
        } catch (UnknownHostException he) { 
            pln("�ش� ������ ã�� ������");
        } catch(IOException io){}
    }


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak(OutputStream os){ //keyboard ->socket
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
            } catch (Exception e) {}
        }
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new AAClient();       
    }
}
