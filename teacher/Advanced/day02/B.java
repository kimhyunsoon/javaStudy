import java.io.*;

//keyboard -> file 
class B  //주제: Reader  / Writer 
{
	InputStream is = System.in;
	String fName = "r.txt";
	Reader r;
	Writer w;
	B(){
		try{
			r = new InputStreamReader(is); //Node 
			w = new FileWriter(fName); //Node 
		}catch(IOException ie){}
	}
	void rw1(){
		try{
			//int c = r.read();
			//w.write(c);
			//w.flush();

            int c = 0; 
			while((c=r.read()) != -1){
				w.write(c);
				if(c == 13) break;
			}
			w.flush();
		}catch(IOException ie){
		}finally{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
	}
	void rw2(){ //아주 많이 나옴
		char cs[] = new char[8];
		int cnt = 0; 
			try{
			while((cnt = r.read(cs)) != -1){
				w.write(cs, 0, cnt);
				w.flush();
			}
		}catch(IOException ie){
		}finally{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		B b = new B();
		//b.rw1();
		b.rw2();
	}
}
