import java.io.*;

//file -> monitor 
class C 
{
	FileInputStream is; //����  
	FileOutputStream os; //���� 
	String src = "C:/SOO/Java/�����ڹ�.java";
	String dest = "r.txt";
	C(){
		
		try{
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			//os = System.out;
		}catch(FileNotFoundException fe){
		}
	}
	void rw2(){
		byte[] bs = new byte[512]; 
		try{
			int count = 0; 
			while((count = is.read(bs)) != -1){
				os.write(bs, 0, count);
			}
			System.out.println("���缺��!");
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
		C c = new C();
		c.rw2();
	}
}
