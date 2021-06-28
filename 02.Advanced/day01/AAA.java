import java.io.*;

public class AAA {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintStream ps;

    AAA(){

        ps = System.out; //근본스트림, 표준출력
        
    }

    void rw(){

        try {
            String line = br.readLine();
            ps.println("입력데이터: "+line);
            
        } catch (IOException ie) {
        }

    }

    

    public static void main(String[] args)  {
        AAA aaa = new AAA();
        aaa.rw();
        
    }

}
