import java.io.*;
import java.util.*;
import java.util.Scanner;

class Test_soon {
    FileReader fr;
    BufferedReader br;
    String list[];
    String name;
    int count;
    int i;

    Scanner s = new Scanner(System.in);
    String input(){ // ������� ���ڿ��� ��ȯ�ϴ� �Լ� input();
        System.out.println("�����̸��� �Է����ּ���: ");
        String str = "����/"+ s.next() + ".txt"; // ���� ��θ� ������ (����/{�Է��� �̸�}.txt)
        return str; // input() �� ����� �� ���� �����
    }

    void countName(String ad){ // �Ű����� : ������ ���ڿ� ad
        try{
            fr = new FileReader(ad); // ���� ���� �Ű��������� ����
			br = new BufferedReader(fr);
            while((name = br.readLine()) !=null){
                    count++;
            }
        }catch(FileNotFoundException fe){
			System.out.println(ad+"������ ã�� ���Ͽ����ϴ�");
            return; // ������ ������ ����
        }catch(IOException ie){
		}
    }

    void saveName(String ad){ // �Ű����� : ������ ���ڿ� ad
        try{
            fr = new FileReader(ad); // ���� ���� �Ű��������� ����
            br = new BufferedReader(fr);
            list = new String[count];
            while((name=br.readLine()) !=null){
                list[i] = name;
                i++;
            } 
            readName(); // ������ ������ readName ������
        }catch(FileNotFoundException fe){
            return; // ������ ������ ����
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(i);
        System.out.println("�̸�: "+list[j]); 
    }

    public static void main(String[] args) 
	{
		Test_soon test= new Test_soon();
        String adress = test.input(); // input()�� ����� ���ڿ� ���� adress�� ������
        test.countName(adress);
        test.saveName(adress);
        // readName�� saveName���� ������
	}
  
}
