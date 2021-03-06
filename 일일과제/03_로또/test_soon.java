import java.io.*;
import java.util.*;
import java.util.Scanner;

class test_soon {
    String fileName; //파일 경로 - 빈 문자열로 선언해둠
    FileReader fr; 
    BufferedReader br;
    String list[]; 
    String name;
    int count;
    int i;

    Scanner s = new Scanner(System.in);
    test_soon(){
        System.out.println("파일이름을 입력해주세요: ");
        String str = s.next();
        fileName = str; // 입력받은 값을 fileName에 저장함
    }

    void countName(){
        try{
            fr = new FileReader(fileName); //fileName = "우리반.txt"를 읽는다
         br = new BufferedReader(fr); //줄 인식??
            while((name = br.readLine()) !=null){ //메모장이 몇줄인지 확인. 파일의 줄이 비어있지 않으면 실행
                    //System.out.println("이름: "+name);
                    count++; //줄 갯수(학생 수)만큼 증가시킴
            }
            //System.out.println("총 "+count+"명 검색 완료!!");
        }catch(FileNotFoundException fe){
         System.out.println(fileName+"파일을 찾지 못하였습니다");
        }catch(IOException ie){
      }
    }

    void saveName(){ //배열을 생성하고 파일의 이름들을 대입함
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            list = new String[count]; //길이가 count인 빈 배열 선언
            while((name=br.readLine()) !=null){
                list[i] = name; //list 배열 i번째 요소에 파일의 i번째 줄을 대입함
                i++; // 줄 갯수만큼 i를 증가시킴
            } 
        }catch(FileNotFoundException fe){
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(i); //0부터 i까지의 수 중에 랜덤으로 한개를 가져옴
        System.out.println("이름: "+list[j]); 
    }

    public static void main(String[] args) 
   {
      test_soon lotto= new test_soon();
        lotto.countName();
        lotto.saveName();
        lotto.readName();
   }
  
}