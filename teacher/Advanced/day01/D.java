import java.io.*;

//file ---> ( monitor , file ) 
class D //����: BufferedInputStream & BufferedOutputStream
{
	BufferedInputStream bis;
	BufferedOutputStream bos;
	FileInputStream fis;
	FileOutputStream fos;
	OutputStream os;

	String src = "D.java";
	String src = "D_copy.txt";

	//String src = "../�ڷ��/IO.jpg";
	//String dest = "IO_copy.jpg";
	D(){		
		try{
			fis = new FileInputStream(src); //node 
			os = System.out; //node 
			fos = new FileOutputStream(dest); //node 
		}catch(FileNotFoundException fe){
		}

        bis = new BufferedInputStream(fis, 2048); //filter 
		bos = new BufferedOutputStream(fos, 2048); //filter
		//buffer size(����īƮ) : 2048 
	}
    void rw(){
		int cnt = 0;
		byte bs[] = new byte[256]; //����� 
		try{
			while((cnt = bis.read(bs)) != -1){
				bos.write(bs, 0, cnt); //to File 
				os.write(bs, 0, cnt); //to Monitor 
			}
			bos.flush();
			System.out.println("����Ϸ�("+dest+")");
		}catch(IOException ie){
		}finally{
			try{
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(fis != null) fis.close();
				if(fos != null) fos.close();
				if(os != null) os.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.rw();
	}
}
