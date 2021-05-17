import java.io.*;
import java.util.*;

class LottoRate {
    
    String dFile = "list.txt"; //�ҷ��� ���� ����Ʈ��
    FileReader fr; 
    BufferedReader br;
    String name;

    String name2;

    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  
    String winner;
    int rate;
    
    LottoRate(){ 

        saveList();
        cut();
        extract();
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
        }catch(IOException ie){
        }
    }

   //3. �迭���� ���۴�� ã��
   ArrayList<String> wList = new ArrayList<String>();
   void cut(){
       for(String name: list){
            int idx = name.indexOf(" ");
            //System.out.println(idx);
            if(idx != -1) { // " "�� ���ԵǾ����� ������ -1�� ��ȯ��, ���ԵǾ������� ����
                name2 = name;
                winner = name.substring(0, idx); // �̸� ����
                String wRate = name.substring(idx); // " "���� �������� ���ڿ��� ����
                wRate = wRate.trim(); // ������ ���� ���ڿ� ��)"    50"�� �¿���� ����
                rate = Integer.parseInt(wRate); // ������ ���� ���ڿ� ��)"50"�� Integer�� ����ȯ
                for(int i=0 ; i<rate ; i++){
                    wList.add(winner);
                }
            }
        }
    }
   void extract(){
        Random random = new Random();
        int ran = random.nextInt(100); 
        if (ran < wList.size()){
            pln("��÷�� : " + winner);

        } else{
            list.remove(name2);
            ran = random.nextInt(list.size());
            pln("��÷�� : "+list.get(ran));
        }
    }

    void pln(String str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new LottoRate();

	}  
}
