import java.io.*;

public class FF {

    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;


    
    String src = "C:\\KAEUN\\JAVA\\keyword_kaeun.txt"; //파일이 없을 경우에 NullPointerException 발생
    String dest = "F_copy.txt";

    FF(){
        try {
            fis = new FileInputStream(src); //node
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
            } catch (IOException ie) {
            }
        }
    }
    public static void main(String[] args) {
        FF ff = new FF();
        ff.rw();
        
    }
}
