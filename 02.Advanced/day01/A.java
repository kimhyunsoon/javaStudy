import java.io.*;
public class A {

    
    BufferedReader br;
    PrintStream ps;
    A(){
        
        // InputStream 시스템이라는 클래스와 in이라는 멤버가 결합해서 나오는 반환타입
        InputStream is = System.in; //근본스트림(키보드 입력), 표준 입력
        Reader r = new InputStreamReader(is); //브릿지스트림
        br = new BufferedReader(r); //목적스트림(필터스트림==응용스트림)
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결론 : br이 키보드와 연결되어 있다
        //유연성을 가지고 있다

        ps = System.out; //근본스트림(모니터출력), 표준출력dd


    }
    void readw(){
        try {
            String line = br.readLine();
            ps.println("입력데이터: "+line);
        } catch (IOException ie) {
            //TODO: handle exception
        }


    }

    public static void main(String[] args) {
        A a = new A();
        a.readw();
        
    }
}
