import java.io.*;
import java.net.*;

public class UUUClient {
    DatagramSocket ds;
    DatagramPacket dp;
    int port = 7000;
    String ip = "127.0.0.1";
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 

    UUUClient(){
        init();
    }

    void init(){
        inputIP();
        try {
            ds = new DatagramSocket();
            while(true){ //�޼��� ��� ������ ������ �ݺ���
                p("���� �޼���: ");
                String msg = br.readLine(); //��Ʈ���� ����Ʈ�迭�� �ٲ㼭 �־���� ��
                byte[] buf = msg.getBytes();
                InetAddress ia = InetAddress.getByName(ip);
                dp = new DatagramPacket(buf, buf.length, ia, port);
                ds.send(dp);
                pln("���ۿϷ�!");
            }
        } catch (SocketException se) {
        } catch (UnknownHostException ue){
            pln("������ ã�� �� ����");
            init();
        }catch (IOException ie){
        } finally{
            try {
                if(ds !=null) ds.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }

    void inputIP(){
        try {
            p("IP�Է�(�⺻: 127.0.0.1) : ");
            ip = br.readLine();
            if(ip != null)ip = ip.trim();
            if(ip.length() == 0) ip = "127.0.0.1";
        } catch (IOException ie) {
            inputIP();
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }
    
    public static void main(String[] args ){
        new UUUClient();

    }
}
