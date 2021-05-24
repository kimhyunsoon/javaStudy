import java.io.*;
import java.util.*;

public class CopyDir {
    
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;
    
    String src; //�ٺ� ���丮 Ȥ�� ����
    String dname; // ������ ���丮 �̸�
    String fname; // ������ ���� �̸�
    String path; //��� ���丮
    String check1; 
    String check2; 

    CopyDir(){
        select();
        getOriginDir();
        getCopyDir();
        if (check1.equals("Directory")) { 
            File srcFile = new File(src);
            File pathFile = new File(path+"/"+dname);
            makeDir(srcFile,pathFile);
            //������ ��������, �ٿ����� ��������� ���� File ��ü �����Ͽ� �Ű������� ���
            if(check2.equals("1")){
                System.out.println(">>���� ����Ϸ�");
            }else{
                delDir(src);
                System.out.println(">>���� �߶󳻱� �Ϸ�");
            }
        } else {
            pasteFile();
            if(check2.equals("1")){
                System.out.println(">>���� ����Ϸ�");
            }else{
                delDir(src);
                System.out.println(">>���� �߶󳻱� �Ϸ�");
            }
        }
    }
  
    //���� ����
    void select(){
        System.out.println("���ϴ� �׸��� �������ּ���.");
        System.out.print("�����ϱ�[1]     �߶󳻱�[2]: ");
        try {
            check2 = brkey.readLine();
            if (!check2.equals("1") && !check2.equals("2")) {
                System.out.println("");
                System.out.println(":::�Է¿���::: 1 �Ǵ� 2�� �Է� ����");
                System.out.println("");
                select();
            }
        } catch (IOException ie) {}
    }
    
    //���丮 ��θ� ���� �ҷ��ͼ� ����(or����) �̸� ����
    void getOriginDir(){
        System.out.print("������ ���丮 Ȥ�� ���� �Է�: ");
        try {
            src = brkey.readLine(); 
            src = src.replaceAll("\"", ""); 
            File temp = new File(src);
            if(temp.exists()){
                if(!temp.isFile()){
                    int idx = src.lastIndexOf("\\");
                    dname = src.substring(idx+1);
                    check1 = "Directory";
                }else{
                    int idx = src.lastIndexOf("\\");
                    fname = src.substring(idx+1);
                    check1 = "File";
                }
            }else{
                System.out.println("��Ȯ�� ��θ� �Է��� �ּ���!");
                getOriginDir();
            }
        } catch (Exception e) {}
    }

    //���縦 ���ϴ� ��� �Է¹ޱ�
    void getCopyDir(){
        System.out.print("��� ���丮 �Է�: ");
        try {
            path = brkey.readLine();
            path = path.replaceAll("\"", ""); 
            File spath = new File(path);
            if (spath.exists()) {
                if (spath.isFile()) {
                    System.out.println("���丮�� �Է����ּ���");
                    getCopyDir();
                }
            }else{
                System.out.println("���丮�� �Է����ּ���~!");
                getCopyDir();
            }
        } catch (Exception e) {
        }
    }

    //�Է¹��� ��ο� ���丮 �����ϰ� ���ϰ� ���丮�� ������
    void makeDir(File origin, File copy){
        copy.mkdir(); //Creates the directory named by this abstract pathname.

        File[] fileList = origin.listFiles(); //���丮 ���� ���ϸ���� File �迭�� ��ȯ
        for(File file : fileList){
            File temp = new File(copy.getAbsolutePath()+"/"+file.getName()); 
            //getName(): Returns the name of the file or directory denoted by this abstract pathname.
            if(file.isDirectory()){//���丮 �ȿ� ���丮�� �ִ��� Ȯ��
                temp.mkdir(); 
                makeDir(file,temp); //������ ���� �����ϰ� �ٽ� ó������ ���ư� ����
            } else{ //���丮�� �ƴ϶� �����̸� ���Ϻ���
                try{
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(temp);

                    int count = 0;
                    byte fs[] = new byte[256];
                    while((count = fis.read(fs)) != -1){
                        fos.write(fs, 0, count);
                    }
                    fos.flush();
 
                }catch(IOException ie){
                }finally{
                    try {
                        if(fos != null) fos.close();
                        if(fis != null) fis.close();

                    } catch (Exception e) {}
                }
            }
        }
    }

    // ���� ����,�ٿ��ֱ�
    void pasteFile(){
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(path+"\\"+fname);
        } catch (FileNotFoundException fe) {
        }
        bis = new BufferedInputStream(fis, 2048); //filter
        bos = new BufferedOutputStream(fos, 2048);

        int count = 0;
        byte bs[] = new byte[256];
        try {
            while((count = bis.read(bs)) != -1){
                bos.write(bs, 0, count);
            }
            bos.flush();
        } catch (IOException ie) {
        } finally{
            try {
                if(bos !=null) bis.close();
                if(bis !=null) bis.close();
                if(fos !=null) bis.close();
                if(fis !=null) bis.close();
            } catch (Exception e) {
            }
        }
        if(check2.equals("2")) delFile();
    }

    void delDir(String path2){
        File df = new File(path2);
        try{
            if(df.exists()){
                File[] dfList = df.listFiles(); //���ϸ���Ʈ ������
                for(File file: dfList){
                    if(file.isFile()) {
                        file.delete(); //���� ���� ������ �����ϸ� ���� ����
                    }
                    else {
                        delDir(file.getPath()); //���� ���� ������ �����ϸ� ����Լ� ȣ��
                    }
                    //file.delete();
                }
                df.delete();
            }
        }catch (Exception e){}
    }

    void delFile(){
        File f = new File(src);
        f.delete();
    }

    public static void main(String [] args) {
        new CopyDir();
    }
}