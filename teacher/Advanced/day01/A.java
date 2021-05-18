import java.io.*;

//표준입력 & 표준출력
class A 
{
	BufferedReader br;
	PrintStream ps;
    A(){
		//br = new BufferedReader(new InputStreamReader(System.in)); //기존 
		InputStream is = System.in;//근본스트림(키보드입력) 
		Reader r = new InputStreamReader(is); //브릿지스트림 
		br = new BufferedReader(r);//목적스트림(==필터스트림==응용스트림) 

        ps = System.out;//근본스트림(모니터출력) 
	}
    void rw(){
		try{
			String line = br.readLine();
			ps.println("입력 데이터: " + line);
		}catch(IOException ie){}
	}
	public static void main(String[] args) 
	{
		A a= new A();
		a.rw();
	}
}
