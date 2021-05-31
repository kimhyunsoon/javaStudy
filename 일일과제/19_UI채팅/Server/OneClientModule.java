import java.io.*;
import java.net.*;

public class OneClientModule extends Thread{

    Socket sc;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

    //�����ϰ� Ű����� �Է��ؼ� socket���� ����
    ServerGUI sg;
    OneClientModule(ServerGUI sg){
        //���Ͽ� �ִ� ������ �о�� ��
        this.sg = sg; //this�� 3��° ��� : �ڽ��� �����ڸ� ȣ���Ҷ�
        this.sc = sg.sc; //Socket�� �� �� �ְ� ��
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
            pln("���� ���� ������ ����" + sg.v.size()+"���Դϴ�.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //�޼����� �Էµ� ���� ����
            }
        } catch (IOException ie) { //
            sg.v.remove(this);
            sendMessage(name+"�� ����!"+sg.v.size()+"���Դϴ�");
            pln(name+"�� ����!"+sg.v.size()+"���Դϴ�");
        } finally{
            closeAll();
        }
    }

    void sendMessage(String msg){//�迭�� �Էµ� ������ �� ������ ���
        try {
            for(OneClientModule ocm: sg.v){
                ocm.dos.writeUTF(msg);
                ocm.dos.flush();
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
