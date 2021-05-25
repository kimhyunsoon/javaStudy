import java.io.*;
import java.net.*;
import java.util.*;

public class MultiChatClient {
    private Scanner scan = new Scanner(System.in);
    private String name;
  
    // 1. 시작 메서드
    public void clientStart() {
  
    // 2. 대화명 입력받기
    System.out.prin("대화명 : ");
    name = scan.next();
  
    Socket socket = null;
  
  try {
  socket = new Socket("192.168.45.2", 7777);
  
  System.out.println("서버에 연결되었습니다.");
  
  // 8.
  // 9.
  } catch (UnknownHostException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
  }
  
    // 서버의 메시지를 receive & 내 메시지 send -> sender, receiver 둘다 필요
  
    // 3. 메시지를 전송하는 Thread (내부클래스)
    class ClientSender extends Thread {
      private Socket socket;
      private DataOutputStream dos;
      private String name;
  
      public ClientSender(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
  
      try {
        dos = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
  
      @Override
      public void run() {
        try {
        // 4. 시작하자마자 자신의 대화명을 서ㅓ로 전송
          if(dos != null) {
            dos.writeUTF(name);
          }
  
          while(dos!= null) {
            // 5. 키보드로 입력받은 메시지를 서버로 전송
            dos.writeUTF(scan.nextLine());
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } // 내부클래스
    
    // 6. 수신용 Thread 클래스
    class ClientReceiver extends Thread {
      private Socket socket;
      private DataInputStream dis;
  
      public ClientReceiver(Socket socket) {
        this.socket = socket;
  
        try {
          dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
      @Override
      public void run() {
        while (dis != null) {
          try {
            // 7. 서버로부터 수신한 메시지 출력하기
            System.out.println(dis.readUTF());
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }// 내부클래스
  
    public static void main(String[] args) {
        new MultiChatClient().clientStart();
    }
  } // MultiChatClient class