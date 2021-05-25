import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer extends Thread{
    ServerSocket ss;
    Socket sc;
    DataInputStream dis;
    DataOutputStream dos;
    int port = 3586;
    String ipClient;
    String msg = "";
    OutputStream os;
	InputStream is;
    public String name;
    public Map<String, Socket> map; //String : 대화명, Socket: 해당 유저의 소켓
    
    public MainServer(){
        map = Collections.synchronizedMap(new HashMap<>());
    }
    
    public void serverStart(){
        try {
            ss = new ServerSocket(port); 
            pln(port+"번 포트에서 서버 대기중...");
            while(true){
                sc = ss.accept(); 
                ipClient = sc.getInetAddress().getHostAddress();
                pln(ipClient+"에서 접속되었습니다.");
               
                ServerSpeak th2 = new ServerSpeak(sc);
                ServerReceiver th1 = new ServerReceiver(sc);
                th2.start();
                th1.start();



            }
        } catch (IOException ie) {
        } finally{
            try {
                if(ss !=null) ss.close();
            } catch (IOException ie) {}
        }

    }
   
    public void sendMessage(String msg){
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            try {
                name = iter.next(); // name(key) 값 구하기
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
    
  

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        MainServer ms= new MainServer();
        ms.serverStart();
        
    }
}

class ServerReceiver extends Thread{
    Socket sc;
    String line = "";
    DataInputStream dis;
    DataOutputStream dos;
    String name;
    MainServer ms = new MainServer();

    public ServerReceiver(Socket sc){
        this.sc = sc;
        try {
            //dos = new DataOutputStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
            name = dis.readUTF();
            ms.sendMessage(name+"님이 입장했습니다.");
            ms.map.put(name,sc);
            System.out.println("#현재 서버 접속자 수는 " + ms.map.size() + "명입니다.");


        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    @Override
    public void run(){
        System.out.println("입장함.");
        
        try {
            while(dis !=null){
                ms.sendMessage(dis.readUTF(),name);
            }
        } catch (Exception e) {
        } finally{
            //ms.sendMessage(name+"님이 나가셨습니다.");
            ms.map.remove(name);
        }
    }




}



class ServerSpeak extends Thread{
    Socket sc;
    String line = "";
    DataOutputStream dos;
  

    ServerSpeak(Socket sc){
        this.sc = sc;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        try {
            dos = new DataOutputStream(sc.getOutputStream());
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            System.out.println("speak() ie: "+ie);
        } finally{
            try {
                if(dos !=null) dos.close();
            } catch (Exception e) {
            }
        }
    }
}
