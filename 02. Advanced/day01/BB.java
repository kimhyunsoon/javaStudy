import java.io.*;

public class BB {
    InputStream is;
    OutputStream os;
    String fname = "abc.txt";

    BB(){
        is = System.in; //InputStream을 반환타입으로 가지는 System.in 이용
        try {
            os = new FileOutputStream(fname); //OutputStream의 subclass
        } catch (FileNotFoundException fe) {

        }
    }

    void rw(){
        int b = 0;
        try {
            os.write(b);
            os.flush(); //비워준다
        } catch (IOException e) {

        }
        
    }


    public static void main(String[] args) {
        BB bb=  new BB();

        
    }
    
}
