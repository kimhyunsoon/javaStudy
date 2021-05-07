import java.io.*;
import java.util.*;

class Lotto_noReturn {
    String fileName;
    FileReader fr; 
    BufferedReader br;
    // int count; �����
    ArrayList<String> list = new ArrayList<String>(); // ����� (�����迭 ���� �� ����)
    Scanner s = new Scanner(System.in);

    Lotto_noReturn(){ 
        System.out.print("�����̸��� �Է����ּ���: "); // �����_println -> print (�ٹٲ� ����)
        String str = s.next();
        fileName = str + ".txt";
    }
    
    // �����_countName(); (�� ������ ī��Ʈ�� �ʿ䰡 ������)
    // void countName(){
    //     try{
    //         fr = new FileReader(fileName); 
	// 		br = new BufferedReader(fr);
    //         while(br.readLine() !=null){ 
    //             count++;
    //         }
    //     }catch(FileNotFoundException fe){
	// 		System.out.println(fileName+"������ ã�� ���Ͽ����ϴ�");
    //         return;
    //     }catch(IOException ie){
	// 	}
    // }
    
    void saveName(){
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            // list = new String[count]; ����� (ī��Ʈ ������ ���ݰ� �ʿ䰡 ����)
            while((name=br.readLine()) !=null){
                list.add(name); // ����� (����Ʈ��� �迭������ add��� �Լ��� �̿��ؼ� �����͸� ����ִ°���. �ݺ��� ������ ������ �Ѱ���)
            } 
        }catch(FileNotFoundException fe){
            System.out.println("�����̸��� ã�� �� �����ϴ�.");
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(list.size()); // ����� (������ �ٸ��� �� �־���)
        System.out.println("�̸�: "+list.get(j)); // ����� //get �Լ� �̿�
    }

    public static void main(String[] args) 
	{
		Lotto_noReturn lotto= new Lotto_noReturn();
        // lotto.countName(); ����� //�޼ҵ尡 ��������
        lotto.saveName();
        lotto.readName();
	}
  
}
