package EcardGame;

import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread{
    Socket sc;
    DataInputStream dis;
    ClientGUI cg;
    String playerName;
    public ReceiverThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try {
            dis = new DataInputStream(sc.getInputStream());
            while(true){
                String str = dis.readUTF();
                if(str.startsWith("//Kings")) {
                    playerName = str.substring(7);
                    if(str.indexOf(playerName) != -1){
                        System.out.println("황제를 셋팅합니다");
                    }
                 }else if (str.startsWith("//Slavs")) {
                    playerName = str.substring(7);
                    if(str.indexOf(playerName) != -1){
                        System.out.println("노예를 셋팅합니다");
                    }
                 }
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
