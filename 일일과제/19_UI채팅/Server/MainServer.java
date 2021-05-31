import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    //ArrayList<Receiver> list = new ArrayList<Receiver>();
    Vector<Receiver> v = new Vector<Receiver>();
    Receiver receiver;
    
    //�迭�� Receiver Ŭ�������� ���� ����Ÿ�� ����
    
    MainServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"�� ��Ʈ���� ���� �����...");
            start();
            while(true){
                sc = ss.accept();
                receiver = new Receiver(this);
                //this�� ���μ�����. Receiver Ŭ������ �ڽ��� ��ü�� �ѱ�(2�� ���)
                v.add(receiver);
                receiver.start();
            }
        } catch (IOException ie) {
            pln(port+"�� ��Ʈ�� �̹� �����");
        } finally{
            try {
                if(ss !=null) ss.close();
            } catch (IOException ie) {

            }
        }
    }

    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        String msg = "";
        try {
            while(true){
                msg = br.readLine();
                msg = msg.trim();
                if(v.size() !=0){ 
                    receiver = v.get(0);
                    receiver.sendMessage("server>> : " +msg);
                }else{
                    pln("���� ������ Ŭ���̾�Ʈ�� �����ϴ�");
                }
            }
        } catch (IOException ie) {
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {
        new MainServer();
        
    }
    
}
