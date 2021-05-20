import java.io.*;
//File에서 모니터
public class C { //주제 : BufferedReader / PrintWriter

    FileReader fr;//Node
    BufferedReader br;//Filter
    PrintStream ps = System.out; //Node 프린트스트림은 아웃풋스트림의 자식
    PrintWriter pw; //Filter

    String fName = "C.java";

    C(){
        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr, 2048);
            pw = new PrintWriter(ps,true); //오토플러시 사용
        } catch (FileNotFoundException fe) {
        }
    }

    void rw(){
        String line = "";
        try {
            while((line=br.readLine()) !=null){
                pw.println(line);
            }
            pw.println("출력완료");
            
        } catch (IOException ie) {
        }finally{
            try {
                if(pw != null) pw.close();
                if(ps != null) ps.close();
                if(br != null) br.close();
                if(fr != null) fr.close();

            } catch (IOException ie) {
            }
        }
    }

    public static void main(String[] args) {
        C c = new C();
        c.rw();
    }
}
