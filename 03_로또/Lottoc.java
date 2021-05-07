import java.io.*;
import java.util.*;


class Lottoc 
{
	
	String fname = "우리반.txt"; //파일이름 선언
	String names[] = new String [32]; 
	Random r = new Random();

	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader (system.in)); 
	
	int idx; //당첨자 인덱스
	Lotto(){
		idx = r.nextInt(names.length); //결과를 당첨번호에 저장
		
	}
	
	void readFileName(){//파일이름 읽는 함수
		String line="";
		try{
			System.out.println("읽을 파일 이름 (기본 : 우리반.txt)");
			line = brKey.readLine();
			if(line !=null)
		
		}
	
	}	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
