import java.io.*;
import java.util.*;

class Homework {
    
    String listfile = "우리반.txt";
    String path;
    FileReader fr; 
    BufferedReader br;
    Hashtable<String,Boolean> map = new Hashtable<String,Boolean>();
  
   
    //1. 우리반.txt 을 읽어서 Map에 저장
    
    void saveKey(){
        try{
            fr = new FileReader(listfile); 
            br = new BufferedReader(fr);
            String name = "";
            while((name = br.readLine()) !=null){
                map.put(name,false);
                //pln(name);
            }
        }catch(FileNotFoundException fe){
        }catch(IOException ie){}
    }


    void findDir(){ //디렉토리 경로 입력받음
        Scanner s = new Scanner(System.in);
        System.out.print("숙제디렉토리: ");
        path = s.next();
    }
    
    void confirmDir(){ //디렉토리 존재여부 확인
        File f = new File(path); //File class
        if(f.exists()){ //디렉토리가 존재하면 true, 존재하지 않으면 false
            saveDirs(f);
            
        }else{
            pln("존재하지 않는 디렉토리");
        }
    }

    void saveDirs(File f){ //폴더명을 kids 배열에 저장
        File kids[] = f.listFiles(); //listFiles() 디렉토리의 이름을 배열로 반환. kids 배열에 저장
        Set<String> keys = map.keySet();
        for(File kid: kids){//kids에 있는 요소가 소진될 때까지 반복문을 돌려 kid에 저장
            if(!kid.isFile()){ //isFile() 경로에 있는 파일이 디렉토리면 false로 반환, 
                String dir = kid.getName();
                for(String key: keys){
                    map.put(dir, true);
                }
            }
        }
    }
    void result(){
        Set<String> keys = map.keySet();
        int count = 0;
        for(String key: keys){
            if(!map.get(key)){
                count++;
                pln(key);
                plnt(count);
            }
        }
    }



    void pln(String str){
        System.out.println(str);
    }
    void plnt(int str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Homework test = new Homework();
        

        test.saveKey();
        test.findDir();
        test.confirmDir();
        test.result();
        
       
        
    }

}








