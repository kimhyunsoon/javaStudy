import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread{
    Socket sc;
    DataInputStream dis;
    ClientGUI cg;
    public ReceiverThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try {
            dis = new DataInputStream(sc.getInputStream());
            while(true){
                String str = dis.readUTF();
                if(str == null) break;
                System.out.println(str);
                cg.chatLog.append(str+"\n");
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
