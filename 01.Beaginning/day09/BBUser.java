import java.io.*;
class BBUser {//입력오류 예외처리

    void m1(){
        
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("a.txt");

        } catch(FileNotFoundException e) { 
            System.out.println(e); //파일이 없으면 catch 블록 실행
            return; //리턴이 있어도 아래 finally 블록 강제 실행
        } finally {
            if (fis != null) {
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                
            }
            System.out.println("finally 때문에 항상 수행됨");
        }
        System.out.println("여기도 수행됨");
    }

    
    


    public static void main(String[] args) {
        BBUser bb = new BBUser();
        bb.m1();
        
    
    }

}
