import java.io.*;
import java.util.*;

class soon2 {
    // [1. 학생목록 불러오기] 에서 컨트롤
    String studentListFile = "우리반.txt";
    Hashtable<String,String> studentList = new Hashtable<String,String>();
    String dirName;

    soon2(){
        studentArrayAdd();
    }
    
    // 1. 학생목록 불러오기
    void studentArrayAdd(){
        try{
            FileReader fr = new FileReader(studentListFile); 
            BufferedReader br = new BufferedReader(fr);
            String name;
            while((name = br.readLine()) !=null){
                studentList.put(name, "empty");
            }
            dateSelect();

        }catch(FileNotFoundException fe){
            pln("학생목록("+studentListFile+") 파일이 없습니다.");
            return; // 종료
        }
        catch(IOException ie){
        }
    }
    
    // 2. 경로 입력 받기
    void dateSelect(){
        Scanner s = new Scanner(System.in);
        pln(" ");
        pln("--------------------숙제 검사 하기--------------------");
        pln(" ");
        pln("학생목록: "+studentListFile);
        pln(" ");
        System.out.print("숙제 폴더 경로를 입력하세요.: ");
        
        dirName = s.next();
        dateCheck();
    }

    // 3. 해당 날짜 폴더 검사
    void dateCheck(){
        String dirPathArr[] = new File(dirName).list(); // {폴더명}.list() : {폴더명}의 하위폴더를 일반배열로 반환함

        if(new File(dirName).exists()){ // 입력받은 숙제 폴더가 존재하면
            if(dirPathArr.length == 0){
                pln(" ");
                pln("--------------------숙제 검사 결과--------------------");
                pln(" ");
                pln("아무도 제출하지 않았어요....");
                pln(" ");
                return;
            } else {
                for(int i=0; i<dirPathArr.length; i++){
                    if(studentList.containsKey(dirPathArr[i])) { 
                        studentList.replace(dirPathArr[i], dirPathArr[i]);
                    }
                }
            }
            result();
            
        } else { // 입력받은 날짜명의 폴더가 존재하지 않으면
            pln(" ");
            pln(dirName + " 파일이 없습니다.");
            return; // 종료
        }
    }

    // 3. 검사 결과 출력
    void result(){ 
        pln(" ");
        pln("--------------------숙제 검사 결과--------------------");
        pln(" ");
        if(!studentList.containsValue("empty")){
            pln("축하합니다! 전부 다 제출했어요!");
            pln(" ");
        }else {
            p("미제출자: ");
            Enumeration<String> e = studentList.keys();
            while (e.hasMoreElements())
            {
                String key = e.nextElement();
                String val = studentList.get(key);
                if ( val == "empty") {
                    p(" ["+key+"] ");
                }
            }	
            pln(" ");
        }
    }

    void out(){
		Enumeration<String> e = studentList.keys();
		while (e.hasMoreElements())
		{
			String key = e.nextElement();
			String val = studentList.get(key);
			System.out.println("key: "+key+", val"+val);
		}	
	}

    void p(String a){ // 출력함수 1 (인라인)
        System.out.print(a);
    }
    void pln(String a){ // 출력함수 2
        System.out.println(a);
    }

    public static void main(String[] args) {
        new soon2();
    }
}