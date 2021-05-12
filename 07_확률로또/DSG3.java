import java.io.*;
import java.util.*;
 
class DSG3{        // Drawing Straws Game 3
    String fileName = "NameList.txt";
    FileReader fr;
    BufferedReader br;
    Random random = new Random();
    
    String name;
    int rate;
 
    Vector<String> listName = new Vector<String>();            // 확률이 없는 사람
    ArrayList<String> listNumber = new ArrayList<String>();    // 확률이 있는 사람
 
    void readFile(){
        String line = null;
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while((line=br.readLine()) != null){
                line = line.trim();
                if(line.length() != 0){
                    if((line.indexOf(" ")) != -1){
                        name = separate(line);
                        listName.add(name);
                    }else{
                        listName.add(line);
                    }
                }
            }
        }catch(FileNotFoundException fnfe){
            System.out.println(fileName + " : CAN'T FOUND");
        }catch(IOException ioe){}
    }
 
    String separate(String str){
        int idx = str.indexOf(" ");
        name = str.substring(0 , idx);
        //System.out.println("name : " + name);    
        // 숫자 있는 사람의 인덱스 이름 확인용
        String rStr = str.substring(idx);
        rStr = rStr.trim();
        rate = Integer.parseInt(rStr);
        for(int i=0 ; i<rate ; i++){
            listNumber.add(name);
        }
        return name;
    }
 
    void ran100(){
        int ran = random.nextInt(100);
        //System.out.println("확률 : " + listNumber.size() + "\n번호 : " + ran);
        if(ran < listNumber.size()){
            if(listNumber.size() > 100){
                System.out.println("확률이 100을 넘을 수 없습니다." + ran);
                System.out.println("메모장의 확률의 합을 확인해주세요.");
                System.exit(0);
            }else{
                System.out.println("당첨자 : " + listNumber.get(ran));    // 확률있는 당첨자
            }
        }else{
            listName.remove(name);
            ran = random.nextInt(listName.size());
            System.out.println("당첨자 : " + listName.get(ran));        // 확률없는 당첨자
        }
    }
 
    public static void main(String[] args){
        DSG3 dsg3 = new DSG3();
        dsg3.readFile();
        dsg3.ran100();
    }
}


출처: https://seokho-j0308.tistory.com/51 [까막눈]