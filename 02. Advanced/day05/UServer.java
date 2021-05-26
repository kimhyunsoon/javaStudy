import java.io.*;
import java.net.*;
//UDP : �񿬰�����
public class UServer { 
    DatagramSocket ds; //�޼�����(��ü��)
    DatagramPacket dp; //�޼���Ʋ(��������)
    int port = 7000;

    UServer(){ //������ ȣ������� �ݺ�ȣ��(���ȣ��)�� ��ƴ�. ��ü�� �Ź� ��������� ����
        try {
            ds = new DatagramSocket(port); //���������� UDP ���� , �����ͼ��� �߻�
            pln(port+"������ UDP���� �����..");
            byte[] buf = new byte[2048];
            dp = new DatagramPacket(buf, buf.length); //����Ʈ�迭�� ����
            //dp�� ����Ʈ�迭�� ����Ǿ� �ִ�? ���ڴ� ������ �����ϱ� ��Ʈ������ ��ȯ�ؾ� �Ѵ�
            while(true){ //���Ͽ��� �о ����Ϳ� ����
                ds.receive(dp); //accept�� UDP����, IO�ͼ��� �߻�
                String msg= new String(buf);
                msg = msg.trim();
                pln("Client>>"+msg);

                for(int i = 0;i<buf.length;i++) buf[i] =0; //�޼��� ���� ������ �ʱ�ȭ
            }
        } catch (SocketException se) {
        } catch (IOException ie){
        }finally{
            if(ds !=null) ds.close(); //��Ŷ�� Ŭ��� ����
        }
    }


    void pln(String str){
        System.out.println(str);
    }


    public static void main(String[] args){
        new UServer();

    }
    
}
