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

    //접속하고 키보드로 입력해서 socket으로 보냄
    FileServer fs;
    FileReceiver(FileServer fs){
        //소켓에 있는 정보를 읽어야 함
        this.fs = fs; //this의 3번째 용법 : 자신의 생성자를 호출할때
        this.sc = fs.sc; //Socket을 쓸 수 있게 됨
        makeTextST();
        makeFileST();

    }

    public void run(){
        listen();
        receive();
        
    }

    void makeTextST(){ //make 텍스트를 받기 위한 스트림
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
            pln(fName+"받기 완료");
        } catch (Exception e) {
        } finally{
            closeFileST();
        }
    }


    void listen(){ //Socket에 있는 정보를 ->모니터, 다른 클라이언트
        String name = "";
        String msg = "";
        
        try {
            name = dis.readUTF(); //클라이언트가 입력하는 첫줄은 닉네임으로 받음
            sendMessage(name+"님 입장!");
            pln(name+"님 입장!");
            pln("현재 서버 접속자 수는" + fs.v.size()+"명입니다.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //메세지가 입력될 동안 수행
            }
        } catch (IOException ie) { //
            fs.v.remove(this);
            sendMessage(name+"님 퇴장!"+fs.v.size()+"명입니다");
            pln(name+"님 퇴장!"+fs.v.size()+"명입니다");
        } finally{
            closeTextST();
        }
    }

    void sendMessage(String msg){//배열에 입력된 정보를 다 꺼내서 출력
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
