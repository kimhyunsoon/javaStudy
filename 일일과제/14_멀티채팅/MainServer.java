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
    public Map<String, Socket> map; //String : ��ȭ��, Socket: �ش� ������ ����
    
    public MainServer(){
        map = Collections.synchronizedMap(new HashMap<>());
    }
    
    public void serverStart(){
        try {
            ss = new ServerSocket(port); 
            pln(port+"�� ��Ʈ���� ���� �����...");
            while(true){
                sc = ss.accept(); 
                ipClient = sc.getInetAddress().getHostAddress();
                pln(ipClient+"���� ���ӵǾ����ϴ�.");
               
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
                name = iter.next(); // name(key) �� ���ϱ�
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
            ms.sendMessage(name+"���� �����߽��ϴ�.");
            ms.map.put(name,sc);
            System.out.println("#���� ���� ������ ���� " + ms.map.size() + "���Դϴ�.");


        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    @Override
    public void run(){
        System.out.println("������.");
        
        try {
            while(dis !=null){
                ms.sendMessage(dis.readUTF(),name);
            }
        } catch (Exception e) {
        } finally{
            //ms.sendMessage(name+"���� �����̽��ϴ�.");
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
