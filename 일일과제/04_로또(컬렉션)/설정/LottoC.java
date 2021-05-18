import java.io.*;
import java.util.*;

class LottoC  
{
	String fname = "�츮��.txt";
	ArrayList<String> names = new ArrayList<String>();
	Random r = new Random();
    int count;
	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    String line = ""; //���� �����̸� 

	int idx;  //��÷��ȣ 
	LottoC(){
        readFileName();
		
		showResult();
		idx = r.nextInt(names.size()); //��÷�� �ε���
		//showNames(); //���� ���� ����Ʈ
		showLotto();
	}
	void readFileName(){
		try{
			p("���� ���� �̸�(�⺻:�츮��.txt): "); 
	     	line = brKey.readLine();
		    if(line != null) line = line.trim();
			if(line.length() == 0) line = fname; 
			fr = new FileReader(line);
			//pln(line+"������ ã��");
			
		}catch(FileNotFoundException fe){
			//pln(line+"������ ã�� ������");
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
		pln("��÷��: " + names.get(idx));
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
