import java.io.*;
//keyboard->file

public class C {
    InputStream is; //public abstract, System.in�� ��ȯŸ��
    OutputStream os;
    String fname = "r.txt";

    C(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname,true); //�߰��Ҷ�
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        try {
            int b = 0; //byte�� �ڵ尪
            while ((b=is.read()) != -1) {
                os.write(b);
                if (b==13) { //�ѹ��� ���� ���� ��. ������ ���� 13�̶��?
                    break;
                }
            }
            os.flush(); //����ش�
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
        byte[] bs = new byte[8]; //�����

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
