import java.io.*;

//keyboard -> file 
class B 
{
	InputStream is; //Ű���� 
	OutputStream os; //���� 
	String fname = "r.txt";
	B(){
		is = System.in;
		try{
			os = new FileOutputStream(fname);
		}catch(FileNotFoundException fe){
		}
	}
	void rw1(){
		try{
			int b = 0;
			while((b=is.read()) != -1){
				os.write(b);
				if(b == 13) break;
			}
			os.flush();
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
	}
	void rw2(){ //���� ���� ���� 
		byte[] bs = new byte[512]; //����� 
		try{
			int count = 0; 
			while((count = is.read(bs)) != -1){
				os.write(bs, 0, count);
			}
			os.flush();
		}catch(IOException ie){
		}finally{
			try{
				is.close();
				os.close();
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
