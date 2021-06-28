import java.io.*;
import java.net.*;

public class FFServer {
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    InputStream is;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileOutputStream fos;
    String fName = "���纻_keyword_kaeun";
    

    FFServer(){
        try {
            ss = new ServerSocket(port);
            pln(port+"���� ���� �����");
            sc = ss.accept();
            makeStream();
            receive();
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
            is = sc.getInputStream(); //node
            bis = new BufferedInputStream(is,2048); //filter
            fos = new FileOutputStream(fName); //node
            bos = new BufferedOutputStream(fos,2048); //filter
        } catch (IOException ie) {}
    }

    void closeAll(){
        try {
            if (bos !=null) bos.close();
            if (fos !=null) fos.close();
            if (bis !=null) bos.close();
            if (is !=null) is.close();
        } catch (IOException ie) {
        }
    }

    void receive(){ //socket->file
        int count = 0;
        byte[] bs = new byte[512];
        long totalSize = 0;
        try {
            while ((count = bis.read(bs)) != -1) {
                bos.write(bs, 0, count);
                totalSize += count; //������Կ�����
            }
            bos.flush();
            pln("����: ("+fName+") �ٿ�ε� �Ϸ� / size: "+totalSize);
        } catch (IOException ie) {
        } finally{
            closeAll();
        }
    }

    void pln(String str){
        System.out.println(str);

    }


    public static void main(String[] args) {

        new FFServer();
        
    }
    
}
