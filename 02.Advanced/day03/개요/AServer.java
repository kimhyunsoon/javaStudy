import java.io.*;
import java.net.*;

//Well-Known port : 0~1023��. ������� ����.�ý��� ���ο��� ����� �� �ֱ� ����
public class AServer {
    
    ServerSocket ss;
    Socket sc; // �������� �̵� ���
    int port = 2000; //������ ���, ����Ʈ�� ȣ��

    
    AServer(){
        
        try {
            ss = new ServerSocket(port); //������ ��Ʈ�� �����ָ� ��
            pln(port+"�� ��Ʈ���� ���� �����...");
            sc = ss.accept(); //����, ���
            pln("Ŭ���̾�Ʈ("+sc.getInetAddress().getHostAddress()+")�� ���� �Ϸ�!");
            
        } catch (IOException ie) {
            pln(""+ie);

        }
        


    }

    void pln(String str){
        System.out.println(str);

    }

    public static void main(String[] args) {
        AServer as = new AServer();
        
        
    }
}
