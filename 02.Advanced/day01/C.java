import java.io.*;
//keyboard->file
//write인데 byte 단위가 아니라 byte[] 로 


public class C { 
    InputStream is; //public abstract, System.in의 반환타입
    OutputStream os; //파일
    String fname = "Ctest.txt";

    C(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname); 
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[8]; //계란판
        try {
            int count = 0;
            while((count = is.read(bs)) != -1){
                os.write(bs, 0, count);
            }
            os.flush();
        }catch (IOException e) {
        }finally{
            try{
                is.close();
                os.close();
            }catch(IOException ie){}
        } 
    }


    public static void main(String[] args) {
        
        C c= new C();
        // b.rw();
        c.rw2();
    }
    
}
