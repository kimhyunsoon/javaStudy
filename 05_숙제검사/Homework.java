import java.io.*;
import java.util.*;

class Homework {
    
    String path = "C:/KAEUN/JAVA/05_숙제검사_soon/숙제/1일";

    void confirmDir(){
        File f = new File(path); //File class
        if(f.exists()){ //디렉토리가 존재하면 true, 존재하지 않으면 false
            pln("존재하는 디렉토리");
            
        }else{
            pln("존재하지 않는 디렉토리");
        }

    }

    void showDirs(File f){
        File kids[] = f.listFiles(); //listFiles() 디렉토리의 이름을 배열로 반환. kids 배열에 저장
        for(File kid: kids){//kids에 있는 요소가 소진될 때까지 반복문을 돌려 kid에 저장
            if(!kid.isFile){ //isFile() 경로에 있는 파일이 디렉토리면 false로 반환, 
                String name = kid.getName();
            }

        }




    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Homework test = new Homework();
        test.confirmDir();}

}









// 파일 변수 (디렉토리경로)
// -> File 파일변수  = new File(디렉토리 경로);

// 파일변수의 하위 디렉토리를 배열에 담는 함수
// -> FIle 디렉토리배열[] = 파일변수.listFile();
