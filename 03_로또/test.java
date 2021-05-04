import java.io.*;
import java.util.*;
import java.util.Scanner;

class Test {
    String fileName = "우리반.txt";
    FileReader fr;
    BufferedReader br;
    String list[];
    String name;
    int count;
    int i;

    Scanner s = new Scanner(System.in);
    void input(){
        System.out.println("파일이름을 입력해주세요: ");
        String str = s.next();
        try{
            int k =  Integer.parseInt(str);
            System.out.println("파일이름: "+fileName);
        }catch(NumberFormatException ne){
			System.out.println("파일이 없습니당");
			input();
        }
    }

    Test(){
        try{
            fr = new FileReader(fileName);
			br = new BufferedReader(fr);
            while((name = br.readLine()) !=null){
                    //System.out.println("이름: "+name);
                    count++;
            }
            //System.out.println("총 "+count+"명 검색 완료!!");
        }catch(FileNotFoundException fe){
			System.out.println(fileName+"파일을 찾지 못하였습니다");
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
        System.out.println("이름: "+list[j]); 
    }

    public static void main(String[] args) 
	{
		Test test= new Test();
        test.input();
        test.saveName();
        test.readName();
	}
  
}
