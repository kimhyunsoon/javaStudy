import java.io.*;
import java.util.*;

class LottoRate {
    
    String fName = "teacher/list.txt"; //�ҷ��� ���� ����Ʈ��
    String sList; //���� ���� �̸�
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;
    String winner;
    int rate;
    
    
    LottoRate(){ 

        findFile();
        cut();
        winnerLotto();
    
        

    }

 
	//1. ���� �ҷ�����, �ƹ��͵� �Է����� ������ ����Ʈ�� �ҷ���
    
	void findFile(){  //1. ����Ʈ���� �ҷ�����
		try{
			System.out.print("����Ʈ ����(�⺻ : �츮�ݸ���Ʈ.txt): ");
			sList = brkey.readLine();
			if(sList !=null){// ���� ����
				sList = sList.trim();
			};   
			if(sList.length()==0){ //�Է¹��� ������ ����Ʈ���� list�� ����
				sList = fName;
			};
			fr = new FileReader(sList);
			File f = new File(sList);
            saveName(f);
		}catch(FileNotFoundException fe){
			pln("������ ã�� ���߾�� :(");
			findFile();
		}catch(IOException ie){
		}
	}

    //2. �ҷ��� ������ �о ������ �ִٸ� ������ �����ϰ� ���ٸ� �����迭�� ����
    ArrayList<String> list =  new ArrayList<String>();
    void saveName(File f){ 
        try{
            fr = new FileReader(f); 
            br = new BufferedReader(fr);
            String name = "";
            while((name=br.readLine()) !=null){
                name = name.trim();
                if(name.length() !=0){
                    list.add(name); 
                }
            } 
        }catch(FileNotFoundException fe){
        }
        catch(IOException ie){
        }
   }

   //3. �迭���� ���۴�� ã��
   
   void cut(){
       for(String name: list){
           
           System.out.println(idx);
           if(idx != -1) { // " "�� ���ԵǾ����� ������ -1�� ��ȯ��, ���ԵǾ������� ����
               winner = name.substring(0, idx); // �̸� ����
               String rateStr = name.substring(idx); // " "���� �������� ���ڿ��� ����
               rateStr = rateStr.trim(); // ������ ���� ���ڿ� ��)"    50"�� �¿���� ����
               rate = Integer.parseInt(rateStr); // ������ ���� ���ڿ� ��)"50"�� Integer�� ����ȯ
           }
       }
   }
   void winnerLotto(){
        Random r = new Random();
        int k = r.nextInt(100); // 0~99�� 1���� ���ڸ� �������� k�� ����
        if ((k+1) <= rate){ // ��) k�� 30������ Ȯ���� 30% 
            pln("��÷�� : " + winner); // Ȯ���ȿ� ���Դٸ� ���
        }else {
            System.out.println((100 - rate)+"% �� Ȯ���� �հ� ���ФФ�"); //�ƴ϶�� �ٸ� ���� (winner�� �迭���� ���� ��÷�ϸ�ɵ�)
        }

   }


    void pln(String str){
		System.out.println(str);
	}
    void plnt(int str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new LottoRate();
		        
	}
  
}
