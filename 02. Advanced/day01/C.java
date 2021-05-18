import java.io.*;
//keyboard->file

public class C {
    InputStream is; //public abstract, System.in의 반환타입
    OutputStream os;
    String fname = "r.txt";

    C(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname,true); //추가할때
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        try {
            int b = 0; //byte의 코드값
            while ((b=is.read()) != -1) {
                os.write(b);
                if (b==13) { //한번만 쓰고 싶을 때. 엔터의 값이 13이라고?
                    break;
                }
            }
            os.flush(); //비워준다
        } catch (IOException ie) {

        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException ie) {
                //TODO: handle exception
            }
        }


    }


    void rw2(){
        byte[] bs = new byte[8]; //계란판

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
        } 

    }

    public static void main(String[] args) {
        
        C c= new C();
        // b.rw();
        c.rw2();
    }
    
}
