import java.io.*;
//keyboard->file
//write�ε� byte ������ �ƴ϶� byte[] �� 


public class C { 
    InputStream is; //public abstract, System.in�� ��ȯŸ��
    OutputStream os; //����
    String fname = "Ctest.txt";

    C(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname); 
        } catch (FileNotFoundException fe) {}
    }

    void rw2(){
        byte[] bs = new byte[8]; //�����
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
