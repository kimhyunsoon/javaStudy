import java.io.*;
import java.util.*;

class LottoM {
    String fileName;
    FileReader fr; 
    BufferedReader br;

	Scanner s = new Scanner(System.in);

    LottoM(){ 
        
		System.out.println("�����̸��� �Է����ּ���: ");
        String str = s.next();
        fileName = str + ".txt"; //�Է¹��� ��(�츮��)�� fileName�� ����

		
    }
    
	//�����迭�� ����ϱ� ������ �迭 ����� ī��Ʈ�� �ʿ䰡 ������
 
	ArrayList<String> list =  new ArrayList<String>();
    
	void saveName(){ 
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            while((name=br.readLine()) !=null){
                list.add(name); //while �ݺ����� ����Ǵ� ���� list��� �迭 ������ �����Ͱ� �߰���
            } 
        }catch(FileNotFoundException fe){
            System.out.println("�����̸��� ã�� �� �����ϴ�.");
        }
        catch(IOException ie){
        }
   }

   void readName(){
        Random r = new Random();
        int j = r.nextInt(list.size()); //0���� i������ �� �߿� �������� �Ѱ��� ������
        System.out.println("�̸�: "+list.get(j));
    }

    public static void main(String[] args) 
	{
		LottoM lotto= new LottoM();
		lotto.saveName();
		lotto.readName();
        
	}
  
}
