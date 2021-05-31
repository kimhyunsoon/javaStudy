import java.io.*;
import java.net.*;

public class MainClient extends Thread{
    Socket sc;
    String ip = "127.0.0.1";
    int port = 3000;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String name;

    ClientGUI cg;

    MainClient(){
        connect();
    }

    MainClient(ClientGUI cg){
        this.cg = cg;
        this.name = cg.name;
    }
    


    //�����ϰ�, Ű����� �Է��ؼ� socket���� ����
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    void connect(){
        //����
        try {
            sc = new Socket(ip,port);
            pln("������ ����Ǿ����ϴ�.");

            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            start();
            speak();

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
            closeAll();
        }

    }

    void speak(){ //Ű����->socket
        try {

            if(name.length() == 0) name = "Guest";
            dos.writeUTF(name);
            dos.flush();
            inputMSG();
        } catch (IOException ie) {
        } finally{
            closeAll();
        }

    }

    void inputMSG(){
        try {
            while(true){
                String msg = br.readLine();
                dos.writeUTF(name+">> "+msg);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

    void closeAll(){
        try {
            if(dis != null) dis.close();
            if(dos !=null) dos.close();
            if(is != null) is.close();
            if(os != null) os.close();
            if(sc != null) sc.close();
        } catch (IOException ie) {}
    }

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }

    public static void main(String[] args) {
        new MainClient();
        
    }
    
}
