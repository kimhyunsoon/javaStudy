import java.io.*;
import java.util.*;

class LottoM {
    String fileName;
    FileReader fr; 
    BufferedReader br;

	Scanner s = new Scanner(System.in);

    LottoM(){ 
        
		System.out.println("파일이름을 입력해주세요: ");
        String str = s.next();
        fileName = str + ".txt"; //입력받은 값(우리반)을 fileName에 저장

		
    }
    
	//가변배열을 사용하기 때문에 배열 사이즈를 카운트할 필요가 없어짐
 
	ArrayList<String> list =  new ArrayList<String>();
    
	void saveName(){ 
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            while((name=br.readLine()) !=null){
                list.add(name); //while 반복문이 실행되는 동안 list라는 배열 변수에 데이터가 추가됨
            } 
        }catch(FileNotFoundException fe){
            System.out.println("파일이름을 찾을 수 없습니다.");
        }
        catch(IOException ie){
        }
   }

   void readName(){
        Random r = new Random();
        int j = r.nextInt(list.size()); //0부터 i까지의 수 중에 랜덤으로 한개를 가져옴
        System.out.println("이름: "+list.get(j));
    }

    public static void main(String[] args) 
	{
		LottoM lotto= new LottoM();
		lotto.saveName();
		lotto.readName();
        
	}
  
}
