import java.io.*;
import java.util.*;
import java.util.Scanner;

class Test {
    String fileName = "�츮��.txt";
    FileReader fr;
    BufferedReader br;
    String list[];
    String name;
    int count;
    int i;

    Scanner s = new Scanner(System.in);
    void input(){
        System.out.println("�����̸��� �Է����ּ���: ");
        String str = s.next();
        try{
            int k =  Integer.parseInt(str);
            System.out.println("�����̸�: "+fileName);
        }catch(NumberFormatException ne){
			System.out.println("������ �����ϴ�");
			input();
        }
    }

    Test(){
        try{
            fr = new FileReader(fileName);
			br = new BufferedReader(fr);
            while((name = br.readLine()) !=null){
                    //System.out.println("�̸�: "+name);
                    count++;
            }
            //System.out.println("�� "+count+"�� �˻� �Ϸ�!!");
        }catch(FileNotFoundException fe){
			System.out.println(fileName+"������ ã�� ���Ͽ����ϴ�");
        }catch(IOException ie){
		}
    }

    void saveName(){
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            list = new String[count];
            while((name=br.readLine()) !=null){
                list[i] = name;
                i++;
            } 
        }catch(FileNotFoundException fe){
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
		Test test= new Test();
        test.input();
        test.saveName();
        test.readName();
	}
  
}
