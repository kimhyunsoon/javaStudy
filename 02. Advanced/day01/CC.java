import java.io.*;
//Ű����� �Է¹����� ���Ϸ� �̴°ǵ� ������ byte[]��

public class CC {
    InputStream is;
    OutputStream os;
    String fname = "CCtest.txt";
    
    CC(){
        is = System.in;
        try {
            os = new FileOutputStream(fname); 
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        byte[] bs = new byte [8];
        int count = 0;
        
        try {
            while ((count = is.read(bs)) != -1) {
                is.read(bs);
                os.write(bs, 0, count);
            }
            os.flush();
        } catch (IOException e) {
        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException e) {
            }
        }
        
    }

    public static void main(String[] args) {
        CC cc= new CC();
        cc.rw();
        
    }

}
