import java.io.*;

public class BB {
    InputStream is;
    OutputStream os;
    String fname = "abc.txt";

    BB(){
        is = System.in; //InputStream�� ��ȯŸ������ ������ System.in �̿�
        try {
            os = new FileOutputStream(fname); //OutputStream�� subclass
        } catch (FileNotFoundException fe) {

        }
    }

    void rw(){
        int b = 0;
        try {
            os.write(b);
            os.flush(); //����ش�
        } catch (IOException e) {

        }
        
    }


    public static void main(String[] args) {
        BB bb=  new BB();

        
    }
    
}
