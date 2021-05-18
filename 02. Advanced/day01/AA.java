import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

public class AA {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // System.out.println();
    // 해체해보기

    BufferedReader br;
    PrintStream ps;
    
    AA(){
        //InputStream : 추상클래스, 바이트의 입력 스트림을 나타내는 모든 클래스의 슈퍼 클래스입니다.
        InputStream is = System.in; // in : 키보드로 입력받는 근본스트림, 표준입력
        Reader r = new InputStreamReader(is); // 브릿지 스트림 인풋스트림과 리더 연결
        br = new BufferedReader(r); //목적스트림

        ps = System.out;

    }

    void rw(){
        try {
            String line = br.readLine();
            ps.println("입력데이터: "+line); 
            
        } catch (IOException ie) {
        }
    }

    public static void main(String[] args) {
        AA aa = new AA();
        aa.rw();
        
    }

}
