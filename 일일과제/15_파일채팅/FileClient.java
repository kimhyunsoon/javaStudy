import java.io.*;
import java.net.*;

public class FileClient extends Thread{    
    Socket sc;
    String ip;
    int port;
    String name;

    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    public FileClient(){
        connect();
    }

    void connect(){//�����ϰ�, Ű����� �Է��ؼ� socket���� ����
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
            //start();
            p("ä��ID(�⺻ : Guest): ");
            try {
                dos = new DataOutputStream(sc.getOutputStream());
                name = br.readLine();
                name = name.trim();
                if(name.length() == 0) name = "Guest";
                dos.writeUTF(name);
                dos.flush();
            } catch (IOException ie){}
            
            //�������ۿ� Ŭ���� ȣ��
            String path = "C:/KAEUN/JAVA"; 
            String fName = "���纻_keyword_kaeun";
            FileSender fs = new FileSender(this);
            fs.start();
            //�޼������ۿ� Ŭ���� ȣ��
            String msg = "text";
            MsgSender ms = new MsgSender(this);
            ms.start();
            //speak();

        } catch (UnknownHostException ue) {
            pln("�ش� ������ ã�� ����");
            connect();
        } catch(IOException ie){
            connect();
        }

    }

    public void run(){
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
            try {
                if(dis != null) dis.close();
                if(dos !=null) dos.close();
                if(is != null) is.close();
                if(os != null) os.close();
                if(sc != null) sc.close();
            } catch (IOException ie) {}
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
    FileInputStream fis;
	BufferedInputStream bis;
	OutputStream os;
	BufferedOutputStream bos;
    DataOutputStream dos;

    Socket sc;
    String path; 
    String fName;

    
    FileClient fc;
    public FileSender(FileClient fc){
        this.fc = fc;
        //������ ���ۿ� ��Ʈ�� ����
        try {
            dos = new DataOutputStream(fc.sc.getOutputStream());
        } catch (FileNotFoundException fe) {
        } catch (IOException ie){}

    }
    
    public void run(){
        try {
            dos.writeUTF("File");
            dos.flush();
            String result = send(dos);
            fc.pln(result);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    String send (DataOutputStream dos){
        String result = "";
        int count = 0;
        byte[] bs = new byte[512];
        long totalSize = 0;
        try {
            dos.writeUTF(fName);
            File file = new File(path + "/" +fName);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            while ((count = bis.read(bs)) != -1) {
                dos.write(bs, 0, count);
                totalSize += count; //������Կ�����
            }
            dos.flush();
            fc.pln("���� ���ۿϷ� / size: "+totalSize);
        } catch (IOException ie) {
        } finally{
            try {
                if(dos != null) dos.close();
                if(bis != null) bis.close();
                if(fis != null) fis.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return result;
    }
}


//�޼��� ���ۿ� Ŭ����

class MsgSender extends Thread{
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String name;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    FileClient fc;

    public MsgSender(FileClient fc){
        this.fc = fc;
        //������ ���ۿ� ��Ʈ�� ����
        try {
            dos = new DataOutputStream(fc.sc.getOutputStream());
        } catch (FileNotFoundException fe) {
        } catch (IOException ie){}
    }

    public void run(){ //Ű����->socket
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
            if(fc.sc != null) fc.sc.close();
        } catch (IOException ie) {}
    }
}
