import java.io.*;
import java.util.*;

class Test {
    
    String fName = "list.txt"; //불러올 파일 디폴트값
    FileReader fr; 
    BufferedReader br;
    String name;
    boolean defaultFile = true;
    String sList; //읽은 파일 이름
    // BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  
    
    Test(){ 

    }


    //2. 불러온 파일을 읽어서 공백이 있다면 공백을 제거하고 없다면 가변배열에 저장
    ArrayList<String> list =  new ArrayList<String>();
    void saveList(){ 
        try{
            fr = new FileReader(fName); 
            br = new BufferedReader(fr);
            String name = "";
            while((name=br.readLine()) !=null){
                name = name.trim();
                if(name.length() !=0){
                    list.add(name); 
                    pln(name);
                }
            } 
        }catch(FileNotFoundException fe){
        }
        catch(IOException ie){
        }
   }
    void pln(String str){
        System.out.println(str);
    }



   public static void main(String[] args) {
       Test test = new Test();
       test.saveList();
       
   }
}