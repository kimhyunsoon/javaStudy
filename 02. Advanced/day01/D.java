import java.io.*;
//file->file

public class D {
    InputStream is; //����
    OutputStream os; //����
    String src = "keyword_kaeun.txt";
    String dest = "day14.txt";

    D(){
        
        
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest); //�߰��Ҷ�
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[8]; //�����

        try {
            while(true){
                int count = is.read(bs);
                os.write(bs, 0, count);
                // os.write(bs);
                break;
            }

            os.flush();
            
        } catch (IOException e) {
            //TODO: handle exception
        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException ie) {
                //TODO: handle exception
            }
        }

    }

    public static void main(String[] args) {
        
        D d= new D();
        // b.rw();
        d.rw2();
    }
    
}
