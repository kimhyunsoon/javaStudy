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
        System.out.println("파일이름을 입력해주세요: ");
        String str = s.next();
        fileName = str + ".txt"; //입력받은 값을 fileName에 저장
    }
    

    void countName(){ 
        try{
            fr = new FileReader(fileName); //fileName = "우리반.txt"를 읽는다
			br = new BufferedReader(fr); //줄 인식??
            while(br.readLine() !=null){ //메모장이 몇줄인지 확인. 파일의 줄이 비어있지 않으면 실행
                count++; //줄 갯수(학생 수)만큼 증가시킴
            }
            //System.out.println("총 "+count+"명 검색 완료!!");
        }catch(FileNotFoundException fe){
			System.out.println(fileName+"파일을 찾지 못하였습니다");
            return;
        }catch(IOException ie){
		}
    }


    void saveName(){ //배열을 생성하고 파일의 이름들을 대입함
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            int i = 0;
            list = new String[count]; //길이가 count인 빈 배열 생성
            while((name=br.readLine()) !=null){
                list[i] = name; //list 배열 i번째 요소에 파일의 i번째 줄을 대입함
                i++; // 줄 갯수만큼 i를 증가시킴
            } 
        }catch(FileNotFoundException fe){
            return;
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(count); //0부터 i까지의 수 중에 랜덤으로 한개를 가져옴
        System.out.println("이름: "+list[j]);
    }

    public static void main(String[] args) 
	{
		Lotto lotto= new Lotto();
        lotto.countName();
        lotto.saveName();
        lotto.readName();
	}
  
}
