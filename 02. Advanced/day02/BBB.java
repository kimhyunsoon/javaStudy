import java.io.*;
public class BBB {
    InputStream is = System.in; //키보드로 입력받는 표준입력. 반환타입이 인풋스트림(abstract)
    String fname = "BBBtest.txt";
    Reader r; //node, 부모클래스
    Writer w; //node, 부모클래스

    BBB(){
        try {
            r = new InputStreamReader(is); //브릿지스트림, 인풋스트림이 1byte스트림이라서
            w = new FileWriter(fname);
        } catch (IOException ie) {
        }
    }

    void rw1(){
        int c = 0;
        try {
            while ((c=r.read()) != -1) {
                w.write(c);
                w.flush();
            }
        } catch (IOException e) {
        } finally{
            try {
                if(r != null) r.close();
                if(w != null) w.close();
            } catch (IOException e) {}
        }
    }

    void rw2(){
        char cs[] = new char[8];
        int cnt = 0;
        try {
            while ((cnt = r.read(cs)) != -1) {
                w.write(cs, 0, cnt);
                w.flush();
            }
        } catch (IOException ie) {
        } finally{
            try {
                if(r != null) r.close();
                if(w != null) w.close();
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        BBB bbb = new BBB();
        // bbb.rw1();
        bbb.rw2();
        
    }
}
