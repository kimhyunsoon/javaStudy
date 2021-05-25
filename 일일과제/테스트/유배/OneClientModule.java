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
                String name = iter.next(); // name(key) 값 구하기
                DataOutputStream dos = new DataOutputStream(map.get(name).getOutputStream());
                dos.writeUTF(msg);
            } catch (Exception e) {}
        }
        
    }

    public void sendMessage(String msg, String from){
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            try {
                name = iter.next(); // name(key) 값 구하기
                DataOutputStream dos = new DataOutputStream(map.get(name).getOutputStream());
                dos.writeUTF(from+"님의 메세지 : "+msg);
            } catch (Exception e) {}
        }
    }
    
    public void receiver(Socket sc){
        this.sc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
            name = dis.readUTF();
            sendMessage(name+"님이 입장했습니다.");
            map.put(name,sc);
            System.out.println("#현재 서버 접속자 수는 " + map.size() + "명입니다.");
        } catch (Exception e) {}
    }

    public void run(){
        System.out.println("입장함.");
        try {
            while(true){
                sendMessage(dis.readUTF(),name);
            }
        } catch (Exception e) {
        }finally{
            sendMessage(name+"님이 나가셨습니다.");
            map.remove(name);
        }
    }
    void pln(String str){
        System.out.println(str);
    }
}






