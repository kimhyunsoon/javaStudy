import java.io.*;
import java.net.*;

public class AServer extends Thread{
    ServerSocket ss; 
        //���� ������ �ϴ� ���� ��ü, Ŭ���̾�Ʈ�� �����û�� ��ٸ��鼭 ���� ��û�� ���� ������ ����Ѵ�.
    Socket sc; //Ŭ���̾�Ʈ�� ���� ���� ����� ���� ���
    int port = 3000;
    String ipClient;
    OutputStream os; //byte ������ ������� �ϱ� ���� IOŬ����
    InputStream is;

    AServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"�� ��Ʈ���� ���� �����..");
            sc = ss.accept(); //������ ��ٸ���, ������ �� ������ block���°� ��
            ipClient = sc.getInetAddress().getHostAddress();
            
            //InetAddress(); : IP �ּҸ� ǥ���� �� ����ϴ� Ŭ����
            //getHostAddress(); : IP�ּҸ� ��ȯ
            //getHostName(); :  ȣ��Ʈ �̸��� ���ڿ��� ��ȯ

            is = sc.getInputStream(); //������ ���� input stream�� ��ȯ
            os = sc.getOutputStream(); //������ ���� output stream�� ��ȯ
            start();
            listen();

        } catch (IOException ie) {
            pln(""+ie);
        } finally{
            try {
                if(sc != null) sc.close();
                if(ss != null) ss.close();
            } catch (IOException ie) {}
        }
    }

    void listen(){ //Socket->monitor
        DataInputStream dis = null; 
        try {
            dis = new DataInputStream(is);
            String msg = "";
            while(true){
                msg = dis.readUTF(); 
                System.out.println("client("+ipClient+")>> "+msg);
            }
        } catch (IOException ie) {
            pln(ipClient+"���� �������ϴ�. 2�� �Ŀ� �����մϴ�");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie2) {}
            System.exit(0);
        } finally{
            try {
                if(dis !=null) dis.close();
                if(is !=null) is.close();
            } catch (IOException ie) {}
        }
    }

    public void run(){
        speak();
    }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void speak(){ //keyboard ->socket
        DataOutputStream dos = new DataOutputStream(os);
        try {
            while(true){
                String line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("speak(): "+ie);
        } finally{
            try {
                if(dos !=null) dos.close();
                if(os !=null) os.close();
            } catch (IOException ie) {}
        }
    }

    
    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args ) {
        new AServer();
        
    }
    
}
