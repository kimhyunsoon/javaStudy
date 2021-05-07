import java.io.*;
import java.util.*;

class Lotto_noReturn {
    String fileName;
    FileReader fr; 
    BufferedReader br;
    // int count; 변경됨
    ArrayList<String> list = new ArrayList<String>(); // 변경됨 (가변배열 선언 및 생성)
    Scanner s = new Scanner(System.in);

    Lotto_noReturn(){ 
        System.out.print("파일이름을 입력해주세요: "); // 변경됨_println -> print (줄바꿈 없앰)
        String str = s.next();
        fileName = str + ".txt";
    }
    
    // 변경됨_countName(); (줄 갯수를 카운트할 필요가 없어짐)
    // void countName(){
    //     try{
    //         fr = new FileReader(fileName); 
	// 		br = new BufferedReader(fr);
    //         while(br.readLine() !=null){ 
    //             count++;
    //         }
    //     }catch(FileNotFoundException fe){
	// 		System.out.println(fileName+"파일을 찾지 못하였습니다");
    //         return;
    //     }catch(IOException ie){
	// 	}
    // }
    
    void saveName(){
        try{
            fr = new FileReader(fileName); 
            br = new BufferedReader(fr);
            String name = "";
            // list = new String[count]; 변경됨 (카운트 변수도 없앴고 필요가 업슴)
            while((name=br.readLine()) !=null){
                list.add(name); // 변경됨 (리스트라는 배열변수에 add라는 함수를 이용해서 데이터를 집어넣는거임. 반복문 실행할 때마다 한개씩)
            } 
        }catch(FileNotFoundException fe){
            System.out.println("파일이름을 찾을 수 없습니다.");
        }
        catch(IOException ie){
        }
   }
   void readName(){
        Random r = new Random();
        int j = r.nextInt(list.size()); // 변경됨 (원래는 다른게 들어가 있었음)
        System.out.println("이름: "+list.get(j)); // 변경됨 //get 함수 이용
    }

    public static void main(String[] args) 
	{
		Lotto_noReturn lotto= new Lotto_noReturn();
        // lotto.countName(); 변경됨 //메소드가 없어졌음
        lotto.saveName();
        lotto.readName();
	}
  
}
