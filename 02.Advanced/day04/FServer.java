import java.io.*;
import java.net.*;

public class FServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    InputStream is;
    BufferedInputStream bis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    String fName = "";
    
    FServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"번 포트에서 연결 대기중");
            sc = ss.accept();
            makeStream();


        } catch (IOException ie) {
        } finally{
            try {
                if(sc !=null) sc.close();
                if(ss !=null) ss.close();
            } catch (IOException ie) {}
        }
    }

    void makeStream(){
        try {
            is = sc.getInputStream();
            bis = new BufferedInputStream(is,2048);
            fos = new FileOutputStream(fName);
            bos = new BufferedOutputStream(fos,2048);
        } catch (IOException ie) {}
    }

    void receive(){ //Socket->File
        int cnt = 0;
        long totalSize = 0;
        byte bs[] = new byte[512]; 
        try {
            while((cnt = bis.read(bs)) != -1){
                bos.write(bs,0,cnt);
                totalSize +=cnt;
                // pln("받기중....total Size: "+totalSize);
            } 
            bos.flush();
            pln("파일("+fName+") 받기 완료! ("+totalSize+"bytes)");
        } catch (Exception e) {
        } finally{
            closeALL();
        }

    }

    void closeALL(){
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

    public static void main(String[] args ) {
        new FServer();
        
    }
    
}
