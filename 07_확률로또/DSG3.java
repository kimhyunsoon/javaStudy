import java.io.*;
import java.util.*;
 
class DSG3{        // Drawing Straws Game 3
    String fileName = "NameList.txt";
    FileReader fr;
    BufferedReader br;
    Random random = new Random();
    
    String name;
    int rate;
 
    Vector<String> listName = new Vector<String>();            // Ȯ���� ���� ���
    ArrayList<String> listNumber = new ArrayList<String>();    // Ȯ���� �ִ� ���
 
    void readFile(){
        String line = null;
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while((line=br.readLine()) != null){
                line = line.trim();
                if(line.length() != 0){
                    if((line.indexOf(" ")) != -1){
                        name = separate(line);
                        listName.add(name);
                    }else{
                        listName.add(line);
                    }
                }
            }
        }catch(FileNotFoundException fnfe){
            System.out.println(fileName + " : CAN'T FOUND");
        }catch(IOException ioe){}
    }
 
    String separate(String str){
        int idx = str.indexOf(" ");
        name = str.substring(0 , idx);
        //System.out.println("name : " + name);    
        // ���� �ִ� ����� �ε��� �̸� Ȯ�ο�
        String rStr = str.substring(idx);
        rStr = rStr.trim();
        rate = Integer.parseInt(rStr);
        for(int i=0 ; i<rate ; i++){
            listNumber.add(name);
        }
        return name;
    }
 
    void ran100(){
        int ran = random.nextInt(100);
        //System.out.println("Ȯ�� : " + listNumber.size() + "\n��ȣ : " + ran);
        if(ran < listNumber.size()){
            if(listNumber.size() > 100){
                System.out.println("Ȯ���� 100�� ���� �� �����ϴ�." + ran);
                System.out.println("�޸����� Ȯ���� ���� Ȯ�����ּ���.");
                System.exit(0);
            }else{
                System.out.println("��÷�� : " + listNumber.get(ran));    // Ȯ���ִ� ��÷��
            }
        }else{
            listName.remove(name);
            ran = random.nextInt(listName.size());
            System.out.println("��÷�� : " + listName.get(ran));        // Ȯ������ ��÷��
        }
    }
 
    public static void main(String[] args){
        DSG3 dsg3 = new DSG3();
        dsg3.readFile();
        dsg3.ran100();
    }
}


��ó: https://seokho-j0308.tistory.com/51 [���]