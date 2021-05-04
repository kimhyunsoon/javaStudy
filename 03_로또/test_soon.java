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
    String input(){ // 결과값을 문자열로 반환하는 함수 input();
        System.out.println("파일이름을 입력해주세요: ");
        String str = "설정/"+ s.next() + ".txt"; // 파일 경로를 저장함 (설정/{입력한 이름}.txt)
        return str; // input() 의 결과는 위 파일 경로임
    }

    void countName(String ad){ // 매개변수 : 임의의 문자열 ad
        try{
            fr = new FileReader(ad); // 파일 명을 매개변수에서 받음
			br = new BufferedReader(fr);
            while((name = br.readLine()) !=null){
                    count++;
            }
        }catch(FileNotFoundException fe){
			System.out.println(ad+"파일을 찾지 못하였습니다");
            return; // 파일이 없으면 끝냄
        }catch(IOException ie){
		}
    }

    void saveName(String ad){ // 매개변수 : 임의의 문자열 ad
        try{
            fr = new FileReader(ad); // 파일 명을 매개변수에서 받음
            br = new BufferedReader(fr);
            list = new String[count];
            while((name=br.readLine()) !=null){
                list[i] = name;
                i++;
            } 
            readName(); // 파일이 있으면 readName 실행함
        }catch(FileNotFoundException fe){
            return; // 파일이 없으면 끝냄
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
		Test_soon test= new Test_soon();
        String adress = test.input(); // input()의 결과를 문자열 변수 adress에 저장함
        test.countName(adress);
        test.saveName(adress);
        // readName은 saveName에서 실행함
	}
  
}
