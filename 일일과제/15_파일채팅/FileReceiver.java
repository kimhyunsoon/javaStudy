import java.io.*;
import java.net.*;

public class FileReceiver extends Thread{

    Socket sc;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

    BufferedInputStream bis;
    FileOutputStream fos;
    BufferedOutputStream bos;

    String fName = "";

    //�����ϰ� Ű����� �Է��ؼ� socket���� ����
    FileServer fs;
    FileReceiver(FileServer fs){
        //���Ͽ� �ִ� ������ �о�� ��
        this.fs = fs; //this�� 3��° ��� : �ڽ��� �����ڸ� ȣ���Ҷ�
        this.sc = fs.sc; //Socket�� �� �� �ְ� ��
        makeTextST();
        makeFileST();

    }

    public void run(){
        listen();
        receive();
        
    }

    void makeTextST(){ //make �ؽ�Ʈ�� �ޱ� ���� ��Ʈ��
        try {
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException ie) {}

    }



    void makeFileST(){
        try {
            is = sc.getInputStream();
            bis = new BufferedInputStream(is,2048);
            fos = new FileOutputStream(fName);
            bos = new BufferedOutputStream(fos,2048);
        } catch (IOException ie) {}
    }

    

    void receive(){ //Socket -> File
        int cnt = 0;
        byte bs[] = new byte[512];
        try {
            while((cnt = bis.read(bs)) != -1){
                bos.write(bs, 0, cnt);
            }
            bos.flush();
            pln(fName+"�ޱ� �Ϸ�");
        } catch (Exception e) {
        } finally{
            closeFileST();
        }
    }


    void listen(){ //Socket�� �ִ� ������ ->�����, �ٸ� Ŭ���̾�Ʈ
        String name = "";
        String msg = "";
        
        try {
            name = dis.readUTF(); //Ŭ���̾�Ʈ�� �Է��ϴ� ù���� �г������� ����
            sendMessage(name+"�� ����!");
            pln(name+"�� ����!");
            pln("���� ���� ������ ����" + fs.v.size()+"���Դϴ�.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //�޼����� �Էµ� ���� ����
            }
        } catch (IOException ie) { //
            fs.v.remove(this);
            sendMessage(name+"�� ����!"+fs.v.size()+"���Դϴ�");
            pln(name+"�� ����!"+fs.v.size()+"���Դϴ�");
        } finally{
            closeTextST();
        }
    }

    void sendMessage(String msg){//�迭�� �Էµ� ������ �� ������ ���
        try {
            for(FileReceiver receiver: fs.v){
                receiver.dos.writeUTF(msg);
                receiver.dos.flush();
            }
        } catch (IOException ie) {
            //TODO: handle exception
        }
    }

	void closeTextST(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(sc != null) sc.close();
		}catch(IOException ie){}
	}

    void closeFileST(){
        try {
            if (bis != null) bis.close();
            if(is !=null) is.close();
            if(bos != null) bos.close();
            if(fos != null) fos.close();
        } catch (IOException ie) {
            //TODO: handle exception
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    
}
