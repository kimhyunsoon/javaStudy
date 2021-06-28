import java.io.*;
import java.net.*;
//������, ��������

public class UClient {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket ds; //�޼�����(��ü��)
    DatagramPacket dp; //�޼���Ʋ(��������)
    String ip ;
    int port = 7000;

    UClient(){
        init(); //�ʱ�ȭ�ϴ� �޼ҵ�, �ݺ�ȣ���ϰ� �� ���� ������ �ƿ� �޼ҵ��
    }

    void init(){ //Ű���忡�� �о ���Ͽ� ����
        
        inputIP();
        try {
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
         }
        catch (IOException ie){

        }finally{
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


    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args){
        new UClient();

    }
    
}
