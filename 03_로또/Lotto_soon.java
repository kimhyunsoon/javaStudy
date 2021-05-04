import java.io.*;
import java.util.*;

class Lotto_soon {
    String fname = "설정/우리반.txt"; // 파일 경로
    BufferedReader br = null; // 파일 읽는 변수종류 인듯
    FileReader fr = null; // 파일 읽는 변수종류 인듯

    Lotto_soon() {
        String name = ""; // 학생이름 빈 변수

        try{
            // 파일의 학생수 구함
            fr = new FileReader(fname); // 새로 파일읽음
            br = new BufferedReader(fr); // 새로 파일읽음
            int i =0; 
            while(br.readLine() != null){ // 파일의 줄이 비어있지 않으면 실행
                i++; // 줄 갯수 (학생수) 만큼 i를 증가시킴
            };
            

            //배열을 생성하고 파일의 이름들을 대입함
            fr = new FileReader(fname); // 새로 파일읽음
            br = new BufferedReader(fr); // 새로 파일읽음
            int j=0;
            String[] List = new String[i]; // 길이가 i인 빈 배열 선언

            while((name = br.readLine()) != null){ // 파일의 줄을 대입한 name이 비어있지 않으면 실행
                List[j] = name; // List배열 j번째 요소에 파일의 j번째 줄을 대입함
                j++; // 줄 갯수 (학생수) 만큼 j를 증가시킴
            };


            //랜덤으로 출력함
            Random r = new Random();
            int k = r.nextInt(i); // 0 부터 i(학생수) 까지의 수 중에 랜덤으로 한개를 가져옴
            System.out.println("랜덤학생이름: " + List[k]);

            

        }catch(FileNotFoundException fe){
            System.out.println(fname+"파일을 찾지 못했음");
        }catch(IOException ie){
        }
    }
    
	
    public static void main(String[] args) 
	{
        new Lotto_soon();
	}
}