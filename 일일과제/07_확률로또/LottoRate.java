import java.io.*;
import java.util.*;

class LottoRate {
    
    String dFile = "list.txt"; //불러올 파일 디폴트값
    FileReader fr; 
    BufferedReader br;
    String name;

    String name2;

    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  
    String winner;
    int rate;
    
    LottoRate(){ 

        saveList();
        cut();
        extract();
    }

    //1. 2에서 파일을 못찾으면 실행
    void findFile(){
        String sFile = "";
        try{
            System.out.print("불러올 파일 직접 입력: ");
            sFile = brkey.readLine();
            fr = new FileReader(sFile);
            br = new BufferedReader(fr);
            String line = "";
            while((line=br.readLine()) !=null){ //줄이 null이 아니면 읽음
                line = line.trim(); //공백 삭제
                if(line.length() !=0){
                    list.add(line); 
                    pln(line);
                }
            } 
        }catch(FileNotFoundException fe){
        }catch(IOException ie){
        }
    }

    //2. 불러온 파일을 읽어서 공백이 있다면 공백을 제거하고 없다면 가변배열에 저장
    ArrayList<String> list =  new ArrayList<String>();
    void saveList(){ 
        try{
            fr = new FileReader(dFile); //파일 읽기
            br = new BufferedReader(fr); //버퍼를 이용해서 읽음
            String line = "";
            while((line=br.readLine()) !=null){ //줄이 null이 아니면 읽음
                line = line.trim(); //공백 삭제
                if(line.length() !=0){
                    list.add(line); 
                }
            } 
        }catch(FileNotFoundException fe){
            pln("파일을 찾지 못했어요 :(");
            findFile();
        }catch(IOException ie){
        }
    }

   //3. 배열에서 조작대상 찾기
   ArrayList<String> wList = new ArrayList<String>();
   void cut(){
       for(String name: list){
            int idx = name.indexOf(" ");
            //System.out.println(idx);
            if(idx != -1) { // " "가 포함되어있지 않으면 -1을 반환함, 포함되어있을때 실행
                name2 = name;
                winner = name.substring(0, idx); // 이름 저장
                String wRate = name.substring(idx); // " "부터 끝까지를 문자열로 저장
                wRate = wRate.trim(); // 위에서 나온 문자열 예)"    50"의 좌우공백 제거
                rate = Integer.parseInt(wRate); // 위에서 나온 문자열 예)"50"을 Integer로 형변환
                for(int i=0 ; i<rate ; i++){
                    wList.add(winner);
                }
            }
        }
    }
   void extract(){
        Random random = new Random();
        int ran = random.nextInt(100); 
        if (ran < wList.size()){
            pln("당첨자 : " + winner);

        } else{
            list.remove(name2);
            ran = random.nextInt(list.size());
            pln("당첨자 : "+list.get(ran));
        }
    }

    void pln(String str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new LottoRate();

	}  
}
