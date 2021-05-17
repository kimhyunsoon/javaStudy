package soon.lucky;
import java.io.*;
import java.util.*;

class Lucky {
    
    String fName = "list.txt"; //불러올 파일 디폴트값
    String sList; //읽은 파일 이름
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;

    boolean defaultFile = true;
    
    
    Lucky(){ 
        findFile();
        cut();
        totalRate();
    }

 
	//1. 파일 불러오기, 아무것도 입력하지 않으면 디폴트값 불러옴
    
	void findFile(){  //1. 리스트파일 불러오기
		try{
            if(defaultFile == false){
                pln("기본 파일을 찾지 못했어요 :(");
                System.out.print("리스트 파일(기본 : 우리반리스트.txt): ");
                sList = brkey.readLine();
                if(sList !=null){// 공백 삭제
                    sList = sList.trim();
                };
                fr = new FileReader(sList);
                File f = new File(sList);
                saveList(f);
            }else {
                fr = new FileReader(fName);
                File f = new File(fName);
                saveList(f);
            }
		}catch(FileNotFoundException fe){
            defaultFile = false;
			findFile();
		}catch(IOException ie){
		}
	}

    //2. 불러온 파일을 읽어서 공백이 있다면 공백을 제거하고 없다면 가변배열에 저장
    ArrayList<String> list =  new ArrayList<String>();
    void saveList(File f){ 
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
    String winner; //조작대상
    int rate; //확률
    HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

    void cut(){
        Iterator<String> iter = list.iterator();
		while(iter.hasNext()){ //다음이 있니? 있으면 true값 반환, 없으면 false
            name = iter.next();
            int idx = name.indexOf(" ");
            if(idx != -1){ //" "가 포함되어 있지 않으면 -1을 반환, 포함되어 있을때 실행
                winner = name.substring(0, idx); 
                String wRate = name.substring(idx);
                if (wRate.length() != 0){
                    wRate=wRate.trim();
                }
                rate = Integer.parseInt(wRate);
                if(rate == 0){
                    iter.remove();
                } else {
                    hashMap.put(winner,rate);
                }
            }
		}

    }
    void test(){
        for(String name: list){
            pln(name);
        }
    }

    void totalRate(){
        int rateNum = 0;
        
        Set<String> names = hashMap.keySet();
        

        for(String name: names){
            Integer rate = hashMap.get(name); //value값을 얻는 함수
            rateNum += rate;
        }
        
        
        readName1(rateNum);

    }
    void readName1(int rateNum){

        String[] rateArr = new String[rateNum];
        

        Random r = new Random();
        int k = r.nextInt(101); // 0~100 사이에서 임의의 수
        int i = 0;
        Set<String> names = hashMap.keySet();
        for(String name: names){
            for(int j=i; j<rateNum; j++){
                rateArr[j] = name;
            }
            i += hashMap.get(name);
        }
        
        if(k<=rateArr.length){
            pln("당첨자 : " + rateArr[k]);
        } else {
            pln(rateArr.length + "의 확률을 뚫고 안나옴.. ");
        }
    }


    void pln(String str){
		System.out.println(str);
	}



    public static void main(String[] args) 
	{
		new Lucky();
		        
	}
  
}
