import java.io.*;
//keyboard->file


public class CCC {
    InputStream is; //public abstract, System.in�� ��ȯŸ��
    OutputStream os;
    String fname = "111test.txt";

    CCC(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname,true); //�߰��Ҷ�
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        try {
            byte[] bs = new byte[1];
            int count = 0;
            while ((count=is.read(bs)) != -1) {

                os.write(bs, 0, count);
            }
            os.flush(); //����ش�

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
        
        CCC ccc= new CCC();
        ccc.rw();
    }
    
}
