import java.io.*;

//File -> Monitor 
class C //주제: BufferedReader & PrintWriter  
{
	String fName = "C.java";
	FileReader fr; //Node 
	BufferedReader br; //Filter 
	PrintStream ps = System.out; //Node
	PrintWriter pw; //Filter 
	C(){
		try{
			fr = new FileReader(fName);
			br = new BufferedReader(fr, 2048);

			pw = new PrintWriter(ps, true);
		}catch(FileNotFoundException fe){
		}
	}
	void rw(){
		String line = "";
		try{
			while((line=br.readLine()) != null){
				pw.println(line);
			}
			pw.println("출력완료!!");
		}catch(IOException ie){
		}finally{
			try{
				if(pw != null) pw.close();
				if(ps != null) ps.close();
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.rw();
	}
}
