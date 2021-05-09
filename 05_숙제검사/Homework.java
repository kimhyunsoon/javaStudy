import java.io.*;
import java.util.*;

class Homework {
    String listFile = "�츮��.txt";
    String path;
    FileReader fr; 
    BufferedReader br;

    Homework(){
        saveKey();
        findDir();
        confirmDir();
        pln("");
        pln("=========���� �ȳ� ���========");
        pln("");
        showResult();
    }
     
    //1. �츮��.txt�� �о Map�� ����
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
    
    //2.���� ���丮 �Է¹ޱ�

    void findDir(){//���� ���丮 ��� �Է¹ޱ�
        Scanner s = new Scanner(System.in);
        System.out.print("���� ���丮: ");
        path = s.next(); //Finds and returns the next complete token from this scanner.
    }

    void confirmDir(){//���丮 ���� ���� Ȯ��
        File f = new File(path); //File class
        if(f.exists()){ //���丮�� �����ϸ� true, �������� ������ flase�� ��ȯ
            //pln("�����ϴ� ���丮�Դϴ�");
            saveDirs(f);
        }else{
            pln("�������� �ʴ� ���丮�Դϴ�");
        }
    }

    //3. �о�� ���丮���� �迭�� ����

    void saveDirs(File f){//���丮���� �迭�� ����
        File kids[]= f.listFiles(); //listFiles() : ���丮�� �̸��� kids �迭�� ����
        for(File kid: kids){ 
            if(!kid.isFile()){ //isFile() : ��ο� �ִ� ������ ���丮�� false�� ��ȯ
                String dir = kid.getName();
                map.put(dir,true); 
            }
        }
    }

    //4. ��� �����ֱ�

    void showResult(){
        Set<String> keys = map.keySet();
        int count = 0;

        for(String key: keys){
            boolean flag = map.get(key); //value���� ��� �Լ�
            if(!flag){
                pln(key);
                count++;
            }
        }
        pln("");
        pln("������ "+count+"���� ������ �ȳ¾��!");
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        new Homework();
    }
}
