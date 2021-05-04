import java.io.*;
import java.util.*;
import java.util.Scanner;

class Lotto {
    FileReader fr; 
    BufferedReader br;
    String list[]; 
    String name;
    int count;
    int i;

    Scanner s = new Scanner(System.in);
    String input(){ //������� ���ڿ��� ��ȯ�ϴ� �Լ� input();
        System.out.println("�����̸��� �Է����ּ���: ");
        String str = s.next()+".txt"; //���ϰ�θ� ������
        return str; //input()�� ����� �� ���� �����
        
    }

    Lotto(){
        try{
            fr = new FileReader(fileName); //fileName = "�츮��.txt"�� �д´�
			br = new BufferedReader(fr); //�� �ν�??
            while((name = br.readLine()) !=null){ //�޸����� �������� Ȯ��. ������ ���� ������� ������ ����
                    //System.out.println("�̸�: "+name);
                    count++; //�� ����(�л� ��)��ŭ ������Ŵ
            }
            //System.out.println("�� "+count+"�� �˻� �Ϸ�!!");
        }catch(FileNotFoundException fe){
			System.out.println(fileName+"������ ã�� ���Ͽ����ϴ�");
        }catch(IOException ie){
		}
    }

    void saveName(){ //�迭�� �����ϰ� ������ �̸����� ������
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            list = new String[count]; //���̰� count�� �� �迭 ����
            while((name=br.readLine()) !=null){
                list[i] = name; //list �迭 i��° ��ҿ� ������ i��° ���� ������
                i++; // �� ������ŭ i�� ������Ŵ
            } 
        }catch(FileNotFoundException fe){
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(i); //0���� i������ �� �߿� �������� �Ѱ��� ������
        System.out.println("�̸�: "+list[j]); 
    }

    public static void main(String[] args) 
	{
		Lotto lotto= new Lotto();
        lotto.input();
        lotto.saveName();
        lotto.readName();
	}
  
}
