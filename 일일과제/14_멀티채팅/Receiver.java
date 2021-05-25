import java.io.*;
import java.net.*;

public class Receiver extends Thread{
    MainServer ms;
    Socket sc;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

   
    Receiver(MainServer ms){
        //���Ͽ� �ִ� ������ �о�� ��
        this.ms = ms; //this�� 3��° ��� : �ڽ��� �����ڸ� ȣ���Ҷ�
        this.sc = ms.sc; //Socket�� �� �� �ְ� ��
        try {
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException ie) {}
    }

    public void run(){
        listen();
        
    }
    void listen(){ //Socket�� �ִ� ������ ->�����, �ٸ� Ŭ���̾�Ʈ
        String name = "";
        String msg = "";
        
        try {
            name = dis.readUTF(); //Ŭ���̾�Ʈ�� �Է��ϴ� ù���� �г������� ����
            sendMessage(name+"�� ����!");
            pln(name+"�� ����!");
            pln("���� ���� ������ ����" + ms.list.size()+"���Դϴ�.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //�޼����� �Էµ� ���� ����
            }
        } catch (IOException ie) { //
            ms.list.remove(this);
            sendMessage(name+"�� ����!"+ms.list.size()+"���Դϴ�");
            pln(name+"�� ����!"+ms.list.size()+"���Դϴ�");
        }
    }

    void sendMessage(String msg){//�迭�� �Էµ� ������ �� ������ ���
        try {
            for(Receiver receiver: ms.list){
                receiver.dos.writeUTF(msg);
                receiver.dos.flush();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    
}
