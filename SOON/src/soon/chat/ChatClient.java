package soon.chat;

import soon.lib.*;
import soon.chat.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface GlobalClient{
    public static ConcurrentHashMap<String,String> chat = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer,Socket> socketMap = new ConcurrentHashMap<>();
    Lib lib = new Lib();
    String ip = "127.0.0.1";
    int port = 3586;

}
public class ChatClient implements GlobalClient{

    public void clientStart() {
        try {
            Socket socket = new Socket(ip, port);
            Scanner scan = new Scanner(System.in);
            
            socketMap.put(0, socket);
            lib.msgln("서버에 연결되었습니다.");
            // 2. 대화명 입력받기
            lib.msg("대화명 : ");
            chat.put("name", scan.next());

            DataOutputStream dos = new DataOutputStream(socketMap.get(0).getOutputStream());

            dos.writeUTF(chat.get("name"));

            ClientSender sender = new ClientSender(socketMap.get(0), chat.get("name"));
            ClientReceiver receiver = new ClientReceiver(socketMap.get(0));
            sender.start();
            receiver.start();

        } catch (UnknownHostException e) {} catch (IOException e) {}
    }
    public static void main(String[] args) {
        new ChatClient().clientStart();
    }
}
// 6. 수신용 Thread 클래스
class ClientReceiver extends Thread implements GlobalClient {

    public ClientReceiver(Socket socket) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {}
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socketMap.get(0).getInputStream());
            while (dis != null) {
            // 7. 서버로부터 수신한 메시지 출력하기
            System.out.println(dis.readUTF());
            }
        } catch (IOException e) {}
    }
}

 // 3. 메시지를 전송하는 Thread (내부클래스)
class ClientSender extends Thread implements GlobalClient{

    public ClientSender(Socket socket, String name) {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {}
    }
    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(socketMap.get(0).getOutputStream());
            if(dos != null) {
                dos.writeUTF(chat.get("name"));
            }

            while(dos!= null) {
                Scanner scan2 = new Scanner(System.in);
                dos.writeUTF(scan2.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}