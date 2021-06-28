import java.io.*;
//keyboard->file
//반복문을 1바이트마다 돌림

public class B {
    InputStream is; //public abstract, System.in의 반환타입
    OutputStream os;
    String fname = "Btest.txt";

    B(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname,true); //추가할때
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        try {
            int b = 0;
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
            }
        }
    }

    public static void main(String[] args) {
        
        B b= new B();
        b.rw();
    }
    
}
