import java.io.*;
import java.util.*;

class Lotto 
{
	String fname = "우리반.txt";
	Lotto(){
		FileReader fr = null; // 파일을 불러온다
		BufferedReader br = null; //한 줄을 불러온다
		String name = ""; //초기화
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){ //while문이 반복할 동안 한줄씩 읽는다
				pln("name: "+name);
				i++; 
			}
			pln("총 "+i+"명 검색 완료!!");
		}catch(FileNotFoundException fe){
			pln(fname+"파일을 찾지 못했음");
		}catch(IOException ie){
		}
	}
    
    String strs[] = {"쇼크","퓨전","아웃로즈","드래곤즈"}; //선언및 생성
    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
     }

	void pln(String str){
		System.out.println(str);
	}

    Random r = new Random();
	void m(){
		int i = r.nextInt(32); //0~(n-1)
		System.out.println("i: " + i);
	}
	public static void main(String[] args) 
	{
		new Ran().m();
        new Lotto();
	}

	
}
