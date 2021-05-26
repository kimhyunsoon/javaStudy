import java.io.*;
import java.net.*;
//UDP : �񿬰�����

public class UUUServer {
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 7000;

    UUUServer(){ //
        try {
            ds = new DatagramSocket(port); //���������� UDP����, �����ͼ��� �߻�
            pln(port+"�� ��Ʈ���� �������� �����");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length);
            //dp�� ����Ʈ�迭�� ����Ǿ� �ִ�. ���ڴ� ���� �� ������ ��Ʈ������ ��ȯ�ؾߵ�
            //�޼��� ��� �ް� ������

            while(true){ 
                ds.receive(dp); //accept�� UDP����, IO�ͼ��� �߻�
                pln("���Ἲ��");
                String msg = new String(buf);
                msg = msg.trim();
                pln("Client>> "+msg);
                for(int i = 0;i<buf.length;i++) buf[i] =0; //�޼��� ���� ������ �ʱ�ȭ
            }
        } catch (SocketException se) {
        } catch(IOException ie){
        } finally{
            if(ds !=null) ds.close(); //��Ŷ�� Ŭ��� ����
        }

    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new UUUServer();
        
    }
    
}
