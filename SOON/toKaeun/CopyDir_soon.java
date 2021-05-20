import java.io.*;
public class CopyDir_soon {
    BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    int selCut;
    String originName;
    String originType;
    String copyName;

    CopyDir_soon(){
        robotTalk("파일&폴더의 복사와 잘라내기를 한번에! 파폴복잘입니다. (ver 1.0)");
        select();
    }

    void select(){
        System.out.println("실행할 명령을 선택하세요.");
        System.out.println("[1] 복사하기  [2] 잘라내기");
        try{
            
            String seletRead = brKey.readLine();

            if( seletRead.equals("1") || seletRead.contains("복사") ) {
                selCut = 1;
                robotTalk("[1] 복사하기 명령을 실행합니다.");
                inputOrigin();
            } else if( seletRead.equals("2") || seletRead.contains("잘라") ) {
                selCut = 2;
                robotTalk("[2] 잘라내기 명령을 실행합니다.");
                inputOrigin();
            } else {
                robotTalk("Warning! 잘못된 입력 입니다. 번호 혹은 한글로 입력해주세요.");
                select();
            }

        } catch(Exception e) {}
    }
    void inputOrigin(){
        File fr = null;
        try{
            System.out.println("복사할 파일 혹은 폴더를 입력하세요.");
            
            originName = brKey.readLine();
            originName = originName.trim();
            originName = originName.replaceAll("\"", "");
            
            fr = new File(originName);
            if(fr.exists()){
                if (fr.isFile()) {
                    originType = "file";
                } else if(fr.isDirectory()) {
                    originType = "dir";
                }else {
                    robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세요.");
                    inputOrigin();
                }
            } else {
                robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세요.");
                inputOrigin();
            }
            inputCopy();
        } catch(Exception e) {}
    }
    void inputCopy(){
        File fr = null;
        try{
            System.out.println("붙혀넣을 폴더를 입력하세요.");
            copyName = brKey.readLine();
            copyName = originName.trim();
            copyName = originName.replaceAll("\"", "");
            
            fr = new File(copyName);
            if(fr.exists()){
                if(fr.isDirectory()) {
                    // 여기에 다음스텝 메쏘드
                }else {
                    robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세요.");
                    inputCopy();
                }
            } else {
                robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세요.");
                inputCopy();
            }
        } catch(Exception e) {}
    }


    void robotTalk(String a){
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("    "+a);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("");
    }

    public static void main(String arg[]) {
        CopyDir_soon cdr = new CopyDir_soon();
    }
    
}
