import java.io.*;
import java.net.*;

public class FFClient {
    Socket sc;
    String ip;
    int port = 3000;
    String path = "C:/KAEUN/JAVA/복사본_keyword_kaeun";
    FileInputStream fis;
    BufferedInputStream bis;
    OutputStream os;
    BufferedOutputStream bos;

    FFClient(){
        try {
            sc = new Socket(ip,port);
            makeStream();
            send();

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }finally{
            try {
                if(sc !=null) sc.close();
            } catch (IOException ie) {
                //TODO: handle exception
            }
        }
    }

    
    void makeStream(){
        try {
            fis = new FileInputStream(path); //node
            bis = new BufferedInputStream(fis,2048); //filter
            os = sc.getOutputStream(); //node
            bos = new BufferedOutputStream(os,2048); //filter
        } catch (FileNotFoundException fe) {
        } catch (IOException ie){}
    }

    void closeAll(){
        try {
            if (bos !=null) bos.close();
            if (bis !=null) bis.close();
            if (os !=null) os.close();
            if (fis !=null) fis.close();
        } catch (IOException ie) {
        }
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
    
    void pln(String str){
        System.out.println(str);

    }
    

    public static void main(String[] args) {
        new FFClient();
        
    }
}
