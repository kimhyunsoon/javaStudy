package soon.chat;

import soon.lib.*;
import soon.chat.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface GlobalClient{
    public static ConcurrentHashMap<String,String> chat = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer,Socket> socket = new ConcurrentHashMap<>();
    Lib lib = new Lib();
    String ip = "127.0.0.1";
    int port = 3586;

}
public class ChatClient implements GlobalClient{
    Scanner scan = new Scanner(System.in);
    public void clientStart() {
        // 2. 대화명 입력받기
        lib.msg("대화명 : ");
        chat.put("name", scan.next());
        try {
            socket.put(0, new Socket(ip, port));
            lib.msgln("서버에 연결되었습니다.");

            DataOutputStream dos = new DataOutputStream(socket.get(0).getOutputStream());
            dos.writeUTF(chat.get("name"));

        } catch (UnknownHostException e) {} catch (IOException e) {}
    }
    public static void main(String[] args) {
        new ChatClient().clientStart();
    }
}
// // 6. 수신용 Thread 클래스
// class ClientReceiver extends Thread implements GlobalClient {
//     private DataInputStream dis;

//     public ClientReceiver(Socket socket) {
//         try {
//             DataInputStream dis = new DataInputStream(socket.getInputStream());
//         } catch (IOException e) {}
//     }
    
//     @Override
//     public void run() {
//         while (dis != null) {
//             try {
//                 // 7. 서버로부터 수신한 메시지 출력하기
//                 System.out.println(dis.readUTF());
//             } catch (IOException e) {}
//         }
//     }
// }

//  // 3. 메시지를 전송하는 Thread (내부클래스)
//  class ClientSender extends Thread implements GlobalClient{
//     private Socket socket;
//     private DataOutputStream dos;
//     private String name;

//     public ClientSender(Socket socket, String name) {
//         this.socket = socket;
//         this.name = name;

//         try {
//             dos = new DataOutputStream(socket.getOutputStream());
//         } catch (IOException e) {}
//     }
//     @Override
//     public void run() {
//         try {
//         // 4. 시작하자마자 자신의 대화명을 서ㅓ로 전송
//             if(dos != null) {
//             dos.writeUTF(name);
//             }

//             while(dos!= null) {
//             // 5. 키보드로 입력받은 메시지를 서버로 전송
//             dos.writeUTF(scan.nextLine());
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }