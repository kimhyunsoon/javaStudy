import java.util.*;
import java.io.*;

class Homework 
{
	String fName = "우리반.txt";
	Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
	ArrayList<String> listInDir = new ArrayList<String>();
	
	void readF(){ //(1)
		File f = new File(fName);
		if(f.exists()) {
			saveToTable(f);
		}
		else pln("명단 파일("+fName+")을 넣어주세요");
	}
	void saveToTable(File f){
		BufferedReader brF = null;
		try{
			String line = "";
			brF = new BufferedReader(new FileReader(f));
			while((line = brF.readLine()) != null){
				line = line.trim();
				if(line.length() != 0){
					table.put(line, false);
				}
			}
			//testTable(); 
			readD();
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
	}
	/*void testTable(){
		Set<String> keys = table.keySet();
		for(String key : keys) pln(key +" , " + table.get(key));
		int size = table.size();
		pln("총: " + size + "명");
	}*/


    BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	void readD(){ //(2)
		String line = "";
		p("숙제검사 디렉토리: "); 
		try{
			line = brKey.readLine();
			File d = new File(line);
			if(d.exists()) {
				if(d.isFile()){
					pln("어.. 파일은 안되요. 디렉토리를 입력해주세요");
					readD();
				}else{
					//pln("pass");	
					saveToListInDir(d);
				}
			}else {
				pln("다시 입력해주세요..디렉토리를 찾지 못했어요");
				readD();
			}
		}catch(IOException ie){
		}
	}
	void saveToListInDir(File d){
		File kids[] = d.listFiles();
		for(File kid : kids) {
			String name = kid.getName();
			if(!name.equals("teacher")){
				if(!kid.isFile()){
					listInDir.add(name);
				}
			}
		}

		//testListInDir();	
	}
	/*void testListInDir(){
		for(String name : listInDir) pln(name);
	}*/
	
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Homework hw = new Homework();
		hw.readF();
	}
}

/*
 (1) 학생명단 파일을 읽어서 Map 저장 
     cf) Hashtable<String, Boolean>
 (2) 숙제 디렉토리 입력 
     ( 해당 디렉토리가 존재 여부 )
 (3) 숙제 디렉토리 하위의 폴더를 읽어서 배열(List)에 저장 
     cf) ArrayList
 (4) Map(학생명단)의 데이터와 Array데이터를 비교해서 Map의 value를 변경 
 (5) 변경된 Map의 key값을 출력 

*/