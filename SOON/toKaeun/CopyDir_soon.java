import java.io.*;
public class CopyDir_soon {
    BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    String selCut;
    String originName;
    String originType;
    String copyName;
    FileInputStream fis;
    FileOutputStream fos;

    CopyDir_soon(){
        robotTalk("파일&폴더의 복사와 잘라내기를 한번에! 파폴복잘입니다. (ver 1.0)");
        inputOrigin();
    }

    void select(){
        System.out.println("원본의 삭제를 진행할까요?");
        System.out.println("[1] 삭제  [2] 보존");
        try{
            String seletRead = brKey.readLine();
            if( seletRead.equals("1") || seletRead.contains("삭제") ) {
                selCut = "삭제";
                robotTalk("[1] "+selCut+" 명령을 실행합니다.");
            } else if( seletRead.equals("2") || seletRead.contains("보존") ) {
                selCut = "보존";
                robotTalk("복사를 완료하였습니다.");
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
            copyName = copyName.trim();
            copyName = copyName.replaceAll("\"", "");
            
            fr = new File(copyName);
            if(fr.exists()){
                if(fr.isDirectory()) {
                    if(originType.equals("file")) {
                        copyFile();
                    }else if (originType.equals("dir")){
                        File originNameFile = new File(originName);
                        File copyNameFile = new File(copyName +"/"+originNameFile.getName());
                        copyDir(originNameFile, copyNameFile);
                    }
                }else {
                    robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세1요.");
                    inputCopy();
                }
            } else {
                robotTalk("Warning! 정확한 경로를 입력하거나 드래그앤드랍을 해주세요.");
                inputCopy();
            }
        } catch(Exception e) {}
    }

    void copyDir(File origin, File copy){
        
        copy.mkdir();
        File[] fileList = origin.listFiles();
        
        for(File file : fileList) {
            File temp = new File(copy.getAbsolutePath() + File.separator + file.getName());

            if(file.isDirectory()) {
                temp.mkdir();
                copyDir(file , temp);
            }else {
                try {
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(temp);
                    
                    byte[] b = new byte[4096];
                    int count = 0;
                    while((count = fis.read(b)) != -1) {
                        fos.write(b , 0 , count);
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fis.close();
                        fos.close();
                    }catch(Exception e) {}
                }
            }
        }
        select();
        if (selCut.equals("삭제")) {
            delDir(originName);
        }
    }

    void delDir(String path){		
        File folder = new File(path);
        try {
            if(folder.exists()){
                File[] folder_list = folder.listFiles(); //파일리스트 얻어오기
                
                for (int i = 0; i < folder_list.length; i++) {
                    if(folder_list[i].isFile()) {
                        folder_list[i].delete();
                    }else {
                        delDir(folder_list[i].getPath()); //재귀함수호출
                    }
                    folder_list[i].delete();
                }
                folder.delete(); //폴더 삭제
            }
        } catch (Exception e) {}
        robotTalk("원본의 삭제를 완료하였습니다.");
    }



    void copyFile(){
        try{
            File originNameFile = new File(originName);

            FileInputStream inFile = new FileInputStream(originNameFile);
            FileOutputStream outFile = new FileOutputStream(copyName + "/복사본_" + originNameFile.getName());

            int fileByte = 0; 
            while((fileByte = inFile.read()) != -1) {
                outFile.write(fileByte);
            }
            inFile.close();
            outFile.close();
            select();
            if (selCut.equals("삭제")) {
                delFile(originNameFile);
            }
        }catch (Exception e) {}
    }
    void delFile(File a){
        if (a.exists()){
            if (a.delete()){
                robotTalk("원본의 삭제를 완료하였습니다.");
            }else{
                robotTalk("Warning! 복사에 성공 하였으나, 삭제할 파일이 없습니다.");
            }
        }else{
            robotTalk("Warning! 복사에 성공 하였으나, 삭제할 파일이 없습니다.");
        }
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
