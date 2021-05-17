package soon.lucky;
import java.io.*;
import java.util.*;

class Lucky {
    
    String fName = "list.txt"; //�ҷ��� ���� ����Ʈ��
    String sList; //���� ���� �̸�
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;

    boolean defaultFile = true;
    
    
    Lucky(){ 
        findFile();
        cut();
        totalRate();
    }

 
	//1. ���� �ҷ�����, �ƹ��͵� �Է����� ������ ����Ʈ�� �ҷ���
    
	void findFile(){  //1. ����Ʈ���� �ҷ�����
		try{
            if(defaultFile == false){
                pln("�⺻ ������ ã�� ���߾�� :(");
                System.out.print("����Ʈ ����(�⺻ : �츮�ݸ���Ʈ.txt): ");
                sList = brkey.readLine();
                if(sList !=null){// ���� ����
                    sList = sList.trim();
                };
                fr = new FileReader(sList);
                File f = new File(sList);
                saveList(f);
            }else {
                fr = new FileReader(fName);
                File f = new File(fName);
                saveList(f);
            }
		}catch(FileNotFoundException fe){
            defaultFile = false;
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
    HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

    void cut(){
        Iterator<String> iter = list.iterator();
		while(iter.hasNext()){ //������ �ִ�? ������ true�� ��ȯ, ������ false
            name = iter.next();
            int idx = name.indexOf(" ");
            if(idx != -1){ //" "�� ���ԵǾ� ���� ������ -1�� ��ȯ, ���ԵǾ� ������ ����
                winner = name.substring(0, idx); 
                String wRate = name.substring(idx);
                if (wRate.length() != 0){
                    wRate=wRate.trim();
                }
                rate = Integer.parseInt(wRate);
                if(rate == 0){
                    iter.remove();
                } else {
                    hashMap.put(winner,rate);
                }
            }
		}

    }
    void test(){
        for(String name: list){
            pln(name);
        }
    }

    void totalRate(){
        int rateNum = 0;
        
        Set<String> names = hashMap.keySet();
        

        for(String name: names){
            Integer rate = hashMap.get(name); //value���� ��� �Լ�
            rateNum += rate;
        }
        
        
        readName1(rateNum);

    }
    void readName1(int rateNum){

        String[] rateArr = new String[rateNum];
        

        Random r = new Random();
        int k = r.nextInt(101); // 0~100 ���̿��� ������ ��
        int i = 0;
        Set<String> names = hashMap.keySet();
        for(String name: names){
            for(int j=i; j<rateNum; j++){
                rateArr[j] = name;
            }
            i += hashMap.get(name);
        }
        
        if(k<=rateArr.length){
            pln("��÷�� : " + rateArr[k]);
        } else {
            pln(rateArr.length + "�� Ȯ���� �հ� �ȳ���.. ");
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
