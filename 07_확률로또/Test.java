import java.io.*;
import java.util.*;

class Test {
    
    String dFile = "list.txt"; //불러올 파일 디폴트값
    FileReader fr; 
    BufferedReader br;
    String name;
    boolean defaultFile = true;
     //읽은 파일 이름
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));  

    Test(){ 

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
        }
        catch(IOException ie){
        }
    }

    //3. 배열에서 조작 대상 찾기
    String winner; //조작대상
    int rate; //확률
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    void cut(){
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            name = iter.next();
            int idx = name.indexOf(" ");
            //System.out.println(idx); (공란이 포함되어 있지 않으면 -1 반환 확인)
            if(idx !=-1){ // 공란 포함되어 있을 때 실행
                winner = name.substring(0, idx); 
                //pln(name); //확률 써있는 사람 이름 확인
                String wRate = name.substring(idx);
                if(wRate.length() !=0){
                    wRate = wRate.trim();
                    //pln(wRate); //확률 확인
                }
                rate = Integer.parseInt(wRate); //int로 형변환
                if(rate == 0){
                    iter.remove(); //rate가 0인 애들 제거
                }else{
                    map.put(winner,rate); //table에 확률 조작된 애들을 확률과 함께 저장
                   //pln(winner);

                }
            }
        }
    }

    ArrayList<String> wList =  new ArrayList<String>();
    void setArray(){
        Set<String> keys= map.keySet();
        for(String key : keys){
            for(int i=0; i<map.get(key); i++){
                wList.add(key);
                pln(key);
            }

        }
        
    }

    void ran100(){
        Random random = new Random();
        int ran = random.nextInt(100); //0~100 사이의 임의의 수
        int i = 0;
        Set<String> names = map.keySet();
        

        
        

    }



    void pln(String str){
        System.out.println(str);
    }



   public static void main(String[] args) {
       Test test = new Test();
       test.saveList();
       test.cut();
       test.setArray();


       
   }
}