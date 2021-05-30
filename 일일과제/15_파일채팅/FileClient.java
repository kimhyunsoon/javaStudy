import java.io.*;
import java.net.*;

public class FileClient extends Thread{
    Socket sc;
    String ip;
    int port;
    InputStream is;

    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String name;
    FileInputStream fis;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    String path = "C:/KAEUN/JAVA"; 
    String fName = "���纻_keyword_kaeun";
    

    //�����ϰ�, Ű����� �Է��ؼ� socket���� ����
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    FileClient(){
        connect();
    }

    void connect(){
        //����
        try {
            p("����IP �Է�(�⺻:127.0.0.1) : ");
            ip = br.readLine();
            ip = ip.trim();
            if(ip.length()==0) ip = "127.0.0.1";
            p("PORT �Է�(�⺻ : 3000) : ");
            String strPort = br.readLine();
            strPort = strPort.trim();
            if(strPort.length()==0) strPort = "3000"; 
            port = Integer.parseInt(strPort);
            sc = new Socket(ip,port);
            pln("������ ����Ǿ����ϴ�.");
            
            //�������ۿ� Ŭ���� ȣ��
            FileSender fs = new FileSender(this);
            fs.start();
            //�޼������ۿ� Ŭ���� ȣ��
            MsgSender msg = new MsgSender(this);
            msg.start();


            speak();

        } catch (UnknownHostException ue) {
            pln("�ش� ������ ã�� ����");
            connect();
        } catch(IOException ie){
            connect();
        }

    }

    void speak(){ //Ű����->socket
        p("ä��ID(�⺻ : Guest): ");
        try {
            name = br.readLine();
            name = name.trim();
            if(name.length() == 0) name = "Guest";
            dos.writeUTF(name);
            dos.flush();
            inputMsg();
        } catch (IOException ie) {
        } finally{
        }

    }
    
    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {
        new FileClient();
        
    }
    
}


//�������ۿ� Ŭ����

class FileSender extends Thread{
    
    FileClient fc;
    FileSender(FileClient fc){
        this.fc = fc;
        //������ ���ۿ� ��Ʈ�� ����
        try {
            fis = new FileInputStream(path); //node
            bis = new BufferedInputStream(fis,2048); //filter
            os = sc.getOutputStream(); //node
            bos = new BufferedOutputStream(os,2048); //filter
        } catch (FileNotFoundException fe) {
        } catch (IOException ie){}

    }
    
    void run(){
        send();
    }
    
    void send(){
        int count = 0;
        byte[] bs = new byte[512];
        long totalSize = 0;
        try {
            while ((count = bis.read(bs)) != -1) {
                bos.write(bs, 0, count);
                totalSize += count; //������Կ�����
            }
            bos.flush();
            pln("���� ���ۿϷ� / size: "+totalSize);
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

}


//�޼��� ���ۿ� Ŭ����

class MsgSender extends Thread{
    FileClient fc;

    MsgSender(FileClient fc){
        this.fc = fc;
        //�޼��� ���ۿ� ��Ʈ�� ����
        try {
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException ie){}
    }

    void run(){
        try {
            while(true){
                String msg = dis.readUTF();
                pln(msg);
            }
        } catch (IOException ie) {
            pln("���� �ٿ�.. 2�� �Ŀ� ����˴ϴ�.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
        } finally{
            closeAll();
        }
    }



    void inputMsg(){
        try {
            while(true){
                String msg = br.readLine();
                dos.writeUTF(name+">> "+msg);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally{
            closeMsg();
        }
    }

    void closeMsg(){
        try {
            if(dis != null) dis.close();
            if(dos !=null) dos.close();
            if(is != null) is.close();
            if(os != null) os.close();
            if(sc != null) sc.close();
        } catch (IOException ie) {}
    }
    
}
