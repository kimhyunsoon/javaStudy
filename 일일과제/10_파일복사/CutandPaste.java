import java.io.*;
import java.util.*;

public class CutandPaste {

    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;
    FileReader fr;

    String src; //근본 소스
    String fname = ""; //가공된 파일 이름
    String check; //복사or붙여넣기
    String path; //디렉토리


    CutandPaste(){
        select();
        inputFile();
        inputDir();
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(path+"\\"+"복사본_"+fname);
        } catch (FileNotFoundException fe) {
        }
        bis = new BufferedInputStream(fis,2048); //filter
        bos = new BufferedOutputStream(fos,2048);
        paste();
        if (check.equals("2")) {
            del();
        } 
    }

    //1. 행위 선택
    void select(){
        System.out.println("원하는 항목을 선택해주세요.");
        System.out.print("복사하기[1]     잘라내기[2]: ");
        try {
            check = brkey.readLine();
            if ( !check.equals("1") && !check.equals("2")) {
                System.out.println("");
                System.out.println(":::입력오류::: 1 또는 2만 입력 가능");
                System.out.println("");
                select();
            }
        } catch (IOException ie) {

        }
    }

    //2. 파일을 직접 불러와서 파일이름만 추출
    void inputFile(){
        System.out.print("불러올 파일 이름 입력: ");
        try {
            src = brkey.readLine();
            File sfile = new File(src);
            if (sfile.exists()) {
                if (!sfile.isFile()) {
                    System.out.println("파일이 아니네요..다시 입력해주세요!");
                    inputFile();
                }else{
                    int idx = src.lastIndexOf("\\");
                    fname = src.substring(idx+1);
                }
            } else {
                System.out.println("파일을 넣어주세요.");
                inputFile();
            }
        } catch (IOException ie) {
        }
    }

    //3. 대상 디렉토리 입력받기
    void inputDir(){
        System.out.print("대상 디렉토리 입력: ");
        try {
            path = brkey.readLine();
            File spath = new File(path);
            if (spath.exists()) {
                if (spath.isFile()) {
                    System.out.println("디렉토리를 입력해주세요!");
                    inputDir();
                }
            } else {
                System.out.println("디렉토리를 입력해주세요!");
                inputDir();
            }
        } catch (Exception e) {
        }
    }

    //4. 파일 복사하기
    void paste(){
        int count = 0;
        byte bs[] = new byte[256];
        try {
            while ((count= bis.read(bs)) != -1) {
                bos.write(bs, 0, count); // to file
            }
            bos.flush();
            System.out.println("복사완료");
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

    //5. 원래 파일 지우기
    void del(){
        File f = new File(src);
        f.delete();     
    }
    public static void main(String[] args) {
        new CutandPaste();
    }
}

