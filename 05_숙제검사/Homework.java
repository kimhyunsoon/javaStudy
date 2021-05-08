import java.io.*;
import java.util.*;

class Homework {
    
    String listfile = "�츮��.txt";
    String path;
    FileReader fr; 
    BufferedReader br;
    Hashtable<String,Boolean> map = new Hashtable<String,Boolean>();
  
   
    //1. �츮��.txt �� �о Map�� ����
    
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


    void findDir(){ //���丮 ��� �Է¹���
        Scanner s = new Scanner(System.in);
        System.out.print("�������丮: ");
        path = s.next();
    }
    
    void confirmDir(){ //���丮 ���翩�� Ȯ��
        File f = new File(path); //File class
        if(f.exists()){ //���丮�� �����ϸ� true, �������� ������ false
            saveDirs(f);
            
        }else{
            pln("�������� �ʴ� ���丮");
        }
    }

    void saveDirs(File f){ //�������� kids �迭�� ����
        File kids[] = f.listFiles(); //listFiles() ���丮�� �̸��� �迭�� ��ȯ. kids �迭�� ����
        Set<String> keys = map.keySet();
        for(File kid: kids){//kids�� �ִ� ��Ұ� ������ ������ �ݺ����� ���� kid�� ����
            if(!kid.isFile()){ //isFile() ��ο� �ִ� ������ ���丮�� false�� ��ȯ, 
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








