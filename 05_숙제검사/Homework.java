import java.io.*;
import java.util.*;

class Homework {
    String listFile = "우리반.txt";
    String path;
    FileReader fr; 
    BufferedReader br;

    Homework(){
        saveKey();
        findDir();
        confirmDir();
        pln("");
        pln("=========숙제 안낸 사람========");
        pln("");
        showResult();
    }
     
    //1. 우리반.txt를 읽어서 Map에 저장
    Hashtable<String,Boolean> map = new Hashtable<String,Boolean>();
    void saveKey(){
        try{
            fr = new FileReader(listFile);
            br = new BufferedReader(fr);
            String name = "";
            while((name = br.readLine()) !=null){ 
                map.put(name,false);
                //pln(name);
            }
        }catch(FileNotFoundException fe){
        }catch(IOException ie){}
    }
    
    //2.숙제 디렉토리 입력받기

    void findDir(){//숙제 디렉토리 경로 입력받기
        Scanner s = new Scanner(System.in);
        System.out.print("숙제 디렉토리: ");
        path = s.next(); //Finds and returns the next complete token from this scanner.
    }

    void confirmDir(){//디렉토리 존재 여부 확인
        File f = new File(path); //File class
        if(f.exists()){ //디렉토리가 존재하면 true, 존재하지 않으면 flase로 반환
            //pln("존재하는 디렉토리입니다");
            saveDirs(f);
        }else{
            pln("존재하지 않는 디렉토리입니다");
        }
    }

    //3. 읽어온 디렉토리명을 배열에 저장

    void saveDirs(File f){//디렉토리명을 배열에 저장
        File kids[]= f.listFiles(); //listFiles() : 디렉토리의 이름을 kids 배열에 저장
        for(File kid: kids){ 
            if(!kid.isFile()){ //isFile() : 경로에 있는 파일이 디렉토리면 false로 반환
                String dir = kid.getName();
                map.put(dir,true); 
            }
        }
    }

    //4. 결과 보여주기

    void showResult(){
        Set<String> keys = map.keySet();
        int count = 0;

        for(String key: keys){
            boolean flag = map.get(key); //value값을 얻는 함수
            if(!flag){
                pln(key);
                count++;
            }
        }
        pln("");
        pln("오늘은 "+count+"명이 숙제를 안냈어요!");
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new Homework();
    }
}
