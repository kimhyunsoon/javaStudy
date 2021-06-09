package ecardGame;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

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
                if(str.startsWith("//Kings") && str.indexOf(cg.playerName.get(0)) != -1) {
                    System.out.println(cg.playerName.get(0) + "zz");
                    System.out.println("Ȳ���� �����մϴ�");
                }else if (str.startsWith("//Slavs") && str.indexOf(cg.playerName.get(0)) != -1) {
                
                    System.out.println(cg.playerName.get(0) + "ss");
                    System.out.println("�뿹�� �����մϴ�");
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
