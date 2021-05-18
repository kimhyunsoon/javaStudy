import java.io.*;
import java.util.*;

class LottoC  
{
	String fname = "우리반.txt";
	ArrayList<String> names = new ArrayList<String>();
	Random r = new Random();
    int count;
	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    String line = ""; //읽은 파일이름 

	int idx;  //당첨번호 
	LottoC(){
        readFileName();
		
		showResult();
		idx = r.nextInt(names.size()); //당첨자 인덱스
		//showNames(); //읽은 파일 리스트
		showLotto();
	}
	void readFileName(){
		try{
			p("읽을 파일 이름(기본:우리반.txt): "); 
	     	line = brKey.readLine();
		    if(line != null) line = line.trim();
			if(line.length() == 0) line = fname; 
			fr = new FileReader(line);
			//pln(line+"파일을 찾음");
			
		}catch(FileNotFoundException fe){
			//pln(line+"파일을 찾지 못했음");
			readFileName();
		}catch(IOException ie){
		}
	}
	void showResult(){
		FileReader fr = null;
		BufferedReader br = null;
		String name = "";
		try{
			fr = new FileReader(line);
			br = new BufferedReader(fr);
			int i = 0; 
			while((name = br.readLine()) != null){
				names.add(name);
			}
		}catch(IOException ie){}
	}
	void showNames(){
		for(String name: names){
			pln("name: " + name);
		}
	} 
    void showLotto(){
		pln("당첨자: " + names.get(idx));
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		new LottoC();
	}
}
