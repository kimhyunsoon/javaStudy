import java.io.*;
import java.util.*;

class Test {
    
    String fName = "list.txt"; //�ҷ��� ���� ����Ʈ��
    FileReader fr; 
    BufferedReader br;
    String name;
    boolean defaultFile = true;
    String sList; //���� ���� �̸�
    // BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  
    
    Test(){ 

    }


    //2. �ҷ��� ������ �о ������ �ִٸ� ������ �����ϰ� ���ٸ� �����迭�� ����
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