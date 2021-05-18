import java.io.*;
//키보드로 입력받고 파일로

public class BBBB {
    InputStream is; // abstract, 객체생성 안돼, 완벽한자식클래스
    OutputStream os; // node stream
    String fname = "BBBBtest.txt";

    BBBB(){
        is = System.in;
        try {
            os = new FileOutputStream(fname,true);
        } catch (FileNotFoundException fe) {
        }
    }

    void rw(){
        try {
            int b = 0;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
            os.flush();
        } catch (IOException ie) {
        }
    }

    public static void main(String[] args) {
        BBBB bbbb = new BBBB();
        bbbb.rw();
    }
}
