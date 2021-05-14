import java.io.*;
import java.util.*;

class Lucky {
    
    String fName = "�츮�ݸ���Ʈ.txt"; //�ҷ��� ���� ����Ʈ��
    String sList; //���� ���� �̸�
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;
    
    
    Lucky(){ 

        findFile();
        cut();
        
    
        

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
            saveList(f);
		}catch(FileNotFoundException fe){
			pln("������ ã�� ���߾�� :(");
			findFile();
		}catch(IOException ie){
		}
	}

    //2. �ҷ��� ������ �о ������ �ִٸ� ������ �����ϰ� ���ٸ� �����迭�� ����
    ArrayList<String> list =  new ArrayList<String>();
    void saveList(File f){ 
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
    String winner; //���۴��
    int rate; //Ȯ��

    void cut(){
        for(String name: list){ //����Ʈ ���� name ��Ҹ� �� ���������� ����
            //System.out.println("name: "+name);
            int idx = name.indexOf(" ");
            if(idx != -1){ //" "�� ���ԵǾ� ���� ������ -1�� ��ȯ, ���ԵǾ� ������ ����
                //System.out.println(idx);
                winner = name.substring(0, idx); 
                pln(winner);
                String wRate = name.substring(idx);
                if(wRate.length() !=0){
                    wRate=wRate.trim();
                }
                rate = Integer.parseInt(wRate);
                System.out.println(rate);
            }

        }
    }

    void readName(){
        Random r = new Random();
        int k = r.nextInt(100); 
        if((k+1)<=rate){
            pln("��÷��: "+winner);
        }else{
            System.out.println("��÷����");
        }

    }


    void pln(String str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new Lucky();
		        
	}
  
}
