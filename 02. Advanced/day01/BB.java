import java.io.*;
//Ű���� �Է¹����� ���Ϸ� �ƿ�ǲ


public class BB {
    InputStream is;
    OutputStream os;
    String fname = "BBtest.txt";

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
            while ((b=is.read()) != -1) { // ��Ʈ�� ���� �����Ͽ� ����Ʈ�� ����� �� ���� ��� -1 ���� ��ȯ
                os.write(b);

            }
            os.flush(); //����ش�
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
        BB bb=  new BB();
        bb.rw();

    }
    
}
