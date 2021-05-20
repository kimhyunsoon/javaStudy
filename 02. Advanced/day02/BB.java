import java.io.*;

//키보드 입력받아서 파일로인데
//이제는 2byte를 곁들인
public class BB {
    InputStream is = System.in; //기본입력스트림
    Reader r; //문자기반스트림(입력)의 abstract class
    Writer w; //문자기반스트림(출력)의 abstract class
    String fname = "BBtest.txt";

    BB(){
        try {
            r = new InputStreamReader(is); 
            //InputStream(1byte)을 Reader(2byte)로 바꾸는 브릿지
            w = new FileWriter(fname); //node
        } catch (IOException ie) {}
    }

    void rw1(){
        try {
            // int c = r.read(); //Reader 클래스의 메소드. Reads a single character.
            // w.write(c); //Writer 클래스의 메소드. Writes a single character.
            // w.flush();
            int c = 0;
            while ((c = r.read()) != -1) {
                w.write(c);
                w.flush();
            }

        } catch (Exception e) {
        } finally{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
    }

    void rw2(){
        try {
            char cs[] = new char [8];
            int count = 0;
            while ((count=r.read(cs)) != -1) {
                w.write(cs, 0, count);
                w.flush();
                
            }
        } catch (Exception e) {
        }{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
    }




    public static void main(String[] args) {
        BB bb = new BB();
        // bb.rw1();
        bb.rw2();
        
    }

    
}
