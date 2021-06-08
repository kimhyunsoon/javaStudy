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
                        System.out.println("Ȳ���� �����մϴ�");
                    }
                 }else if (str.startsWith("//Slavs")) {
                    playerName = str.substring(7);
                    if(str.indexOf(playerName) != -1){
                        System.out.println("�뿹�� �����մϴ�");
                    }
                 }
                System.out.println(str);
                cg.chatLog.append(str+"\n");
                
            }
        } catch (IOException ie) {
            System.out.println("���� �ٿ�.. 2�� �Ŀ� ����˴ϴ�.");
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
