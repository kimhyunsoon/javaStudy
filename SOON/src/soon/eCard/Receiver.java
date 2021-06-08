package soon.eCard;
import java.io.*;
import java.net.*;

public class Receiver extends Thread{
    Socket sc;
    DataInputStream dis;
    Client cg;
    public Receiver(Socket sc){
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
        } catch (IOException ie) {
            System.out.println("서버 다운.. 2초 후에 종료됩니다.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){
            }
        }finally{
            try {
                if(dis != null) dis.close();
                if(sc != null) sc.close();
            } catch (IOException ie) {}
        }
    }
    
}
