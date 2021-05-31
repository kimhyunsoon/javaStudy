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
    


    //접속하고, 키보드로 입력해서 socket으로 보냄
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    void connect(){
        //접속
        try {
            sc = new Socket(ip,port);
            pln("서버에 연결되었습니다.");

            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            start();
            speak();

        } catch (UnknownHostException ue) {
            pln("해당 서버를 찾지 못함");
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
            pln("서버 다운.. 2초 후에 종료됩니다.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException ie2){}
        } finally{
            closeAll();
        }

    }

    void speak(){ //키보드->socket
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
