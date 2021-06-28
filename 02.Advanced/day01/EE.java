import java.io.*;
//파일에서 모니터로
//주제: FileInputStream & FileOutputStream

public class EE {
    InputStream is;
    OutputStream os;
    String src = "keyword_kaeun.txt";

    EE(){
       try {
            is = new FileInputStream(src);
            os = System.out;
        } catch (FileNotFoundException fe) {
           //TODO: handle exception
        }
    }

    void rw(){
        byte bs[] = new byte[512];
        int count = 0;
        try {
            while ((count = is.read(bs)) !=-1) {
                os.write(bs, 0, count);
            }
            os.flush();
        } catch (IOException ie) {
        } finally{
            try {
                is.close();
                os.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        EE ee = new EE();
        ee.rw();
    }
}
