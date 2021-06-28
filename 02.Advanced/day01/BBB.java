import java.io.*;
public class BBB {
    InputStream is; //abstract, System in 의 반환타입
    OutputStream os; //abstract

    String fname = "BBBtest.text";
    BBB(){
        is = System.in;
        try {
            os = new FileOutputStream(fname);
        } catch (FileNotFoundException e) {
        }
    }

    void rwFail(){
        
        try {
            int b = is.read();
            os.write(b);
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

    void rwSuceess(){
        
        try {
            int b = 0;
            while ((b = is.read()) != -1) {
                
                os.write(b);
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
        BBB bbb = new BBB();
        // bbb.rwFail();
        bbb.rwSuceess();
        
    }
    
}
