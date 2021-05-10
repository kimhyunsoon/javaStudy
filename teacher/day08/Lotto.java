import java.io.*;
import java.util.*;

class Lotto  
{
	String fname = "우리반.txt";
	String names[];
	Random r = new Random();
    int count;
	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    String line = ""; //읽은 파일이름 

	int idx;  //당첨번호 
	Lotto(){
        readFileName();
		names = new String[count]; //배열객체 생성 
		idx = r.nextInt(names.length); //당첨자 인덱스 

		showResult();
		showNames(); //읽은 파일 리스트
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
			readFileCount();
		}catch(FileNotFoundException fe){
			//pln(line+"파일을 찾지 못했음");
			readFileName();
		}catch(IOException ie){
		}
	}
	void readFile(){
		BufferedReader br = null;
		String name = "";
		try{
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
				names[i] = name;
				i++;
			}
		}catch(IOException ie){
		}
	}
	void readFileCount(){
		BufferedReader br = null;
		String name = "";
		try{
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
				i++;
			}
			count = i;
		}catch(IOException ie){
			count = -1;
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
				names[i++] = name;
			}
		}catch(IOException ie){}
	}
	void showNames(){
		for(int i=0; i<names.length; i++){
			pln("names["+i+"]: " + names[i]);
		}
	} 
    void showLotto(){
		//for(int i=0; i<names.length; i++){
			pln("당첨자: " + names[idx]);
		//}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		new Lotto();
	}
}
