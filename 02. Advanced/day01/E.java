import java.io.*;
//file->monitor
//����: FileInputStream & FileOutputStream

public class E {
    InputStream is; //����
    OutputStream os; //�����
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
        byte[] bs = new byte[512]; //�����
        try {
            int count = 0;
            while((count = is.read()) != -1){
                os.write(bs, 0, count);
            }
            System.out.println("���缺��!");
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
