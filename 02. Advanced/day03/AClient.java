import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AClient {
    Socket sc;
    // String ip1 = "127.0.0.1"; //�ڱ��ڽ�
    String ip2 = "192.168.1.15";
    String ip3 = "123.142.144.46"; //�����϶�
    int port = 2000;
    int port1 = 3000; //PC��ȭ�� ��Ʈ
    
    
    AClient() {

        try {
            sc = new Socket(ip3, port);
            pln("������ ���� �Ϸ�");
        } catch (UnknownHostException ue) {
            pln("�ش� ������ ã�� ����");
        } catch(IOException ie){}

    }

    void pln(String str){
        System.out.println(str);

    }

    public static void main(String[] args ) {
        AClient ac = new AClient();
        
    }
    
}
