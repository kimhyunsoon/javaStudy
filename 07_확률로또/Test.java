import java.io.*;
import java.util.*;

class Test {
    
    String dFile = "list.txt"; //�ҷ��� ���� ����Ʈ��
    FileReader fr; 
    BufferedReader br;
    String name;
    boolean defaultFile = true;
     //���� ���� �̸�
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  

    Test(){ 

    }
    
    //1. 2���� ������ ��ã���� ����
    void findFile(){
        String sFile = "";
        try{
            System.out.print("�ҷ��� ���� ���� �Է�: ");
            sFile = brkey.readLine();
            fr = new FileReader(sFile);
            br = new BufferedReader(fr);
            String line = "";
            while((line=br.readLine()) !=null){ //���� null�� �ƴϸ� ����
                line = line.trim(); //���� ����
                if(line.length() !=0){
                    list.add(line); 
                    pln(line);
                }
            } 
        }catch(FileNotFoundException fe){
        }catch(IOException ie){
        }
    }

    //2. �ҷ��� ������ �о ������ �ִٸ� ������ �����ϰ� ���ٸ� �����迭�� ����
    ArrayList<String> list =  new ArrayList<String>();
    void saveList(){ 
        try{
            fr = new FileReader(dFile); //���� �б�
            br = new BufferedReader(fr); //���۸� �̿��ؼ� ����
            String line = "";
            while((line=br.readLine()) !=null){ //���� null�� �ƴϸ� ����
                line = line.trim(); //���� ����
                if(line.length() !=0){
                    list.add(line); 
                }
            } 
        }catch(FileNotFoundException fe){
            pln("������ ã�� ���߾�� :(");
            findFile();
        }
        catch(IOException ie){
        }
    }

    //3. �迭���� ���� ��� ã��
    String winner; //���۴��
    int rate; //Ȯ��
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    void cut(){
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            name = iter.next();
            int idx = name.indexOf(" ");
            //System.out.println(idx); (������ ���ԵǾ� ���� ������ -1 ��ȯ Ȯ��)
            if(idx !=-1){ // ���� ���ԵǾ� ���� �� ����
                winner = name.substring(0, idx); 
                //pln(name); //Ȯ�� ���ִ� ��� �̸� Ȯ��
                String wRate = name.substring(idx);
                if(wRate.length() !=0){
                    wRate = wRate.trim();
                    //pln(wRate); //Ȯ�� Ȯ��
                }
                rate = Integer.parseInt(wRate); //int�� ����ȯ
                if(rate == 0){
                    iter.remove(); //rate�� 0�� �ֵ� ����
                }else{
                    map.put(winner,rate); //table�� Ȯ�� ���۵� �ֵ��� Ȯ���� �Բ� ����
                   //pln(winner);

                }
            }
        }
    }

    ArrayList<String> wList =  new ArrayList<String>();
    void setArray(){
        Set<String> keys= map.keySet();
        for(String key : keys){
            for(int i=0; i<map.get(key); i++){
                wList.add(key);
                pln(key);
            }

        }
        
    }

    void ran100(){
        Random random = new Random();
        int ran = random.nextInt(100); //0~100 ������ ������ ��
        int i = 0;
        Set<String> names = map.keySet();
        

        
        

    }



    void pln(String str){
        System.out.println(str);
    }



   public static void main(String[] args) {
       Test test = new Test();
       test.saveList();
       test.cut();
       test.setArray();


       
   }
}