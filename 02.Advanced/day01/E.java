import java.io.*;
//file->monitor
//����: FileInputStream & FileOutputStream

public class E {
    InputStream is; //����
    OutputStream os; //�����
    String src = "keyword_kaeun.txt";
    // String dest = "Etest.java";

    E(){

        try {
            is = new FileInputStream(src);
            // os = new FileOutputStream(dest);
            os = System.out;
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        int count = 0;
        byte[] bs = new byte[512]; //�����
        try {
            while((count = is.read(bs)) != -1){
                os.write(bs, 0, count);
            }
            os.flush();
            System.out.println("���缺��!");
            
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
