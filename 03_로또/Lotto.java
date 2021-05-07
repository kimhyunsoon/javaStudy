import java.io.*;
import java.util.*;

class Lotto {
    String fileName;
    FileReader fr; 
    BufferedReader br;
    String list[]; 
    int count;


    Scanner s = new Scanner(System.in);

    Lotto(){ 
        System.out.println("�����̸��� �Է����ּ���: ");
        String str = s.next();
        fileName = str + ".txt"; //�Է¹��� ���� fileName�� ����
    }
    

    void countName(){ 
        try{
            fr = new FileReader(fileName); //fileName = "�츮��.txt"�� �д´�
			br = new BufferedReader(fr); //�� �ν�??
            while(br.readLine() !=null){ //�޸����� �������� Ȯ��. ������ ���� ������� ������ ����
                count++; //�� ����(�л� ��)��ŭ ������Ŵ
            }
            //System.out.println("�� "+count+"�� �˻� �Ϸ�!!");
        }catch(FileNotFoundException fe){
			System.out.println(fileName+"������ ã�� ���Ͽ����ϴ�");
            return;
        }catch(IOException ie){
		}
    }


    void saveName(){ //�迭�� �����ϰ� ������ �̸����� ������
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            int i = 0;
            list = new String[count]; //���̰� count�� �� �迭 ����
            while((name=br.readLine()) !=null){
                list[i] = name; //list �迭 i��° ��ҿ� ������ i��° ���� ������
                i++; // �� ������ŭ i�� ������Ŵ
            } 
        }catch(FileNotFoundException fe){
            return;
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(count); //0���� i������ �� �߿� �������� �Ѱ��� ������
        System.out.println("�̸�: "+list[j]);
    }

    public static void main(String[] args) 
	{
		Lotto lotto= new Lotto();
        lotto.countName();
        lotto.saveName();
        lotto.readName();
	}
  
}
