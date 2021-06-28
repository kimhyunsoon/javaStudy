import java.io.*;

public class FF {

    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;


    
    String src = "C:\\KAEUN\\JAVA\\keyword_kaeun.txt"; //������ ���� ��쿡 NullPointerException �߻�
    String dest = "F_copy.txt";

    FF(){
        try {
            fis = new FileInputStream(src); //node
            fos = new FileOutputStream(dest);
        } catch (FileNotFoundException fe) {
        } 

        bis = new BufferedInputStream(fis, 2048); //filter
        bos = new BufferedOutputStream(fos, 2048);
        //buffer size(����īƮ) : 2048
    }

    void rw(){
        int count = 0;
        byte bs[] = new byte[256]; //�����
        try {
            while ((count = bis.read(bs)) != -1) {
                bos.write(bs, 0, count); //to file
            }
            bos.flush();
            System.out.println("����Ϸ�("+dest+")");
        } catch (IOException ie) {
        } finally{
            try {
                if(bis !=null) bis.close(); //NullPointerException �߻��ϱ� ������ ������ġ
                if(bos !=null) bos.close();
                if(fos !=null) fos.close();
                if(fis !=null) fis.close();
            } catch (IOException ie) {
            }
        }
    }
    public static void main(String[] args) {
        FF ff = new FF();
        ff.rw();
        
    }
}
