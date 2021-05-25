import java.io.*;
import java.net.*;
import java.util.*;

public class MultiChatServer {
    // 1. ������ �����ϱ� ���� �÷��� ��ü ����
    //  - ��ȭ��, Ŭ���̾�Ʈ�� Socket�� �����ϱ� ���� Map ���� ����
    private Map<String, Socket> clients; // String: ��ȭ��, Socket: �ش� ������ ����
  
    public MultiChatServer() {
    // 2. �ټ��� ������ �������� ��, ���ÿ� ������ ��������� Map�� �����ϰ� �ȴ�
    //    �̸� ���� �̸� ��ü�����ÿ� �̸� ����ȭ ó���� �����ϵ��� ó�����ش�.
    clients = Collections.synchronizedMap(new HashMap<>());
  
    }
    // 3. ������ �����ϴ� �޼���
    public void serverStart() {
      ServerSocket serverSocket = null; // try�� �ۿ��� close�ϱ� ���� �ۿ��� ����
      Socket socket;
  
      try {
        serverSocket = new ServerSocket(7777);
        System.out.println("������ ���۵Ǿ����ϴ�.");
  
        while (true) {
          // 4. Ŭ���̾�Ʈ�� ������ ����Ѵ�.
          socket = serverSocket.accept();
  
          System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] ���� �����Ͽ����ϴ�.");
  
          // 12. �޽��� ���� ó���� �ϴ� ������ ���� �� ����
          ServerReceiver receiver = new ServerReceiver(socket);
          receiver.start();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        // ���� ���� �ݱ�
        if (serverSocket != null) {
          try {serverSocket.close();} catch(IOException e) {}
        }
      }
    }
    
    // 13. �޼��� ���� �޼���
    /**
     * ��ȭ�� ��, Map�� ����� ��ü �������� '�ȳ�'�޽����� �����ϴ� �޼���
     * @param msg
     */
    public void sendMessage(String msg) {
      // 13-1. Map�� ����� ������ ��ȭ�� ����Ʈ�� ���� (key�� ���ϱ�)
      Iterator<String> it = clients.keySet().iterator();
      while (it.hasNext()) {
        try {
          String name = it.next(); // 13-2. ��ȭ��(key)�� ���ϱ�
  
          // 13-3. ��ȭ�� �ش��ϴ� Socket�� OutputStream��ü ���ϱ�
          DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());
  
          out.writeUTF(msg); // 13-4. �޽��� ������
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    // 14. 13�� �����ε� : ��ȭ�� + ����
    /**
     * ��ȭ�� ��, Map�� ����� ��ü �������� '��ȭ'�޽����� �����ϴ� �޼���
     * @param msg ���� �޽���
     * @param from ���� ��� ��ȭ��
     */
    public void sendMessage(String msg, String from) {
      // 14-1. Map�� ����� ������ ��ȭ�� ����Ʈ�� ���� (key�� ���ϱ�)
      Iterator<String> it = clients.keySet().iterator();
      while (it.hasNext()) {
        try {
          String name = it.next(); // 14-2. ��ȭ��(key)�� ���ϱ�
  
          // 14-3. ��ȭ�� �ش��ϴ� Socket�� OutputStream��ü ���ϱ�
          DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());
  
          out.writeUTF("#" + from + "���� �޼��� : " + msg); // 14-4. �޽��� ������
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    // 5. Ŭ���̾�Ʈ�� �̸��� �޼����� �о�鿩 �ٽ� Ŭ���̾�Ʈ���� �޽����� ������ Thread�� InnerŬ������ ����
    // ���� Ŭ���� ����: InnerŬ�������� �θ�Ŭ������ ������� ���� ����� �� ����.
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
          // 6. ����ڰ� �����ڸ��� ��ȭ���� String ���� �Է��� ��
          //    -> ���� String���� ó�����ش�
          //    = �������� Ŭ���̾�Ʈ�� ������ ������ �޼���(=��ȭ��)�� ����
          name = dis.readUTF();
  
          // 7. ��ȭ���� �޾Ƽ� �ٸ� ��� Ŭ���̾�Ʈ�鿡�� ��ȭ�� ���� �޽��� ����
          sendMessage("#" + name + " ���� �����߽��ϴ�.");
  
          // 8. ��ȭ��� ���������� Map�� �����Ѵ�.
          clients.put(name, socket);
          System.out.println("#���� ���� ������ ���� " + clients.size() + "���Դϴ�.");
  
          // 9. ������ �޽����� �ݺ������� ó���Ѵ�.
          // �� Ŭ���̾�Ʈ�� ���� �޽����� �ٸ� ��� Ŭ���̾�Ʈ���� �����ش�.
          while (dis != null) {
            sendMessage(dis.readUTF(), name);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          // 10. �� finally ������ ����ȴٴ� ���� Ŭ���̾�Ʈ�� ������ ����Ǿ��ٴ� �ǹ��̴�.
          sendMessage(name + "���� �����̽��ϴ�.");
  
          // 11. Map���� �ش� ��ȭ���� �����Ѵ�.
          clients.remove(name);
  
          System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]���� ������ �����߽��ϴ�.");
          System.out.println("���� ������ ���� " + clients.size() + "���Դϴ�.");
        }
      }
    } // ServerReceiver class
    
    public static void main(String[] args) {
        new MultiChatServer().serverStart();
    }
  } // MultiChatServer class