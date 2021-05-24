import java.io.*;
import java.util.*;

public class CopyDir {
    
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    BufferedInputStream bis;
    BufferedOutputStream bos;
    FileInputStream fis;
    FileOutputStream fos;
    
    String src; //근본 디렉토리 혹은 파일
    String dname; // 가공된 디렉토리 이름
    String fname; // 가공된 파일 이름
    String path; //대상 디렉토리
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
            //복사할 원본폴더, 붙여넣을 대상폴더를 각각 File 객체 생성하여 매개변수로 사용
            if(check2.equals("1")){
                System.out.println(">>폴더 복사완료");
            }else{
                delDir(src);
                System.out.println(">>폴더 잘라내기 완료");
            }
        } else {
            pasteFile();
            if(check2.equals("1")){
                System.out.println(">>파일 복사완료");
            }else{
                delDir(src);
                System.out.println(">>파일 잘라내기 완료");
            }
        }
    }
  
    //행위 선택
    void select(){
        System.out.println("원하는 항목을 선택해주세요.");
        System.out.print("복사하기[1]     잘라내기[2]: ");
        try {
            check2 = brkey.readLine();
            if (!check2.equals("1") && !check2.equals("2")) {
                System.out.println("");
                System.out.println(":::입력오류::: 1 또는 2만 입력 가능");
                System.out.println("");
                select();
            }
        } catch (IOException ie) {}
    }
    
    //디렉토리 경로를 직접 불러와서 폴더(or파일) 이름 추출
    void getOriginDir(){
        System.out.print("복사할 디렉토리 혹은 파일 입력: ");
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
                System.out.println("정확한 경로를 입력해 주세요!");
                getOriginDir();
            }
        } catch (Exception e) {}
    }

    //복사를 원하는 경로 입력받기
    void getCopyDir(){
        System.out.print("대상 디렉토리 입력: ");
        try {
            path = brkey.readLine();
            path = path.replaceAll("\"", ""); 
            File spath = new File(path);
            if (spath.exists()) {
                if (spath.isFile()) {
                    System.out.println("디렉토리를 입력해주세요");
                    getCopyDir();
                }
            }else{
                System.out.println("디렉토리를 입력해주세요~!");
                getCopyDir();
            }
        } catch (Exception e) {
        }
    }

    //입력받은 경로에 디렉토리 생성하고 파일과 디렉토리를 복사함
    void makeDir(File origin, File copy){
        copy.mkdir(); //Creates the directory named by this abstract pathname.

        File[] fileList = origin.listFiles(); //디렉토리 안의 파일목록을 File 배열로 반환
        for(File file : fileList){
            File temp = new File(copy.getAbsolutePath()+"/"+file.getName()); 
            //getName(): Returns the name of the file or directory denoted by this abstract pathname.
            if(file.isDirectory()){//디렉토리 안에 디렉토리가 있는지 확인
                temp.mkdir(); 
                makeDir(file,temp); //있으면 폴더 생성하고 다시 처음으로 돌아가 실행
            } else{ //디렉토리가 아니라 파일이면 파일복사
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

    // 파일 복사,붙여넣기
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
                File[] dfList = df.listFiles(); //파일리스트 얻어오기
                for(File file: dfList){
                    if(file.isFile()) {
                        file.delete(); //폴더 내에 파일이 존재하면 파일 삭제
                    }
                    else {
                        delDir(file.getPath()); //폴더 내에 폴더가 존재하면 재귀함수 호출
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