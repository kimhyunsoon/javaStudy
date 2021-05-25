package soon.chat;

import soon.lib.*;
import soon.chat.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface GlobalServer{
    public static ConcurrentHashMap<String,Socket> user = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer,Socket> socketMap = new ConcurrentHashMap<>();
    int port = 3586;
    Lib lib = new Lib();
    public void sendMessage(String msg);
    public void sendMessage(String msg, String from);
    
}
public class ChatServer implements GlobalServer{

    void serverStart(){
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            lib.msgln("서버 시작");
            while (true) {
                // 4. 클라이언트의 접속을 대기한다.
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

     // 13. 메세지 전송 메서드
    @Override
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

    // 14. 13번 오버로딩 : 대화명 + 내용
    @Override
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
    
    public static void main(String args[]) {
        new ChatServer().serverStart();
    }
}

class ServerReceiver extends Thread implements GlobalServer{
    // private DataInputStream dis;
    

    public ServerReceiver(Socket socekt) {
        // this.socket = socekt;
        // try {
        //     dis = new DataInputStream(socket.getInputStream());
        // } catch (IOException e) {}
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socketMap.get(0).getInputStream());
            // 6. 사용자가 들어오자마자 대화명을 String 으로 입력할 것
            //    -> 먼저 String부터 처리해준다
            //    = 서버에서 클라이언트가 보내는 최초의 메세지(=대화명)을 수신
            lib.msg(dis.readUTF());

        } catch (IOException e) {
        }
    }
    @Override
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

    @Override
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