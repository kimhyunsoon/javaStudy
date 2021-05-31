import java.io.*;
import java.net.*;
import java.util.*;

public class ServerGUI extends Thread{
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    //ArrayList<Receiver> list = new ArrayList<Receiver>();
    Vector<OneClientModule> v = new Vector<OneClientModule>();
    OneClientModule ocm;
    
    //�迭�� Receiver Ŭ�������� ���� ����Ÿ�� ����
    
    ServerGUI(){
        try {
            ss = new ServerSocket(port);
            pln(port+"�� ��Ʈ���� ���� �����...");
            start();
            while(true){
                sc = ss.accept();
                ocm = new OneClientModule(this);
                //this�� ���μ�����. Receiver Ŭ������ �ڽ��� ��ü�� �ѱ�(2�� ���)
                v.add(ocm);
                ocm.start();
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
                    ocm = v.get(0);
                    ocm.sendMessage("server>> : " +msg);
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
        new ServerGUI();
        
    }
    
}
