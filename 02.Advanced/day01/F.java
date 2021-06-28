import java.io.*;
//주제: BufferedInputStream & BufferedOutputStream
//file --->monitor, file

public class F {

    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;
    OutputStream os;

    
    String src = "F.java"; //파일이 없을 경우에 NullPointerException 발생
    String dest = "F_copy.txt";

    F(){
        try {
            fis = new FileInputStream(src); //node
            os = System.out; //node
            fos = new FileOutputStream(dest);
        } catch (FileNotFoundException fe) {
        } 

        bis = new BufferedInputStream(fis, 2048); //filter
        bos = new BufferedOutputStream(fos, 2048);
        //buffer size(쇼핑카트) : 2048
    }

    void rw(){
        int count = 0;
        byte bs[] = new byte[256]; //계란판
        try {
            while ((count = bis.read(bs)) != -1) {
                bos.write(bs, 0, count); //to file
                os.write(bs, 0, count);  //to monitor
            }
            bos.flush();
            System.out.println("복사완료("+dest+")");
        } catch (IOException ie) {
        } finally{
            try {
                if(bis !=null) bis.close(); //NullPointerException 발생하기 때문에 안전장치
                if(bos !=null) bos.close();
                if(fos !=null) fos.close();
                if(fis !=null) fis.close();
                if(os !=null) os.close();
            } catch (IOException ie) {
            }
        }
    }
    public static void main(String[] args) {
        F f = new F();
        f.rw();
        
    }
}
