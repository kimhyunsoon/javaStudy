import java.io.*;
import java.util.*;

class LottoRate {
    
    String fName = "teacher/list.txt"; //불러올 파일 디폴트값
    String sList; //읽은 파일 이름
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;
    String winner;
    int rate;
    
    
    LottoRate(){ 

        findFile();
        cut();
        winnerLotto();
    
        

    }

 
	//1. 파일 불러오기, 아무것도 입력하지 않으면 디폴트값 불러옴
    
	void findFile(){  //1. 리스트파일 불러오기
		try{
			System.out.print("리스트 파일(기본 : 우리반리스트.txt): ");
			sList = brkey.readLine();
			if(sList !=null){// 공백 삭제
				sList = sList.trim();
			};   
			if(sList.length()==0){ //입력받지 않으면 디폴트값을 list에 넣음
				sList = fName;
			};
			fr = new FileReader(sList);
			File f = new File(sList);
            saveName(f);
		}catch(FileNotFoundException fe){
			pln("파일을 찾지 못했어요 :(");
			findFile();
		}catch(IOException ie){
		}
	}

    //2. 불러온 파일을 읽어서 공백이 있다면 공백을 제거하고 없다면 가변배열에 저장
    ArrayList<String> list =  new ArrayList<String>();
    void saveName(File f){ 
        try{
            fr = new FileReader(f); 
            br = new BufferedReader(fr);
            String name = "";
            while((name=br.readLine()) !=null){
                name = name.trim();
                if(name.length() !=0){
                    list.add(name); 
                }
            } 
        }catch(FileNotFoundException fe){
        }
        catch(IOException ie){
        }
   }

   //3. 배열에서 조작대상 찾기
   
   void cut(){
       for(String name: list){
           
           System.out.println(idx);
           if(idx != -1) { // " "가 포함되어있지 않으면 -1을 반환함, 포함되어있을때 실행
               winner = name.substring(0, idx); // 이름 저장
               String rateStr = name.substring(idx); // " "부터 끝까지를 문자열로 저장
               rateStr = rateStr.trim(); // 위에서 나온 문자열 예)"    50"의 좌우공백 제거
               rate = Integer.parseInt(rateStr); // 위에서 나온 문자열 예)"50"을 Integer로 형변환
           }
       }
   }
   void winnerLotto(){
        Random r = new Random();
        int k = r.nextInt(100); // 0~99중 1개의 숫자를 랜덤으로 k에 저장
        if ((k+1) <= rate){ // 예) k가 30이하일 확률은 30% 
            pln("당첨자 : " + winner); // 확률안에 들어왔다면 출력
        }else {
            System.out.println((100 - rate)+"% 의 확률을 뚫고 실패ㅠㅠ"); //아니라면 다른 행위 (winner를 배열에서 빼고 추첨하면될듯)
        }

   }


    void pln(String str){
		System.out.println(str);
	}
    void plnt(int str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new LottoRate();
		        
	}
  
}
