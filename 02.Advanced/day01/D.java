import java.io.*;
//file->file

public class D {
    InputStream is; //����
    OutputStream os; //����
    String src = "keyword_kaeun.txt";
    String dest = "Dtest.txt";

    D(){

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest); 
            //os = system.out;
        }catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[512]; //�����
        try {
            int count = 0;
            while((count = is.read(bs)) != -1){
                os.write(bs, 0, count);
            }
            os.flush();
        } catch (IOException e) {
        } finally{
            try {
                is.close();
                os.close();
            }catch (IOException ie) {
            }
        }
    }

    public static void main(String[] args) {
        
        D d= new D();
        d.rw2();
    }
}
