import java.io.*;
import java.util.*;

class soon {
    // [1. 학생목록 불러오기] 에서 컨트롤
    String studentListFile = "우리반.txt";
    ArrayList<String> studentList = new ArrayList<String>();

    // [2. 날짜 입력 받기] 에서 컨트롤
    String defaltPath ="숙제/";
    File defaltPathArr[] = new File(defaltPath).listFiles();
    
    String dirName;

    soon(){
        studentArrayAdd();
    }
    
    // 1. 학생목록 불러오기
    void studentArrayAdd(){
        try{
            FileReader fr = new FileReader(studentListFile); 
            BufferedReader br = new BufferedReader(fr);
            String name;
            while((name = br.readLine()) !=null){
                studentList.add(name);
            }
            dateSelect(); // 학생목록 파일이 있으면 [2. 날짜 입력 받기] 로 넘어감

        }catch(FileNotFoundException fe){
            pln("학생목록("+studentListFile+") 파일이 없습니다.");
            return; // 종료
        }
        catch(IOException ie){
        }
    }
    
    // 2. 날짜 입력 받기
    void dateSelect(){
        Scanner s = new Scanner(System.in);
        pln(" ");
        pln("--------------------숙제 검사 하기--------------------");
        pln(" ");
        pln("학생목록: "+studentListFile);
        p("숙제목록: ");

        for (int i=0; i<defaltPathArr.length; i++){
            p("["+defaltPathArr[i].getName()+"] ");
        }
        
        pln(" ");
        pln(" ");
        System.out.print("몇 일의 숙제를 검사할까요?: ");
        
        dirName = defaltPath + s.next();
        dateCheck();
    }

    // 3. 해당 날짜 폴더 검사
    void dateCheck(){
        String dirPathArr[] = new File(dirName).list(); // {폴더명}.list() : {폴더명}의 하위폴더를 일반배열로 반환함

        if(new File(dirName).exists()){ // 입력받은 날짜명의 폴더가 존재하면
            if(dirPathArr.length == 0){
                pln(" ");
                pln("--------------------숙제 검사 결과--------------------");
                pln(" ");
                pln("아무도 제출하지 않았어요....");
                pln(" ");
                return;
            } else {
                for(int i=0; i<dirPathArr.length; i++){
                    // {찾을배열}.indexOf({찾는값}) : 있는 경우 -1을반환함
                    if(studentList.indexOf(dirPathArr[i]) != -1) { 
                        studentList.remove(dirPathArr[i]);
                    }
                }
            }
            result();
            
        } else { // 입력받은 날짜명의 폴더가 존재하지 않으면
            pln(" ");
            pln(dirName + " 파일이 없습니다.");
            studentArrayAdd(); // 처음으로 돌아감
        }
    }

    // 3. 검사 결과 출력
    void result(){ 
        pln(" ");
        pln("--------------------검사 결과--------------------");
        pln(" ");
        if(studentList.size() == 0){
            pln("축하합니다! 전부 다 제출했어요!");
            pln(" ");
        }else {
            p("미제출자: ");
            for(String notSubmitName : studentList) {
                p(" [" + notSubmitName + "] ");
            }
            pln(" ");
        }
    }

    void p(String a){ // 출력함수 1 (인라인)
        System.out.print(a);
    }
    void pln(String a){ // 출력함수 2
        System.out.println(a);
    }

    public static void main(String[] args) {
        new soon();
    }
}