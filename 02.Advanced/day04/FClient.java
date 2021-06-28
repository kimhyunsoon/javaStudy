import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FClient {
    
    Socket sc;
    String ip = "127.0.0.1"; //자신의 서버
    int port = 3000;
    String path = "";
    FileInputStream fis;
    BufferedInputStream bis;
    OutputStream os;
    BufferedOutputStream bos;
    
    FClient(){
        try {
            sc = new Socket(ip,port); 
            makeStream();
            send();
            
        } catch(UnknownHostException ue){
            pln("서버를 찾지 못함");
        } catch (IOException ie) {
        } finally{
            try{
                if(sc !=null) sc.close();
            }catch(IOException ie){}
        }
    }

    void makeStream(){
        try {
            fis = new FileInputStream(path);
            bis = new BufferedInputStream(fis,2048);
            os = sc.getOutputStream();
            bos = new BufferedOutputStream(os,2048);
        } catch (FileNotFoundException fe) {
        }catch (IOException ie) {}
    }
    void send(){ //Socket->File
        int cnt = 0;
        long totalSize = 0;
        byte bs[] = new byte[512]; 
        try {
            while((cnt = bis.read(bs)) != -1){
                bos.write(bs,0,cnt);
                totalSize +=cnt;
                // pln("보내기중....total Size: "+totalSize);
            } 
            bos.flush();
            pln("파일 전송 완료! ("+totalSize+"bytes)");
        } catch (Exception e) {
        } finally{
            closeALL();
        }

    }

    void closeALL(){
        try {
            if (bos != null) bos.close();
            if(bis !=null) bis.close();
            if(os != null) os.close();
            if(fis != null) fis.close();
        } catch (IOException ie) {
            //TODO: handle exception
        }
    }

    void pln(String str){
		System.out.println(str);
	}

    

    public static void main(String[] args) {
        new FClient();
        
    }
}
