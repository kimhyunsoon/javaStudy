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
    String fName = "복사본_keyword_kaeun";
    

    //접속하고, 키보드로 입력해서 socket으로 보냄
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    FileClient(){
        connect();
    }

    void connect(){
        //접속
        try {
            p("서버IP 입력(기본:127.0.0.1) : ");
            ip = br.readLine();
            ip = ip.trim();
            if(ip.length()==0) ip = "127.0.0.1";
            p("PORT 입력(기본 : 3000) : ");
            String strPort = br.readLine();
            strPort = strPort.trim();
            if(strPort.length()==0) strPort = "3000"; 
            port = Integer.parseInt(strPort);
            sc = new Socket(ip,port);
            pln("서버에 연결되었습니다.");
            
            //파일전송용 클래스 호출
            FileSender fs = new FileSender(this);
            fs.start();
            //메세지전송용 클래스 호출
            MsgSender msg = new MsgSender(this);
            msg.start();


            speak();

        } catch (UnknownHostException ue) {
            pln("해당 서버를 찾지 못함");
            connect();
        } catch(IOException ie){
            connect();
        }

    }

    void speak(){ //키보드->socket
        p("채팅ID(기본 : Guest): ");
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


//파일전송용 클래스

class FileSender extends Thread{
    
    FileClient fc;
    FileSender(FileClient fc){
        this.fc = fc;
        //데이터 전송용 스트림 생성
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
                totalSize += count; //산술대입연산자
            }
            bos.flush();
            pln("파일 전송완료 / size: "+totalSize);
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

}


//메세지 전송용 클래스

class MsgSender extends Thread{
    FileClient fc;

    MsgSender(FileClient fc){
        this.fc = fc;
        //메세지 전송용 스트림 생성
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
            pln("서버 다운.. 2초 후에 종료됩니다.");
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
