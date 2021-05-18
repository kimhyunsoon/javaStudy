import java.io.*;
import java.util.*;

public class CutPaste{
    BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));

    void inputFile(){
        String fileName = "";
        FileReader fr = null;
        try{
			System.out.print("읽을 파일 이름 : "); 
	        fileName = brKey.readLine();
            fileName = fileName.trim();
            fileName = fileName.replaceAll("\"", "");
            fr = new FileReader(fileName);
            fr.close();
		}catch(FileNotFoundException e){
			System.out.println(fileName+" 없음..");
		}catch(IOException ie){
		}
        File originFile = new File(fileName);
        inputDirectory(originFile);
    }

    void inputDirectory(File a){
        String fileName2 = "";
        String fileName3 = "";
        try{
			System.out.print("복사할 경로 : "); 
	        fileName2 = brKey.readLine();
            fileName2 = fileName2.trim();
            fileName3 = fileName2.replaceAll("\"", "");
            fileName2 = fileName3+"/복사본_"+a.getName();
            FileInputStream inFile = new FileInputStream(a);
            FileOutputStream outFile = new FileOutputStream(fileName2);
            int fileByte = 0; 
            while((fileByte = inFile.read()) != -1) {
                outFile.write(fileByte);
            }
            inFile.close();
            outFile.close();
            delFile(a);
            
		}catch(FileNotFoundException e){
			System.out.println(fileName3+" 디렉토리가 없습니다...");
		}catch(IOException ie){
		}
    }
    void delFile(File a){
        System.out.println(a.getAbsolutePath());
        if (a.exists()){
            if (a.delete()){
                System.out.println("파일을 삭제 성공");
            }else{
                System.out.println("파일 삭제 실패");
            }
        }else{
            System.out.println("파일이 없습니다.");
        }
    }

    public static void main(String[] args){
        CutPaste cutPate = new CutPaste();
        cutPate.inputFile();
    }
}