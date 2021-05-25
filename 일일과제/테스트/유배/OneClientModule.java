import java.io.*;
import java.net.*;
import java.util.*;

public class OneClientModule extends Thread{
    static Map<String, Socket> map;

    ServerSocket ss;
    Socket sc;
    DataInputStream dis;
    DataOutputStream dos;
    int port = 3586;
    String ipClient;
    String msg = "";
    OutputStream os;
	InputStream is;
    String name;
    

    OneClientModule(){
        map = Collections.synchronizedMap(new HashMap<>());

    }


    public OneClientModule(String msg, String from) {
        start();
    }

    public void sendMessage(String msg){
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            try {
                String name = iter.next(); // name(key) �� ���ϱ�
                DataOutputStream dos = new DataOutputStream(map.get(name).getOutputStream());
                dos.writeUTF(msg);
            } catch (Exception e) {}
        }
        
    }

    public void sendMessage(String msg, String from){
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            try {
                name = iter.next(); // name(key) �� ���ϱ�
                DataOutputStream dos = new DataOutputStream(map.get(name).getOutputStream());
                dos.writeUTF(from+"���� �޼��� : "+msg);
            } catch (Exception e) {}
        }
    }
    
    public void receiver(Socket sc){
        this.sc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
            name = dis.readUTF();
            sendMessage(name+"���� �����߽��ϴ�.");
            map.put(name,sc);
            System.out.println("#���� ���� ������ ���� " + map.size() + "���Դϴ�.");
        } catch (Exception e) {}
    }

    public void run(){
        System.out.println("������.");
        try {
            while(true){
                sendMessage(dis.readUTF(),name);
            }
        } catch (Exception e) {
        }finally{
            sendMessage(name+"���� �����̽��ϴ�.");
            map.remove(name);
        }
    }
    void pln(String str){
        System.out.println(str);
    }
}






