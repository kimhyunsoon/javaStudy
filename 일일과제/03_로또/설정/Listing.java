import java.io.*;

class Listing  
{
	String fname = "우리반.txt";
	Listing(){
		BufferedReader br = null;
		FileReader fr = null;
		String name = "";
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
				pln(name);
				i++;
			}
			pln("총 "+i+"명 검색 완료!!");
		}catch(FileNotFoundException fe){
			pln(fname+"파일을 찾지 못했음");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new Listing();
	}
}
