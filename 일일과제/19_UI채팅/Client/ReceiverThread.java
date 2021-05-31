import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread{
    Socket sc;
    public ReceiverThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String str = br.readLine();
                if(str == null) break;
                System.out.println(str);
                ClientGUI.chatLog.append(str = "\n");
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
