import java.io.*;
import java.util.*;

class LottoRate {
    
    String fName = "우리반리스트.txt"; //불러올 파일 디폴트값
    String sList; //읽은 파일 이름
    FileReader fr; 
    BufferedReader br;
    BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
    String name;
    
    
    LottoRate(){ 

        findFile();
        out();
        
    
        

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

   //3. 배열 출력해보기
   void out(){
        for(String name: list){
            System.out.println("name: "+name);
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
