import java.io.*;
//파일 받아서 모니터로

public class CC {
    String fname = "CC.java";
    FileReader fr; //node 문자기반스트림
    BufferedReader br; //filter
    PrintStream ps = System.out; //node
    PrintWriter pw; //filter
    
    CC(){
        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr,2048); 

            pw = new PrintWriter(ps,true); //auto flush 가능
        } catch (FileNotFoundException fe) {
        }
    }

    void rw(){
        String line = "";
        try {
            while((line = br.readLine()) != null){//스트림 끝에 도달한 경우 null로 반환
                pw.println(line); //PrintWriter의 println 메소드 이용
            }
            pw.println("출력 완료!");
        } catch (IOException ie) {
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
        CC cc = new CC();
        cc.rw();
        
    }
    
}
