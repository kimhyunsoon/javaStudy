import java.io.*;
//파일에서 파일로

public class DD {
    InputStream is;
    OutputStream os;
    String src = "keyword_kaeun.txt";
    String dest = "DDtest.txt";
    
    DD(){
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
        } catch (FileNotFoundException fe) {
        }
    }

    void rw(){
        byte[] bs = new byte [512];
        int count = 0;
        try {
            while ((count = is.read(bs)) != -1) {
                os.write(bs, 0, count);
            }
            System.out.println("복사성공!");
            os.flush();
        } catch (IOException ie) {
        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException ie) {
            }
        }
        
    }

    public static void main(String[] args) {
        DD dd = new DD();
        dd.rw();        
        
    }



}
