import java.io.*;
//Ű����� �Է¹ް� ���Ϸ�

public class BBBB {
    InputStream is; // abstract, ��ü���� �ȵ�, �Ϻ����ڽ�Ŭ����
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
