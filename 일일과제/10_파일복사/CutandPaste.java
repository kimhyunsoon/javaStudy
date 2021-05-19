import java.io.*;
import java.util.*;

public class CutandPaste {

    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;
    FileReader fr;

    String src; //�ٺ� �ҽ�
    String fname = ""; //������ ���� �̸�
    String check; //����or�ٿ��ֱ�
    String path; //���丮


    CutandPaste(){
        select();
        inputFile();
        inputDir();
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(path+"\\"+"���纻_"+fname);
        } catch (FileNotFoundException fe) {
        }
        bis = new BufferedInputStream(fis,2048); //filter
        bos = new BufferedOutputStream(fos,2048);
        paste();
        if (check.equals("2")) {
            del();
        } 
    }

    //1. ���� ����
    void select(){
        System.out.println("���ϴ� �׸��� �������ּ���.");
        System.out.print("�����ϱ�[1]     �߶󳻱�[2]: ");
        try {
            check = brkey.readLine();
            if ( !check.equals("1") && !check.equals("2")) {
                System.out.println("");
                System.out.println(":::�Է¿���::: 1 �Ǵ� 2�� �Է� ����");
                System.out.println("");
                select();
            }
        } catch (IOException ie) {

        }
    }

    //2. ������ ���� �ҷ��ͼ� �����̸��� ����
    void inputFile(){
        System.out.print("�ҷ��� ���� �̸� �Է�: ");
        try {
            src = brkey.readLine();
            File sfile = new File(src);
            if (sfile.exists()) {
                if (!sfile.isFile()) {
                    System.out.println("������ �ƴϳ׿�..�ٽ� �Է����ּ���!");
                    inputFile();
                }else{
                    int idx = src.lastIndexOf("\\");
                    fname = src.substring(idx+1);
                }
            } else {
                System.out.println("������ �־��ּ���.");
                inputFile();
            }
        } catch (IOException ie) {
        }
    }

    //3. ��� ���丮 �Է¹ޱ�
    void inputDir(){
        System.out.print("��� ���丮 �Է�: ");
        try {
            path = brkey.readLine();
            File spath = new File(path);
            if (spath.exists()) {
                if (spath.isFile()) {
                    System.out.println("���丮�� �Է����ּ���!");
                    inputDir();
                }
            } else {
                System.out.println("���丮�� �Է����ּ���!");
                inputDir();
            }
        } catch (Exception e) {
        }
    }

    //4. ���� �����ϱ�
    void paste(){
        int count = 0;
        byte bs[] = new byte[256];
        try {
            while ((count= bis.read(bs)) != -1) {
                bos.write(bs, 0, count); // to file
            }
            bos.flush();
            System.out.println("����Ϸ�");
        } catch (IOException ie) {
        }finally{
            try {
                if(bis !=null) bis.close(); 
                if(bos !=null) bos.close();
                if(fos !=null) fos.close();
                if(fis !=null) fis.close();
            } catch (IOException ie) {
            }
        }
    }

    //5. ���� ���� �����
    void del(){
        File f = new File(src);
        f.delete();     
    }
    public static void main(String[] args) {
        new CutandPaste();
    }
}

