import java.io.*;

class Listing  
{
	String fname = "우리반.txt";
	Listing(){
		FileReader fr = null; // 파일을 불러온다
		BufferedReader br = null; //한 줄을 불러온다
		String name = ""; //초기화
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){ //while문이 반복할 동안 한줄씩 읽는다
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
