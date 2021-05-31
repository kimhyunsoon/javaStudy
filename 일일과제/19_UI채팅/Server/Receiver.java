import java.io.*;
import java.net.*;

public class Receiver extends Thread{

    Socket sc;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

    //�����ϰ� Ű����� �Է��ؼ� socket���� ����
    MainServer ms;
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
            pln("���� ���� ������ ����" + ms.v.size()+"���Դϴ�.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //�޼����� �Էµ� ���� ����
            }
        } catch (IOException ie) { //
            ms.v.remove(this);
            sendMessage(name+"�� ����!"+ms.v.size()+"���Դϴ�");
            pln(name+"�� ����!"+ms.v.size()+"���Դϴ�");
        } finally{
            closeAll();
        }
    }

    void sendMessage(String msg){//�迭�� �Էµ� ������ �� ������ ���
        try {
            for(Receiver receiver: ms.v){
                receiver.dos.writeUTF(msg);
                receiver.dos.flush();
            }
        } catch (IOException ie) {
            //TODO: handle exception
        }
    }

	void closeAll(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(sc != null) sc.close();
		}catch(IOException ie){}
	}

    void pln(String str){
        System.out.println(str);
    }
    
}
