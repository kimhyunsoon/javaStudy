import java.io.*;
//keyboard->file
//�ݺ����� 1����Ʈ���� ����

public class B {
    InputStream is; //public abstract, System.in�� ��ȯŸ��
    OutputStream os;
    String fname = "Btest.txt";

    B(){
        is = System.in;
        
        try {
            os = new FileOutputStream(fname,true); //�߰��Ҷ�
        } catch (FileNotFoundException fe) {}
    }

    void rw(){
        try {
            int b = 0;
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
            }
        }
    }

    public static void main(String[] args) {
        
        B b= new B();
        b.rw();
    }
    
}
