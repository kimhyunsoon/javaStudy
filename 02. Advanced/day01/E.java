import java.io.*;
//file->monitor
//주제: FileInputStream & FileOutputStream

public class E {
    InputStream is; //파일
    OutputStream os; //모니터
    String src = "keyword_kaeun.txt";
    String dest = "Etest.java";

    E(){

        try {
            is = new FileInputStream(src);
            // os = new FileOutputStream(dest);
            os = System.out;
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[512]; //계란판
        try {
            int count = 0;
            while((count = is.read()) != -1){
                os.write(bs, 0, count);
            }
            System.out.println("복사성공!");
            os.flush();
        } catch (IOException e) {
        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException ie) {
            }
        }
    }

    public static void main(String[] args) {
        
        E e= new E();
        e.rw2();
    }
}
