import java.io.*;
import java.net.*;
import java.util.*;

public class MainServer extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    ArrayList<Receiver> list = new ArrayList<Receiver>();
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
                list.add(receiver);
                receiver.start();
            }
        } catch (IOException ie) {
            //TODO: handle exception
        }
       
    }

    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public void run(){
        String msg = "";
        try {
            while(true){
                msg = br.readLine();

            }
        } catch (IOException ie) {
            //TODO: handle exception
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
