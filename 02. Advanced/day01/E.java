import java.io.*;
//file->monitor

public class E {
    InputStream is; //파일
    OutputStream os; //파일
    String src = "keyword_kaeun.txt";
    String dest = "r.java";

    E(){
        
        
        try {
            is = new FileInputStream(src);
            os = System.out; //추가할때
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[8]; //계란판
        
        try {
            int count = 0;
            while((count = is.read()) != -1){
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
        
        E e= new E();
        // b.rw();
        e.rw2();
    }
    
}
