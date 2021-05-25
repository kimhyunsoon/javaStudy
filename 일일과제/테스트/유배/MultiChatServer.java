import java.io.*;
import java.net.*;
import java.util.*;

public class MultiChatServer {
    // 1. 소켓을 관리하기 위한 컬렉션 객체 정의
    //  - 대화명, 클라이언트의 Socket을 저장하기 위한 Map 변수 선언
    private Map<String, Socket> clients; // String: 대화명, Socket: 해당 유저의 소켓
  
    public MultiChatServer() {
    // 2. 다수의 유저가 접속했을 시, 동시에 소켓이 만들어지고 Map에 저장하게 된다
    //    이를 위해 미리 객체생성시에 미리 동기화 처리가 가능하도록 처리해준다.
    clients = Collections.synchronizedMap(new HashMap<>());
  
    }
    // 3. 서버를 시작하는 메서드
    public void serverStart() {
      ServerSocket serverSocket = null; // try문 밖에서 close하기 위해 밖에서 선언
      Socket socket;
  
      try {
        serverSocket = new ServerSocket(7777);
        System.out.println("서버가 시작되었습니다.");
  
        while (true) {
          // 4. 클라이언트의 접속을 대기한다.
          socket = serverSocket.accept();
  
          System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다.");
  
          // 12. 메시지 전송 처리를 하는 스레드 생성 및 실행
          ServerReceiver receiver = new ServerReceiver(socket);
          receiver.start();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        // 서버 소켓 닫기
        if (serverSocket != null) {
          try {serverSocket.close();} catch(IOException e) {}
        }
      }
    }
    
    // 13. 메세지 전송 메서드
    /**
     * 대화방 즉, Map에 저장된 전체 유저에게 '안내'메시지를 전송하는 메서드
     * @param msg
     */
    public void sendMessage(String msg) {
      // 13-1. Map에 저장된 유저의 대화명 리스트를 추출 (key값 구하기)
      Iterator<String> it = clients.keySet().iterator();
      while (it.hasNext()) {
        try {
          String name = it.next(); // 13-2. 대화명(key)값 구하기
  
          // 13-3. 대화명에 해당하는 Socket의 OutputStream객체 구하기
          DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());
  
          out.writeUTF(msg); // 13-4. 메시지 보내기
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    // 14. 13번 오버로딩 : 대화명 + 내용
    /**
     * 대화방 즉, Map에 저장된 전체 유저에게 '대화'메시지를 전송하는 메서드
     * @param msg 보낼 메시지
     * @param from 보낸 사람 대화명
     */
    public void sendMessage(String msg, String from) {
      // 14-1. Map에 저장된 유저의 대화명 리스트를 추출 (key값 구하기)
      Iterator<String> it = clients.keySet().iterator();
      while (it.hasNext()) {
        try {
          String name = it.next(); // 14-2. 대화명(key)값 구하기
  
          // 14-3. 대화명에 해당하는 Socket의 OutputStream객체 구하기
          DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());
  
          out.writeUTF("#" + from + "님의 메세지 : " + msg); // 14-4. 메시지 보내기
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    // 5. 클라이언트의 이름과 메세지를 읽어들여 다시 클라이언트에게 메시지를 전송할 Thread를 Inner클래스로 정의
    // 내부 클래스 장점: Inner클래스에서 부모클래스의 멤버들을 직접 사용할 수 있음.
    class ServerReceiver extends Thread {
      private Socket socket;
      private DataInputStream dis;
      private String name;
  
      public ServerReceiver(Socket socekt) {
        this.socket = socket;
        try {
          dis = new DataInputStream(socket.getInputStream);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
      @Override
      public void run() {
        try {
          // 6. 사용자가 들어오자마자 대화명을 String 으로 입력할 것
          //    -> 먼저 String부터 처리해준다
          //    = 서버에서 클라이언트가 보내는 최초의 메세지(=대화명)을 수신
          name = dis.readUTF();
  
          // 7. 대화명을 받아서 다른 모든 클라이언트들에게 대화방 참여 메시지 전송
          sendMessage("#" + name + " 님이 입장했습니다.");
  
          // 8. 대화명과 소켓정보를 Map에 지정한다.
          clients.put(name, socket);
          System.out.println("#현재 서버 접속자 수는 " + clients.size() + "명입니다.");
  
          // 9. 이후의 메시지는 반복문으로 처리한다.
          // 한 클라이언트가 보낸 메시지를 다른 모든 클라이언트에게 보내준다.
          while (dis != null) {
            sendMessage(dis.readUTF(), name);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          // 10. 이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다.
          sendMessage(name + "님이 나가셨습니다.");
  
          // 11. Map에서 해당 대화명을 삭제한다.
          clients.remove(name);
  
          System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속을 종료했습니다.");
          System.out.println("현재 접속자 수는 " + clients.size() + "명입니다.");
        }
      }
    } // ServerReceiver class
    
    public static void main(String[] args) {
        new MultiChatServer().serverStart();
    }
  } // MultiChatServer class