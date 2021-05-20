import java.io.*;
//File->모니터
public class CCC { //주제: BufferedReader & PrintWriter  
    
    String fname = "CCC.java";
    FileReader fr; //Node
    BufferedReader br; // Filter
    PrintStream ps = System.out; //node
    PrintWriter pw; //filter

    CCC(){
        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr,2048);
            pw = new PrintWriter(ps, true);
        } catch (FileNotFoundException e) {
        }
    }

    
    void rw(){
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            pw.println("출력완료");

        } catch (IOException e) {
        } finally{
            try{
				if(pw != null) pw.close();
				if(ps != null) ps.close();
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
        }
    }


    public static void main(String[] args) {
        CCC ccc = new CCC();
        ccc.rw();
        
    }


}
