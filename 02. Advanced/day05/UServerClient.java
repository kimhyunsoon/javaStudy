import java.io.*;
import java.net.*;
//������, ��������

public class UServerClient extends Thread{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ip ;
    int port = 7000;

    UServerClient(){
        init(); //�ʱ�ȭ�ϴ� �޼ҵ�, �ݺ�ȣ���ϰ� �� ���� ������ �ƿ� �޼ҵ��
    }

    void init(){ //Ű���忡�� �о ���Ͽ� ����
        DatagramSocket ds = null; //�޼�����(��ü��)
        DatagramPacket dp = null; //�޼���Ʋ(��������)

        inputIP();
        try {
            start(); //JVM�� �����带 �����ؼ� ���� ȣ��, �ð��� �ɸ�
            try {
                Thread.sleep(10); //���� ȣ���ؼ� ���� ���°ͺ��� ���� ����ǰ�
            } catch (Exception e) {
            }
        ds = new DatagramSocket();
        while(true){
            p("������ �޼���: ");
            String msg = br.readLine(); //��Ʈ���� ����Ʈ�迭�� �ٲ�� �� getBytes();
            byte[] buf = msg.getBytes();
            InetAddress ia = InetAddress.getByName(ip); //����Ʈ ��
            dp = new DatagramPacket(buf, buf.length, ia, port); //���������� �ּҸ� ����Ѵ�
            ds.send(dp);
            pln("���ۿϷ�!!");
        }
        } catch (SocketException se) {
        } catch (UnknownHostException ue){
            pln("��Ʈ��ũ �� �ش� ������ ã�� �� ����");
            init();
        } catch (IOException ie){
        } finally{
            if(ds != null) ds.close();
        }
    }

    void inputIP(){
        try {
            p("IP�Է�: ");
            ip = br.readLine();
            if(ip !=null) ip = ip.trim();
            if(ip.length()==0) ip = "123.142.144.46";
        } catch (IOException ie) {
            inputIP(); //���ȣ��
        }
    }

    public void run(){
        DatagramSocket ds = null; //�޼�����(��ü��)
        DatagramPacket dp = null; //�޼���Ʋ(��������)
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
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args){
        new UServerClient().init();

    }
    
}
