package soon.chat;

import soon.lib.*;
import soon.chat.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface GlobalServer{
    public static ConcurrentHashMap<String,Socket> user = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String,Socket> name = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer,Socket> socketMap = new ConcurrentHashMap<>();
    int port = 3586;
    Lib lib = new Lib();    
}
public class ChatServer implements GlobalServer{

    void serverStart(){
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            lib.msgln("서버 시작");
            while (true) {
                socketMap.put(0, serverSocket.accept());
                Socket socket = socketMap.get(0);

                lib.msgln("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속");
                
                // 12. 메시지 전송 처리를 하는 스레드 생성 및 실행
                ServerReceiver receiver = new ServerReceiver(socket);
                receiver.start();
            }
        } catch (IOException e) {
        } finally {
            // 서버 소켓 닫기
            if (serverSocket != null) {
                try{serverSocket.close();}catch(IOException e){};
            }
        }
    }
    
    public static void main(String args[]) {
        new ChatServer().serverStart();
    }
}

class ServerReceiver extends Thread implements GlobalServer{

    Socket socket = socketMap.get(0);
    
    public ServerReceiver(Socket socekt) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {}
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            user.put(dis.readUTF(), socket);
            String name = dis.readUTF();
            lib.msgln(dis.readUTF() + "님이 입장함");
            if (!name.equals("")) {
                sendMessage(dis.readUTF() + "님이 입장함");
            }

            while (dis != null) {
                name = "";
                sendMessage(dis.readUTF());
              }

        } catch (IOException e) {}
    }
    
    public void sendMessage(String msg) {

        // 13-1. Map에 저장된 유저의 대화명 리스트를 추출 (key값 구하기)
        Iterator<String> it = user.keySet().iterator();
        while (it.hasNext()) {
            try {
                String name = it.next(); // 13-2. 대화명(key)값 구하기
                // 13-3. 대화명에 해당하는 Socket의 OutputStream객체 구하기
                DataOutputStream out = new DataOutputStream(user.get(name).getOutputStream());
                out.writeUTF(msg); // 13-4. 메시지 보내기
            } catch (IOException e) {}
        }
    }

    public void sendMessage(String msg, String from) {
        // 14-1. Map에 저장된 유저의 대화명 리스트를 추출 (key값 구하기)
        Iterator<String> it = user.keySet().iterator();
        while (it.hasNext()) {
            try {
                String name = it.next(); // 14-2. 대화명(key)값 구하기
                // 14-3. 대화명에 해당하는 Socket의 OutputStream객체 구하기
                DataOutputStream out = new DataOutputStream(user.get(name).getOutputStream());
                out.writeUTF(from + ">> " + msg); // 14-4. 메시지 보내기
            } catch (IOException e) {}
        }
    }

    
}