import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    String ipClient;
    OutputStream os;
	InputStream is;
    // String name;
    public Map<String, Socket> map; //String : ��ȭ��, Socket: �ش� ������ ����

    // String msg = "";
    // DataInputStream dis;
    // DataOutputStream dos;
    // public String name;

    public MainServer(){
        map = Collections.synchronizedMap(new HashMap<>());
    }
    
    public void serverStart(){
        try {
            ss = new ServerSocket(port); 
            pln(port+"�� ��Ʈ���� ���� �����...");

            ServerSpeak th2 = new ServerSpeak(sc);
            th2.start();
            while(true){
                sc = ss.accept(); 
                ipClient = sc.getInetAddress().getHostAddress();
                pln(ipClient+"���� ���ӵǾ����ϴ�.");
                // is = sc.getInputStream();
                // os = sc.getOutputStream();
              

                ServerReceiver th1 = new ServerReceiver(sc);

                th1.start();
            }

        } catch (IOException ie) {
        } finally{
            try {
                if(sc !=null) sc.close();
                if(ss !=null) ss.close();
            } catch (IOException ie) {}
        }
    }
   
    public void sendMessage(String msg){
        Iterator<String> iter = map.keySet().iterator();
        String key = "";
        try {
            while(iter.hasNext()){

                key = iter.next();
                os = map.get(key).getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(msg);
            }
        } catch (IOException ie) {
            //TODO: handle exception
        }
       
    }

    public void sendMessage(String msg, String from){
        Iterator<String> iter = map.keySet().iterator();
        String key = "";
        while(iter.hasNext()){
            try {
                key = iter.next(); // name(key) �� ���ϱ�
                
                DataOutputStream dos = new DataOutputStream(map.get(key).getOutputStream());
                dos.writeUTF(from+">> "+msg);
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

    
  

    
    class ServerReceiver extends Thread{
        //Socket sc;
        String line = "";
        DataInputStream dis;
        DataOutputStream dos;
        String name;

        public ServerReceiver(Socket sc){
            try {
                // dos = new DataOutputStream(sc.getOutputStream());
                dis = new DataInputStream(sc.getInputStream());

            } catch (Exception e) {}
        }

        @Override
        public void run(){
            try {

                name = dis.readUTF();
                map.put(name,sc);
                sendMessage(name+"���� �����߽��ϴ�.");
                System.out.println("#���� ���� ������ ���� " + map.size() + "���Դϴ�.");
                while(true){

                    sendMessage(dis.readUTF(),name);
                }
            } catch (Exception e) {
            } finally{
                sendMessage(name+"���� �����̽��ϴ�.");
                map.remove(name);
            }
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
