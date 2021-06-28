import java.io.*;
public class B { //주제: Reader / Writer
    //keyboard ->file

    InputStream is = System.in;
    String fName = "r.txt";
    Reader r ;
    Writer w ;
    
    B(){
        
        try {
            r = new InputStreamReader(is); //브릿지스트림
            w = new FileWriter(fName); //노드
            
        } catch (Exception e) {
        }

    }

    void rw(){
        try {
            // int c = r.read();
            // w.write(c);
            // w.flush();
            int c = 0;
            while ((c=r.read()) != -1) {
                w.write(c);
                if(c==13) break;
            }
            w.flush();
        } catch (IOException ie) {
            try {
                if(r != null) r.close();
                if(w != null) w.close();
            } catch (Exception e) {
            }
        }
    }

    void rw2(){
        try {
            char cs[] = new char[8];
            int count = 0;
            while ((count=r.read(cs)) != -1) {
                w.write(cs, 0 , count);
                w.flush();
            }

        } catch (IOException ie) {
        } finally{
            try {
                if(r != null) r.close();
                if(w != null) w.close();
            } catch (Exception e) {
            }
        }
    }


    public static void main(String[] args) {
        B b = new B();
        // b.rw();
        b.rw2();
    }
}
